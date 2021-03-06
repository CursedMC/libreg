@file:Suppress("DEPRECATION")

import com.modrinth.minotaur.TaskModrinthUpload
import com.modrinth.minotaur.request.VersionType

plugins {
	id("org.jetbrains.kotlin.jvm") version "1.5.0"
	id("fabric-loom") version "0.11.+"
	id("com.modrinth.minotaur") version "1.2.1"
	`maven-publish`
}

val modId: String by project
val minecraftVersion: String by project
val loaderVersion: String by project
val yarnMappings: String by project
val fabricVersion: String by project
val modVersion: String by project
val mavenGroup: String by project
val fabricKotlinVersion: String by project
val modLoader: String by project
val modrinthId: String by project
val verType: String by project

base.archivesBaseName = modId
version = modVersion
group = mavenGroup

repositories {
	maven {
		name = "JitPack"
		url = uri("https://jitpack.io")
	}
	
	maven {
		name = "Curseforge Maven"
		url = uri("https://www.cursemaven.com")
	}

	maven {
		name = "Devan-Kerman/Devan-Repo"
		url = uri("https://raw.githubusercontent.com/Devan-Kerman/Devan-Repo/master/")
	}

	maven {
		name = "Bikeshedaniel Maven"
		url = uri("https://maven.shedaniel.me/")
	}
	
//	// temporary cursed gradle hack for github actions. don't forget to remove this when prospector fixes it!
//	if (System.getenv("GITHUB_ACTIONS") == null) {
//
//	}
	maven {
		name = "TerraformersMC"
		url = uri("https://maven.terraformersmc.com/")
	}

	maven {
		url = uri("https://bai.jfrog.io/artifactory/maven")
	}
}

val modImplementationInclude by configurations.register("modImplementationInclude")

dependencies {
	minecraft("net.minecraft", "minecraft", minecraftVersion)
	mappings("net.fabricmc", "yarn", yarnMappings, classifier = "v2")

	modImplementation("net.fabricmc", "fabric-loader", loaderVersion)
	modImplementation("net.fabricmc.fabric-api", "fabric-api", fabricVersion)
	modImplementation("net.fabricmc", "fabric-language-kotlin", fabricKotlinVersion)

//	modImplementationInclude("net.devtech", "grossfabrichacks", "6.1")

	if (!file("ignoreruntime.txt").exists()) {
		println("Setting up runtimes...")
		
		modRuntimeOnly("com.terraformersmc", "modmenu", "3.1.0")
		modRuntimeOnly("mcp.mobius.waila", "wthit", "fabric-4.8.0")
		modRuntimeOnly("me.shedaniel", "RoughlyEnoughItems-fabric", "8.0.442")
//		modRuntimeOnly("com.github.mikroskeem", "WorldEditCUI", "mc~1.17-SNAPSHOT")
	}

	add(sourceSets.main.get().getTaskName("mod", JavaPlugin.IMPLEMENTATION_CONFIGURATION_NAME), modImplementationInclude)
	add(net.fabricmc.loom.util.Constants.Configurations.INCLUDE, modImplementationInclude)
}

java {
	sourceCompatibility = JavaVersion.VERSION_17
	targetCompatibility = JavaVersion.VERSION_17
}

publishing {
	publications {
		create<MavenPublication>("mavenJava") {
			from(components["java"])
		}
	}
}

tasks.withType<JavaCompile> {
	options.encoding = "UTF-8"

	options.release.set(17)
}

tasks.withType<AbstractArchiveTask> {
	from(file("LICENSE"))
}

tasks.processResources {
	filesMatching("fabric.mod.json") {
		expand("version" to project.version)
	}
}

tasks.register("publishModrinth", TaskModrinthUpload::class) {
	onlyIf {
		System.getenv("MODRINTH") != null
	}
	
	token = System.getenv("MODRINTH")
	projectId = modrinthId
	uploadFile = tasks.remapJar.get().archiveFile.get().asFile
	addGameVersion(minecraftVersion)
	addLoader(modLoader)
	versionType = VersionType.valueOf(verType)
	versionNumber = version as String
//	versionName = "${rootProject.name} ${versionNumber.split('+')[0]} for Minecraft $minecraftVersion"
	versionName = File("./modrinth/name.txt").readText()
	changelog = File("./modrinth/CHANGELOG.md").readText()
}.get().dependsOn(tasks.build.get())

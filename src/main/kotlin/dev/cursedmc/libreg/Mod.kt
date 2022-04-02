package dev.cursedmc.libreg

import dev.cursedmc.libreg.example.ExampleMod
import dev.cursedmc.libreg.util.debug
import dev.cursedmc.libreg.util.info
import net.fabricmc.loader.api.FabricLoader

internal const val MOD_ID = "libreg"

@Suppress("unused")
fun init() {
	info("$MOD_ID started!")
	
	if (FabricLoader.getInstance().isDevelopmentEnvironment) {
		debug("Initializing tests...")
		ExampleMod.init()
	}
}

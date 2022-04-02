package dev.cursedmc.libreg.client

import dev.cursedmc.libreg.MOD_ID
import dev.cursedmc.libreg.example.client.ExampleModClient
import dev.cursedmc.libreg.util.debug
import dev.cursedmc.libreg.util.info
import net.fabricmc.loader.api.FabricLoader

@Suppress("unused")
fun initClient() {
	info("$MOD_ID (client) started")
	
	if (FabricLoader.getInstance().isDevelopmentEnvironment) {
		debug("Initializing tests...")
		ExampleModClient.init()
	}
}

package dev.tehc.libreg.client

import dev.tehc.libreg.MOD_ID
import dev.tehc.libreg.example.client.ExampleModClient
import dev.tehc.libreg.util.debug
import dev.tehc.libreg.util.info
import net.fabricmc.loader.api.FabricLoader

fun initClient() {
	info("$MOD_ID (client) started")
	
	if (FabricLoader.getInstance().isDevelopmentEnvironment) {
		debug("Initializing tests...")
		ExampleModClient.init()
	}
}

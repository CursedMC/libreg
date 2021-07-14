package dev.tehc.libreg.client

import dev.tehc.libreg.Mod
import dev.tehc.libreg.example.client.ExampleModClient
import dev.tehc.libreg.util.debug
import dev.tehc.libreg.util.info
import net.fabricmc.loader.api.FabricLoader

@Suppress("unused")
object ModClient {
	fun main() {
		info("${Mod.id} (client) started")
		
		if (FabricLoader.getInstance().isDevelopmentEnvironment) {
			debug("Initializing tests...")
			ExampleModClient.main()
		}
	}
}

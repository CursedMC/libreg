package dev.tehc.libreg

import dev.tehc.libreg.example.ExampleMod
import dev.tehc.libreg.util.debug
import dev.tehc.libreg.util.info
import net.fabricmc.loader.api.FabricLoader

internal const val MOD_ID = "libreg"

fun init() {
	info("$MOD_ID started!")
	
	if (FabricLoader.getInstance().isDevelopmentEnvironment) {
		debug("Initializing tests...")
		ExampleMod.init()
	}
}

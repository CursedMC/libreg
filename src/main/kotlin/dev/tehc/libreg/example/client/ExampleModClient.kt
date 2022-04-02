package dev.tehc.libreg.example.client

import dev.tehc.libreg.example.block.ExampleBlocks
import dev.tehc.libreg.example.block.entity.ExampleBlockEntities
import dev.tehc.libreg.example.block.entity.client.ExampleBlockEntityRenderers

object ExampleModClient {
	internal fun init() {
		ExampleBlocks.Client.initialize()
		ExampleBlockEntities.Client.initialize()
		ExampleBlockEntityRenderers.initialize()
	}
}

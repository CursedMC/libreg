package dev.cursedmc.libreg.example.client

import dev.cursedmc.libreg.example.block.ExampleBlocks
import dev.cursedmc.libreg.example.block.entity.ExampleBlockEntities
import dev.cursedmc.libreg.example.block.entity.client.ExampleBlockEntityRenderers

object ExampleModClient {
	internal fun init() {
		ExampleBlocks.Client.initialize()
		ExampleBlockEntities.Client.initialize()
		ExampleBlockEntityRenderers.initialize()
	}
}

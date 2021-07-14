package dev.tehc.libreg.example.client

import dev.tehc.libreg.example.block.entity.client.ExampleBlockEntityRenderers

object ExampleModClient {
	internal fun main() {
		ExampleBlockEntityRenderers.initialize()
	}
}

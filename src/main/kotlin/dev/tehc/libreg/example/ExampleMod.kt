package dev.tehc.libreg.example

import dev.tehc.libreg.example.block.ExampleBlocks
import dev.tehc.libreg.example.block.entity.ExampleBlockEntities
import dev.tehc.libreg.example.item.ExampleItems
import dev.tehc.libreg.registry.init

object ExampleMod {
	private const val id = "example"
	
	internal fun main() {
		init(id)
		
		ExampleBlocks.initialize()
		ExampleItems.initialize()
		ExampleBlockEntities.initialize()
		registerDimensions()
		registerRecipes()
		registerEffects()
		registerStructure()
		registerBiome()
	}
	
	private fun registerDimensions() {}
	
	private fun registerRecipes() {}
	
	private fun registerEffects() {}
	
	// tele jigsaw grunt pathic telepathic st'ructure processorjigsaw worldgenjson
	private fun registerStructure() {}
	
	private fun registerBiome() {}
}

package dev.cursedmc.libreg.example

import dev.cursedmc.libreg.example.block.ExampleBlocks
import dev.cursedmc.libreg.example.block.entity.ExampleBlockEntities
import dev.cursedmc.libreg.example.item.ExampleItems
import dev.cursedmc.libreg.registry.init

object ExampleMod {
	private const val id = "example"
	
	fun init() {
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

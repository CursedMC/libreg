@file:JvmName("BlockUtil")

package dev.cursedmc.libreg.registry.block

import dev.cursedmc.libreg.registry.ident
import dev.cursedmc.libreg.registry.item.item
import net.fabricmc.fabric.api.`object`.builder.v1.block.FabricBlockSettings
import net.fabricmc.fabric.api.item.v1.FabricItemSettings
import net.minecraft.block.Block
import net.minecraft.item.BlockItem
import net.minecraft.util.registry.Registry

// cursed wet code
// i swear this is the cleanest way

// Excuse me? - Sylv (4/1/22, 22:46)

fun block(id: String, block: Block): Block {
	return Registry.register(Registry.BLOCK, ident(id), block)
}

fun block(id: String, settings: FabricBlockSettings): Block {
	return block(id, Block(settings))
}

fun blockItem(id: String, block: Block, itemSettings: FabricItemSettings): Pair<Block, BlockItem> {
	return Pair(block(id, block), item(id, BlockItem(block, itemSettings)) as BlockItem)
}

@Suppress("unused")
fun blockItem(id: String, blockSettings: FabricBlockSettings, itemSettings: FabricItemSettings): Pair<Block, BlockItem> {
	val block = Block(blockSettings)
	return blockItem(id, block, itemSettings)
}

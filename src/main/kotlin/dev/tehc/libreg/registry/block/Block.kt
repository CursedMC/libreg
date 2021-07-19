@file:JvmName("BlockUtil")

package dev.tehc.libreg.registry.block

import dev.tehc.libreg.registry.ident
import dev.tehc.libreg.registry.item.item
import net.fabricmc.fabric.api.`object`.builder.v1.block.FabricBlockSettings
import net.fabricmc.fabric.api.item.v1.FabricItemSettings
import net.minecraft.block.Block
import net.minecraft.client.render.RenderLayer
import net.minecraft.item.BlockItem
import net.minecraft.util.registry.Registry

// cursed wet code
// i swear this is the cleanest way

fun block(id: String, block: Block): Block {
	return Registry.register(Registry.BLOCK, ident(id), block)
}

fun block(id: String, renderLayer: RenderLayer, block: Block): Block {
	renderLayer(block, renderLayer)
	return Registry.register(Registry.BLOCK, ident(id), block)
}

fun block(id: String, settings: FabricBlockSettings): Block {
	return block(id, Block(settings))
}

fun block(id: String, renderLayer: RenderLayer, settings: FabricBlockSettings): Block {
	val block = block(id, Block(settings))
	renderLayer(block, renderLayer)
	return block
}

fun blockItem(id: String, block: Block, itemSettings: FabricItemSettings): Pair<Block, BlockItem> {
	return Pair(block(id, block), item(id, BlockItem(block, itemSettings)) as BlockItem)
}

fun blockItem(id: String, blockSettings: FabricBlockSettings, itemSettings: FabricItemSettings): Pair<Block, BlockItem> {
	val block = Block(blockSettings)
	return blockItem(id, block, itemSettings)
}

fun blockItem(id: String, renderLayer: RenderLayer, block: Block, itemSettings: FabricItemSettings): Pair<Block, BlockItem> {
	return Pair(block(id, renderLayer, block), item(id, BlockItem(block, itemSettings)) as BlockItem)
}

fun blockItem(id: String, renderLayer: RenderLayer, blockSettings: FabricBlockSettings, itemSettings: FabricItemSettings): Pair<Block, BlockItem> {
	val block = Block(blockSettings)
	renderLayer(block, renderLayer)
	return blockItem(id, block, itemSettings)
}

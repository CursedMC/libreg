@file:JvmName("BlockEntityUtil")

package dev.cursedmc.libreg.registry.block.entity

import dev.cursedmc.libreg.registry.ident
import net.fabricmc.fabric.api.`object`.builder.v1.block.entity.FabricBlockEntityTypeBuilder
import net.fabricmc.fabric.api.client.rendering.v1.BlockEntityRendererRegistry
import net.minecraft.block.Block
import net.minecraft.block.entity.BlockEntity
import net.minecraft.block.entity.BlockEntityType
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory
import net.minecraft.util.registry.Registry

fun <T : BlockEntity> blockEntityType(id: String, factory: FabricBlockEntityTypeBuilder.Factory<T>, block: Block): BlockEntityType<T> {
	return Registry.register(Registry.BLOCK_ENTITY_TYPE, ident(id), FabricBlockEntityTypeBuilder.create(factory, block).build())
}

// TODO: change name to something less cursed
fun <T : BlockEntity> blockEntityRenderer(factory: BlockEntityRendererFactory<T>, blockEntityType: BlockEntityType<T>) {
	return BlockEntityRendererRegistry.register(blockEntityType, factory)
}

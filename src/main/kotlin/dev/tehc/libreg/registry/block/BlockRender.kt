@file:JvmName("BlockRender")
@file:Environment(EnvType.CLIENT)

package dev.tehc.libreg.registry.block

import net.fabricmc.api.EnvType
import net.fabricmc.api.Environment
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap
import net.minecraft.block.Block
import net.minecraft.client.render.RenderLayer

fun renderLayer(block: Block, renderLayer: RenderLayer) = BlockRenderLayerMap.INSTANCE.putBlock(block, renderLayer)

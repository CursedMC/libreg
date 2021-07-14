package dev.tehc.libreg.example.block.entity

import dev.tehc.libreg.example.item.group.ExampleGroups
import dev.tehc.libreg.registry.block.blockItem
import dev.tehc.libreg.registry.block.entity.blockEntityType
import net.fabricmc.fabric.api.`object`.builder.v1.block.FabricBlockSettings
import net.fabricmc.fabric.api.item.v1.FabricItemSettings
import net.minecraft.block.*
import net.minecraft.block.entity.BlockEntity
import net.minecraft.client.render.RenderLayer
import net.minecraft.item.BlockItem
import net.minecraft.sound.BlockSoundGroup
import net.minecraft.util.Rarity
import net.minecraft.util.math.BlockPos

class TestBlockEntity(pos: BlockPos, state: BlockState) : BlockEntity(ExampleBlockEntities.test_type, pos, state)

object ExampleBlockEntities {
	private const val test_id = "test_block"
	private val test_block: Pair<Block, BlockItem> = blockItem(test_id,
		RenderLayer.getCutout(),
		object : BlockWithEntity(
			FabricBlockSettings
				.of(Material.SOLID_ORGANIC)
				.sounds(BlockSoundGroup.GRASS),
		) {
			override fun createBlockEntity(pos: BlockPos, state: BlockState): BlockEntity {
				return TestBlockEntity(pos, state)
			}
			
			override fun getRenderType(state: BlockState): BlockRenderType {
				return BlockRenderType.INVISIBLE
			}
		},
		FabricItemSettings()
			.rarity(Rarity.EPIC)
			.group(ExampleGroups.MOD),
	)
	val test_type = blockEntityType(test_id, ::TestBlockEntity, test_block.first as BlockWithEntity)
	
	/* no-op */
	fun initialize() = Unit
}

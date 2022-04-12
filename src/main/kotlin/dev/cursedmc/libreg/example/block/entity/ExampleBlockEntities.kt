package dev.cursedmc.libreg.example.block.entity

import dev.cursedmc.libreg.example.item.group.ExampleGroups
import dev.cursedmc.libreg.registry.block.blockItem
import dev.cursedmc.libreg.registry.block.entity.blockEntityType
import dev.cursedmc.libreg.registry.block.renderLayer
import net.fabricmc.fabric.api.`object`.builder.v1.block.FabricBlockSettings
import net.fabricmc.fabric.api.item.v1.FabricItemSettings
import net.minecraft.block.Block
import net.minecraft.block.BlockState
import net.minecraft.block.BlockWithEntity
import net.minecraft.block.Material
import net.minecraft.block.entity.BlockEntity
import net.minecraft.client.render.RenderLayer
import net.minecraft.item.BlockItem
import net.minecraft.sound.BlockSoundGroup
import net.minecraft.util.Rarity
import net.minecraft.util.math.BlockPos

class TestBlockEntity(pos: BlockPos, state: BlockState) : BlockEntity(ExampleBlockEntities.TEST_TYPE, pos, state)

object ExampleBlockEntities {
	object Client {
		init {
			renderLayer(TEST_BLOCK.first, RenderLayer.getCutout())
		}
		
		/* no-op */
		fun initialize() = Unit
	}
	
	private const val TEST_ID = "test_block"
	@Suppress("OVERRIDE_DEPRECATION")
	val TEST_BLOCK: Pair<Block, BlockItem> = blockItem(TEST_ID,
		object : BlockWithEntity(
			FabricBlockSettings
				.of(Material.SOLID_ORGANIC)
				.sounds(BlockSoundGroup.GRASS),
		) {
			override fun createBlockEntity(pos: BlockPos, state: BlockState): BlockEntity {
				return TestBlockEntity(pos, state)
			}
		},
		FabricItemSettings()
			.rarity(Rarity.EPIC)
			.group(ExampleGroups.MOD),
	)
	val TEST_TYPE = blockEntityType(TEST_ID, ::TestBlockEntity, TEST_BLOCK.first)
	
	/* no-op */
	fun initialize() = Unit
}

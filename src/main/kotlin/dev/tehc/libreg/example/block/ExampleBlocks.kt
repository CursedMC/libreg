package dev.tehc.libreg.example.block

import dev.tehc.libreg.example.item.group.ExampleGroups
import dev.tehc.libreg.registry.block.BlockPredicates
import dev.tehc.libreg.registry.block.blockItem
import dev.tehc.libreg.text.text
import dev.tehc.libreg.text.transText
import dev.tehc.libreg.util.math.tickSeconds
import net.fabricmc.fabric.api.`object`.builder.v1.block.FabricBlockSettings
import net.fabricmc.fabric.api.item.v1.FabricItemSettings
import net.minecraft.block.*
import net.minecraft.client.render.RenderLayer
import net.minecraft.entity.effect.StatusEffectInstance
import net.minecraft.entity.effect.StatusEffects
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.item.FoodComponent
import net.minecraft.server.world.ServerWorld
import net.minecraft.sound.BlockSoundGroup
import net.minecraft.util.ActionResult
import net.minecraft.util.Formatting
import net.minecraft.util.Hand
import net.minecraft.util.Rarity
import net.minecraft.util.hit.BlockHitResult
import net.minecraft.util.math.BlockPos
import net.minecraft.world.World

/**
 * Blocks
 * @author Tehc
 */
@Suppress("unused")
object ExampleBlocks {
	val HELP_ME = blockItem(
		"help_me",
		object : SlimeBlock(
			FabricBlockSettings
				.copyOf(Blocks.SLIME_BLOCK),
		) {
		},
		FabricItemSettings()
			.group(ExampleGroups.MOD)
			.food(
				FoodComponent.Builder()
					.saturationModifier(0.1F)
					.meat()
					.hunger(2)
					.statusEffect(StatusEffectInstance(StatusEffects.NAUSEA, tickSeconds(30), 1), 1.0F)
					.build(),
			),
	)
	val REFACTOR = blockItem(
		"refactor",
		RenderLayer.getCutout(),
		object : Block(
			FabricBlockSettings
				.of(Material.LEAVES)
				.nonOpaque()
				.sounds(BlockSoundGroup.GRASS)
				.suffocates(BlockPredicates.never)
				.blockVision(BlockPredicates.never),
		) {
			private var cooldown = 0L
			
			override fun onUse(state: BlockState?, world: World?, pos: BlockPos?, player: PlayerEntity?, hand: Hand?, hit: BlockHitResult?): ActionResult {
				if (world is ServerWorld && System.currentTimeMillis() > cooldown) {
					// set cooldown timer
					cooldown = System.currentTimeMillis() + 3 * 1000
					
					val text = text("<mojang> ")
						.append(
							transText("mojang.refactor")
								.formatted(Formatting.ITALIC)
						)
					
					player?.sendSystemMessage(text, null)
				}
				return ActionResult.SUCCESS
			}
			
			override fun hasSidedTransparency(state: BlockState?): Boolean {
				return true
			}
		},
		FabricItemSettings()
			.group(ExampleGroups.MOD)
			.rarity(Rarity.COMMON),
	)
	
	/* no-op */
	fun initialize() = Unit
}

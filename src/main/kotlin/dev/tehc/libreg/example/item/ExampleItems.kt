package dev.tehc.libreg.example.item

import dev.tehc.libreg.example.block.ExampleBlocks
import dev.tehc.libreg.example.item.group.ExampleGroups
import dev.tehc.libreg.registry.item.item
import net.fabricmc.fabric.api.item.v1.FabricItemSettings
import net.minecraft.item.Item
import net.minecraft.item.ItemUsageContext
import net.minecraft.server.world.ServerWorld
import net.minecraft.util.ActionResult
import net.minecraft.util.Rarity

/**
 * Items
 * @author Tehc
 */
object ExampleItems {
	val MOJANK = item(
		"mojank",
		object : Item(
			FabricItemSettings()
				.fireproof()
				.rarity(Rarity.UNCOMMON)
				.group(ExampleGroups.MOD)
		) {
			override fun useOnBlock(context: ItemUsageContext?): ActionResult {
				if (context?.world is ServerWorld) {
					context.world.setBlockState(context.blockPos, ExampleBlocks.REFACTOR.first.defaultState)
				}
				context?.stack?.decrement(1)
				return ActionResult.SUCCESS
			}
		},
	)
	
	/* no-op */
	fun initialize() {}
}
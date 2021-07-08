package dev.tehc.libreg.example.item.group

import dev.tehc.libreg.example.block.ExampleBlocks
import dev.tehc.libreg.registry.ident
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder
import net.minecraft.item.ItemGroup

object ExampleGroups {
	val MOD: ItemGroup = FabricItemGroupBuilder
		.create(ident("example_group"))
		.icon { return@icon ExampleBlocks.REFACTOR.second.defaultStack }
		.build()
}

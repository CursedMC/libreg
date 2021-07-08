@file:JvmName("ItemUtil")

package dev.tehc.libreg.registry.item

import dev.tehc.libreg.registry.ident
import net.fabricmc.fabric.api.item.v1.FabricItemSettings
import net.minecraft.item.Item
import net.minecraft.util.registry.Registry

fun item(id: String, settings: FabricItemSettings): Item {
	return Registry.register(Registry.ITEM, ident(id), Item(settings))
}

fun item(id: String, item: Item): Item {
	return Registry.register(Registry.ITEM, ident(id), item)
}

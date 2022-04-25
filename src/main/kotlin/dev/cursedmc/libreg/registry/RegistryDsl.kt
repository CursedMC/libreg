package dev.cursedmc.libreg.registry

import net.minecraft.block.Block
import net.minecraft.block.entity.BlockEntityType
import net.minecraft.entity.effect.StatusEffect
import net.minecraft.item.Item
import net.minecraft.potion.Potion
import net.minecraft.util.Identifier
import net.minecraft.util.registry.Registry


// Base function for Registry DSL
fun registry(modid: String, lambda: RegistryDsl.() -> Unit) = RegistryDsl(modid).apply(lambda)

// Holder class for the DSL
class RegistryDsl(val modid: String) {
    class BlockDsl(val modid: String) {
        fun register(block: Block, path: String) {
            Registry.register(Registry.BLOCK, Identifier(modid, path), block);
        }
    }
    fun block(lambda: BlockDsl.() -> Unit) = BlockDsl(modid).apply(lambda)

    class ItemDsl(val modid: String) {
        fun register(block: Item, path: String) {
            Registry.register(Registry.ITEM, Identifier(modid, path), block);
        }
    }
    fun item(lambda: ItemDsl.() -> Unit) = ItemDsl(modid).apply(lambda)

    class PotionDsl(val modid: String) {
        fun register(block: Potion, path: String) {
            Registry.register(Registry.POTION, Identifier(modid, path), block);
        }
    }
    fun potion(lambda: PotionDsl.() -> Unit) = PotionDsl(modid).apply(lambda)

    class StatusEffectDsl(val modid: String) {
        fun register(block: StatusEffect, path: String) {
            Registry.register(Registry.STATUS_EFFECT, Identifier(modid, path), block);
        }
    }
    fun statusEffect(lambda: StatusEffectDsl.() -> Unit) = StatusEffectDsl(modid).apply(lambda)

    class BlockEntityDsl(val modid: String) {
        fun register(block: BlockEntityType<*>, path: String) {
            Registry.register(Registry.BLOCK_ENTITY_TYPE, Identifier(modid, path), block);
        }
    }
    fun blockEntityType(lambda: BlockEntityDsl.() -> Unit) = BlockEntityDsl(modid).apply(lambda)

    class EnchantmentDsl(val modid: String) {
        fun register(block: BlockEntityType<*>, path: String) {
            Registry.register(Registry.BLOCK_ENTITY_TYPE, Identifier(modid, path), block);
        }
    }
    fun enchantment(lambda: EnchantmentDsl.() -> Unit) = EnchantmentDsl(modid).apply(lambda)
}
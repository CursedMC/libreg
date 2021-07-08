package dev.tehc.libreg.registry.block

import net.minecraft.block.AbstractBlock

typealias ContextPredicate = AbstractBlock.ContextPredicate

typealias TypedContextPredicate = AbstractBlock.TypedContextPredicate<Any> // cursed generics hack

object BlockPredicates {
	@JvmField
	val always = ContextPredicate { _, _, _ -> true }
	@JvmField
	val never = ContextPredicate { _, _, _ -> false }
	
	object Typed {
		@JvmField
		val always = TypedContextPredicate { _, _, _, _ -> true }
		@JvmField
		val never = TypedContextPredicate { _, _, _, _ -> false }
	}
}

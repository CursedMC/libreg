package dev.cursedmc.libreg.registry.entity

import dev.cursedmc.libreg.registry.ident
import net.minecraft.entity.Entity
import net.minecraft.entity.EntityType
import net.minecraft.util.registry.Registry

// TODO: example entity
/**
 * Registers an EntityType
 * @author Tehc
 * @param T The type of entity being registered
 * @return The EntityType
 */
@Suppress("unused")
fun <T : Entity> entityType(id: String, type: EntityType<T>): EntityType<T> {
	return Registry.register(Registry.ENTITY_TYPE, ident(id), type)
}

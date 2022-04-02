@file:JvmName("RegistryUtil")

package dev.cursedmc.libreg.registry

import net.minecraft.util.Identifier

var namespace: String = "minecraft"

fun ns(ns: String) {
	namespace = ns
}

fun ident(id: String): Identifier = Identifier(namespace, id)

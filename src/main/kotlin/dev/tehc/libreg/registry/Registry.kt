@file:JvmName("RegistryUtil")

package dev.tehc.libreg.registry

import net.minecraft.util.Identifier

var namespace: String = "minecraft"

fun init(ns: String) {
	namespace = ns
}

fun ident(id: String): Identifier = Identifier(namespace, id)

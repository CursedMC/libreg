@file:JvmName("TextUtil")

package dev.cursedmc.libreg.text

import dev.cursedmc.libreg.registry.namespace
import net.minecraft.text.LiteralText
import net.minecraft.text.TranslatableText

fun text(string: String) = LiteralText(string)

fun transText(key: String) = TranslatableText("$namespace.$key")

@Suppress("unused")
fun transText(key: String, args: Any) = TranslatableText("$namespace.$key", args)

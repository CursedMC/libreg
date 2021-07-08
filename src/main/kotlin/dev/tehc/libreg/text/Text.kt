@file:JvmName("TextUtil")

package dev.tehc.libreg.text

import dev.tehc.libreg.registry.namespace
import net.minecraft.text.LiteralText
import net.minecraft.text.TranslatableText

fun text(string: String) = LiteralText(string)

fun transText(key: String) = TranslatableText("$namespace.$key")

fun transText(key: String, args: Any) = TranslatableText("$namespace.$key", args)

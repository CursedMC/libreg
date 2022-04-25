package dev.cursedmc.libreg.text

import net.minecraft.text.LiteralText
import net.minecraft.text.Style
import net.minecraft.text.Text
import net.minecraft.text.TranslatableText

fun translatable(string: String) = TranslatableText(string)
fun text(string: String) = Text.of(string)
fun styledText(string: String, style: (Style) -> Style) = (Text.of(string) as LiteralText).styled(style)
@file:JvmName("MathUtil")

package dev.tehc.libreg.util.math

fun tickMinutes(minutes: Int) = tickSeconds(minutes) * 60 // ticks to minutes

fun tickSeconds(seconds: Int) = seconds * 20 // ticks to seconds

fun tickMilli(milliseconds: Int) = tickSeconds(milliseconds) * 1000 // ticks to milliseconds

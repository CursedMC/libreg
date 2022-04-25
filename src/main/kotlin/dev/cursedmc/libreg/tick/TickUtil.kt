package dev.cursedmc.libreg.tick

// Tick to time
fun toSec(tick: Int) = tick/20
fun toMin(tick: Int) = toSec(tick)/60
fun toMilli(tick: Int) = toSec(tick)*1000

// Time to tick
fun fromSec(sec: Int) = sec*20
fun fromMin(min: Int) = fromSec(min*60)
fun fromMilli(milli: Int) = fromSec(milli/1000)
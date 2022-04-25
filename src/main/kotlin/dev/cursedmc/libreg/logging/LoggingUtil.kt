package dev.cursedmc.libreg.logging

import org.slf4j.LoggerFactory

fun get(modid: String) = LoggerFactory.getLogger(modid)
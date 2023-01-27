package com.main

import AST.Parser
import java.io.*

fun main() {
    val file = File("src/main/resources/test.txt")
    val astRoot = Parser.parse(file.inputStream())!!
    astRoot.dump(" ")
}
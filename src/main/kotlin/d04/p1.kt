package d04

import readAsInput

fun main() {
    val matrix = readAsInput("04").mapTo(mutableListOf()) { it.toCharArray() }
    val free = noteFree(matrix).size
    println(free)
}
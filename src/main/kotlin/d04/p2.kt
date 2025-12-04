package d04

import readAsInput

fun main() {
    val matrix = readAsInput("04").mapTo(mutableListOf()) { it.toCharArray() }
    var total = 0
    do {
        val free = noteFree(matrix)
        total += free.size
        for ((x, y) in free) {
            matrix[y][x] = '.'
        }
    } while (free.isNotEmpty())
    println(total)
}
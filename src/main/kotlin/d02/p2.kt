package d02

import readAsInput

fun main() {
    val result = readAsInput("02")
        .parseRanges()
        .flatMap { range -> range.asSequence() }
        .map { number -> number.toString() }
        .filter { str -> str.isExtremelyInvalidID() }
        .sumOf { str -> str.toLong() }
    println(result)
}
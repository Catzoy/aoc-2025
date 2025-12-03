package d03

import readAsInput

fun main() {
    val maxJoltage = readAsInput("03")
        .asSequence()
        .map { str -> str.toCharArray() }
        .map { arr -> arr.findMostJoltage() }
        .onEach { println("Joltage: $it") }
        .sum()
    println(maxJoltage)
}
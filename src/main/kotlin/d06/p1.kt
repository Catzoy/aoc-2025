package d06

import readAsInput

fun main() {
    val (matrix, operations) = readAsInput("06").parseInput()
    val evaluations = operations.withIndex().map { (i, op) ->
        when (op) {
            '*' -> matrix.fold(1L) { acc, m -> acc * m[i] }
            '+' -> matrix.fold(0L) { acc, m -> acc + m[i] }
            else -> throw IllegalArgumentException("Unknown operation $op")
        }
    }
    val total = evaluations.sum()
    println(total)
}
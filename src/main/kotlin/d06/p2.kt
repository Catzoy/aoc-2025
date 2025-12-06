package d06

import readAsInput

fun main() {
    val (matrix, operations) = readAsInput("06").parseInputRTL()
    val total = operations.evaluateRTL(matrix)
    println(total)
}
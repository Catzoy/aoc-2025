package d06

import readAsInput

fun main() {
    val (matrix, operations) = readAsInput("06").parseInputLTR()
    val total = operations.evaluateLTR(matrix)
    println(total)
}
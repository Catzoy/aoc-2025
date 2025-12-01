package d01

import readAsInput

fun main() {
    val zeroes = readAsInput(day = "01")
        .asSequence()
        .map { line -> Rotation.from(line) }
        .fold(Dial()) { dial, rotation -> rotation.rotate(dial) }
        .clicks
    println(zeroes)
}
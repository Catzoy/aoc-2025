package d01

import readAsInput

fun main() {
    val zeroes = readAsInput(day = "01")
        .asSequence()
        .map { line -> Rotation.from(line) }
        .scan(Dial()) { dial, rotation -> rotation.rotate(dial) }
        .count { dial -> dial.value == 0 }
    println(zeroes)
}
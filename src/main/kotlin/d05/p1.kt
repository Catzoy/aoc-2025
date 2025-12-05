package d05

import readAsInput

fun main() {
    val (ranges, ids) = readAsInput("05").parseInput()
    val valids = ids.count { id ->
        ranges.any { range -> id in range }
    }
    println(valids)
}
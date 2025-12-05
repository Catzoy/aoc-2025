package d05

import readAsInput
import kotlin.math.max

fun main() {
    val (ranges, _) = readAsInput("05").parseInput()
    val valids = ranges.toMutableList().apply {
        var i = 0
        while (i in indices) {
            val current = get(i)
            val next = getOrNull(i + 1) ?: break
            if (next.first in current) {
                set(i, current.first..max(current.last, next.last))
                removeAt(i + 1)
            } else {
                i++
            }
        }
    }
    val total = valids.sumOf { range -> range.last - range.first + 1 }
    println(total)
}
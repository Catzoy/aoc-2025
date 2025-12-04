package d04

fun List<CharArray>.isFreeRollAt(x: Int, y: Int): Boolean {
    val adjacent = listOf(
        y - 1 to x - 1,
        y to x - 1,
        y + 1 to x - 1,

        y - 1 to x,
        y + 1 to x,

        y - 1 to x + 1,
        y to x + 1,
        y + 1 to x + 1,
    )
    return adjacent
        .asSequence()
        .filter { (y, x) -> getOrNull(y)?.getOrNull(x) == '@' }
        .take(4)
        .count() < 4
}

fun noteFree(matrix: MutableList<CharArray>): List<Pair<Int, Int>> {
    return matrix.withIndex().flatMap { (y, line) ->
        line.withIndex().mapNotNull { (x, char) ->
            if (char == '@' && matrix.isFreeRollAt(x, y)) x to y else null
        }
    }
}
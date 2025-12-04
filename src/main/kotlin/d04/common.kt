package d04

fun List<CharArray>.isFreeRollAt(x: Int, y: Int): Boolean {
    if (getOrNull(y)?.getOrNull(x) != '@') {
        return false
    }

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

fun countFree(matrix: MutableList<CharArray>): Int {
    var count = 0
    for (i in matrix.indices) {
        for (j in matrix[0].indices) {
            if (matrix.isFreeRollAt(j, i)) {
                count++
            }
        }
    }
    return count
}
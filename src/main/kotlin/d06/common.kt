package d06

typealias Matrix = List<List<Long>>
typealias Operations = List<Char>

fun List<String>.parseInput(): Pair<Matrix, Operations> {
    val opRegex = Regex("([+*])")
    val numberRegex = Regex("(\\d+)")
    val operations = opRegex.findAll(last())
        .map { result -> result.groupValues[1][0] }
        .toList()
    val matrix = asSequence()
        .take(size - 1)
        .map { line ->
            numberRegex.findAll(line)
                .map { result -> result.groupValues[1].toLong() }
                .toList()
        }
        .toList()
    return matrix to operations
}
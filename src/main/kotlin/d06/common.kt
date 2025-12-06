package d06

typealias Matrix = List<List<Long>>
typealias Operations = List<Char>

fun List<String>.parseInputLTR(): Pair<Matrix, Operations> {
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


fun List<String>.parseInputRTL(): Pair<Matrix, Operations> {
    return last()
        .reversed()
        .foldIndexed(mutableListOf(mutableListOf<Long>()) to mutableListOf<Char>()) { i, (m, ops), char ->
            val number = (0 until lastIndex)
                .map { j -> get(j).let { str -> str[str.lastIndex - i] } }
                .joinToString(separator = "")
                .trim()
                .toLongOrNull()
            if (number != null) {
                m.last().add(number)
            }
            if (char == '*' || char == '+') {
                ops.add(char)
                m.add(mutableListOf())
            }
            m to ops
        }
        .also { (m, _) ->
            m.removeLast()
        }
}

fun Operations.evaluateLTR(matrix: Matrix): Long {
    val results = withIndex().map { (i, op) ->
        when (op) {
            '*' -> matrix.fold(1L) { acc, m -> acc * m[i] }
            '+' -> matrix.fold(0L) { acc, m -> acc + m[i] }
            else -> throw IllegalArgumentException("Unknown operation $op")
        }
    }
    return results.sum()
}

fun Operations.evaluateRTL(matrix: Matrix): Long {
    val results = withIndex().map { (i, op) ->
        when (op) {
            '*' -> matrix[i].fold(1L) { acc, m -> acc * m }
            '+' -> matrix[i].fold(0L) { acc, m -> acc + m }
            else -> throw IllegalArgumentException("Unknown operation $op")
        }
    }
    return results.sum()
}
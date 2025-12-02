package d02

fun List<String>.parseRanges(): Sequence<LongRange> {
    val range = Regex("(\\d+)-(\\d+)")
    return asSequence()
        .flatMap { line ->
            range.findAll(line)
        }
        .map { match ->
            val (_, lower, upper) = match.groupValues
            lower.toLong()..upper.toLong()
        }
}

fun String.isInvalidID(): Boolean {
    if (length % 2 != 0) {
        return false
    }

    val half = take(length / 2)
    return this == half.repeat(2)
}

fun String.isExtremelyInvalidID(): Boolean {
    val half = take(length / 2)
    for (i in half.indices) {
        val substring = half.take(i + 1)
        val repetitions = length / substring.length
        if (this == substring.repeat(repetitions)) {
            return true
        }
    }

    return false
}
package d03

fun CharArray.findMostJoltage(length: Int): Long {
    var joltage = List(length) { '0' }
    var relative = List(length) { -1 }
    for (position in indices) {
        val char = get(position)
        val indexMax = joltage.withIndex()
            .asSequence()
            // number is greater than some of existing
            .filter { (_, cx) -> char > cx }
            // after the position there is enough values for the rest of the battery
            .filter { (i, _) -> (lastIndex - position >= joltage.lastIndex - i) }
            // this position was not previously used
            .filterNot { (i, _) -> relative.take(i + 1).contains(position) }
            .firstOrNull()
            ?.index
        if (indexMax != null) {
            val retained = 0 until indexMax
            val updated = position..position + (joltage.lastIndex - indexMax)
            joltage = joltage.slice(retained) + slice(updated)
            relative = relative.slice(retained) + updated.toList()
        }
    }
    return joltage.joinToString(separator = "").toLong()
}
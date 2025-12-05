package d05

fun List<String>.parseInput(): Pair<List<LongRange>, List<Long>> {
    val ranger = Regex("(\\d+)-(\\d+)")
    val items = iterator()
    val ranges = buildList {
        while (items.hasNext()) {
            val item = items.next()
            if (item.isEmpty()) break
            val (_, lower, upper) = ranger.find(item)?.groupValues ?: break
            add(lower.toLong()..upper.toLong())
        }
        sortWith(Comparator { r1, r2 -> r1.first.compareTo(r2.first) })
    }
    val ids = buildList {
        items.forEachRemaining { item ->
            add(item.toLong())
        }
    }
    return ranges to ids
}
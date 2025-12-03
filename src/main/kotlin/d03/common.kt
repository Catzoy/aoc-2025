package d03

fun CharArray.findMostJoltage(): Int {
    var c1 = '0'
    var c2 = '0'
    for (position in indices) {
        val char = get(position)
        when {
            char > c1 && position != lastIndex -> {
                c1 = char
                c2 = get(position + 1)
            }

            char > c2 -> {
                c2 = char
            }
        }
    }
    return "$c1$c2".toInt()
}
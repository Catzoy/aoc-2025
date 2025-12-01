package d01

data class Dial(
    val value: Int = 50,
    val clicks: Int = 0
)

sealed interface Rotation {
    fun rotate(dial: Dial): Dial

    class Left(val steps: Int) : Rotation {
        override fun rotate(dial: Dial): Dial {
            var next = dial.value - steps
            val clicks = when {
                next > 0 -> 0
                next == 0 -> 1
                dial.value == 0 -> next / -100
                else -> next / -100 + 1
            }
            while (next < 0) {
                next += 100
            }
            return Dial(next, dial.clicks + clicks)
        }
    }

    class Right(val steps: Int) : Rotation {
        override fun rotate(dial: Dial): Dial {
            var next = dial.value + steps
            val clicks = when {
                next < 100 -> 0
                else -> next / 100
            }
            while (next > 99) {
                next -= 100
            }
            return Dial(next, dial.clicks + clicks)
        }
    }

    companion object {
        private val encoded = Regex("([RL])(\\d+)")

        fun from(line: String): Rotation {
            val match = requireNotNull(encoded.find(line)) { "Unknown rotation $line" }
            val (_, direction, steps) = match.groupValues
            return when (direction) {
                "R" -> Right(steps.toInt())
                "L" -> Left(steps.toInt())
                else -> throw IllegalArgumentException()
            }
        }
    }
}
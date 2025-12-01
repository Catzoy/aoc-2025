package d01

@JvmInline
value class Dial(val value: Int = 50)

sealed interface Rotation {
    fun rotate(dial: Dial): Dial

    class Left(val steps: Int) : Rotation {
        override fun rotate(dial: Dial): Dial {
            var next = dial.value - steps
            while (next < 0) {
                next += 100
            }
            return Dial(next)
        }
    }

    class Right(val steps: Int) : Rotation {
        override fun rotate(dial: Dial): Dial {
            var next = dial.value + steps
            while (next > 99) {
                next -= 100
            }
            return Dial(next)
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
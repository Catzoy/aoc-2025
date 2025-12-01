import java.io.File

fun readAsInput(day: String): List<String> {
    return File("src/main/kotlin/inputs/$day.txt")
        .readLines()
}
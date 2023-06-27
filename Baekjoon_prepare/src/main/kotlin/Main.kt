import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.StringBuilder

fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine()?.toInt() ?: return

    val input = br.readLine() ?: return
    val element = input.split(" ").map { it.toInt() }.toIntArray()
    val sortedElement = element.sorted()

    val rankMap = sortedElement.distinct().withIndex().associate { it.value to it.index }

    val output = StringBuilder()
    for (i in element) {
        output.append(rankMap[i]).append(" ")
    }

    println(output.toString())
}

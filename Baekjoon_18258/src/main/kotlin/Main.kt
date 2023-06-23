import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine()?.toInt() ?: return

    val q = Queue()
    val output = mutableListOf<Int>()

    repeat(n) {
        val input = br.readLine()
        val command = input.substringBefore(" ")
        val value = input.substringAfter(" ").toIntOrNull()

        when (command) {
            "push" -> {
                value?.let { q.push(it) }
            }
            "pop" -> {
                output.add(q.pop())
            }
            "size" -> {
                output.add(q.size())
            }
            "empty" -> {
                output.add(q.empty())
            }
            "front" -> {
                output.add(q.front())
            }
            "back" -> {
                output.add(q.back())
            }
        }
    }

    output.forEach { println(it) }
}

class Queue {
    val queue = LinkedList<Int>()

    fun push(value: Int) {
        queue.add(value)
    }

    fun empty(): Int {
        return if (queue.isEmpty()) {
            1
        } else {
            0
        }
    }

    fun front(): Int {
        return if (queue.isEmpty()) {
            -1
        } else {
            queue.first
        }
    }

    fun back(): Int {
        return if (queue.isEmpty()) {
            -1
        } else {
            queue.last
        }
    }

    fun pop(): Int {
        return if (queue.isEmpty()) {
            -1
        } else {
            queue.removeFirst()
        }
    }

    fun size(): Int {
        return queue.size
    }
}

import java.util.*

lateinit var color: Array<Int>
lateinit var answer: Array<Boolean>

fun main() = with(System.`in`.bufferedReader()) {
    val N = readLine()?.toInt() ?: return
    answer = Array(N){false}

    for(i in 0 until N){
        val adjList: MutableMap<Int, MutableList<Int>> = mutableMapOf()
        val (V, E) = readLine()?.split(" ")?.map { it.toInt() } ?: return

        for(j in 0 until E){
            val (u, v) = readLine()?.split(" ")?.map { it.toInt() } ?: return
            adjList.computeIfAbsent(u){ mutableListOf() }.add(v)
            adjList.computeIfAbsent(v){ mutableListOf() }.add(u)
        }
        answer[i] = check(adjList, V, E)
    }
    answer.forEach { it->
        if(it){
            println("YES")
        }else{
            println("NO")
        }
    }
}

fun check(adjList: MutableMap<Int, MutableList<Int>>, V: Int, E: Int): Boolean {
    color = Array(V + 1) { 0 }

    for (startNode in 1..V) {
        if (color[startNode] == 0) {
            if (!isBipartite(adjList, startNode)) {
                return false
            }
        }
    }
    return true
}

fun isBipartite(adjList: MutableMap<Int, MutableList<Int>>, startNode: Int): Boolean {
    val queue: Queue<Int> = LinkedList()
    queue.offer(startNode)
    color[startNode] = 1

    while (queue.isNotEmpty()) {
        val cur = queue.poll()

        adjList[cur]?.forEach { nextNode ->
            if (color[nextNode] == 0) {
                queue.offer(nextNode)
                color[nextNode] = color[cur] * -1
            } else if (color[cur] + color[nextNode] != 0) {
                return false
            }
        }
    }
    return true
}


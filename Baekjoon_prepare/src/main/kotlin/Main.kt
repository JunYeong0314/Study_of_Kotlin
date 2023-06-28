import java.util.LinkedList
import java.util.Queue
import java.util.StringTokenizer

lateinit var connected: Array<ArrayList<Int>>
lateinit var visited: Array<Int>
val sb = StringBuilder()
var cnt = 1

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m, r) = readLine().split(" ").map { it.toInt() }

    connected = Array(n + 1) { ArrayList() }
    visited = Array(n + 1) { 0 }

    repeat(m) {
        val st = StringTokenizer(readLine())
        val (v1, v2) = Array(2) { st.nextToken().toInt() }
        connected[v1].add(v2)
        connected[v2].add(v1)
    }

    connected.forEach { it.sort() }
    //connected.forEach { it.reverse() }

    BFS(r)

    for (i in 1..n) {
        sb.append(visited[i]).append("\n")
    }

    print(sb)
}

fun BFS(s : Int){
    val q : Queue<Int> = LinkedList()
    q.offer(s)

    while(!q.isEmpty()){
        var now = q.poll()
        if(visited[now] == 0) visited[now] = cnt++

        connected[now].forEach { value ->
            if(visited[value] == 0){
                visited[value] = cnt++
                q.offer(value)
            }
        }
    }

}
import java.util.LinkedList
import java.util.Queue
import java.util.StringTokenizer
import kotlin.properties.Delegates

lateinit var connected: Array<ArrayList<Int>>
lateinit var dfsVisited: Array<Boolean>

fun main() {
    var (N, M, S) = readLine()?.split(" ")?.map { it.toInt() } ?: return

    connected = Array(N+1){ ArrayList() }
    dfsVisited = Array(N+1){ false }

    for(i in 0 until M){
        val (u, v) = readLine()?.split(" ")?.map { it.toInt() } ?: return
        connected[u].add(v)
        connected[v].add(u)
    }

    connected.forEach { it.sort() }

    DFS(S)
    println()
    BFS(S, N)
}

fun BFS(s : Int, N : Int){
    val visited = Array(N+1){ false }

    val q : Queue<Int> = LinkedList()
    visited[s] = true
    q.offer(s)

    while(!q.isEmpty()){
        val now = q.poll()
        print("$now ")

        connected[now].forEach { value ->
            if(!visited[value]){
                visited[value] = true
                q.offer(value)
            }
        }
    }
}

fun DFS(s : Int){
    if(dfsVisited[s]) return
    dfsVisited[s] = true
    print("$s ")

    connected[s].forEach { next->
        DFS(next)
    }

}
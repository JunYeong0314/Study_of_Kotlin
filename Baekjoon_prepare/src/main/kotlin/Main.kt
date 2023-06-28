import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.StringBuilder
import java.util.*


fun main(args: Array<String>) {
    val (N, M, R) = readLine()?.split(" ")?.map { it.toInt() } ?: return

    val g = Graph(N)
    for(i in 0 until M){
        val (u, v) = readLine()?.split(" ")?.map { it.toInt() } ?: return
        g.addEdge(u, v)
    }
    g.DFS(R)

    for(i in 1..N){
        if(!g.getVisited()[i]){
            println(0)
        }
    }
}

import java.util.*
import kotlin.collections.ArrayDeque

class Graph(val N : Int) {
    private var adj = Array(N+1) { mutableListOf<Int>() }
    private val visited = Array(N+1) { false }

    fun getVisited() : Array<Boolean>{
        return visited
    }
    fun addEdge(u : Int, v : Int){
        adj[u].add(v)
        adj[v].add(u)
    }
    fun DFS(s : Int){
        visited[s] = true
        var stack = Stack<Int>()
        stack.push(s)

        while(!stack.empty()){
            var u = stack.pop()
            println(u)

            adj[u].forEach {v ->
                if(!visited[v]){
                    visited[v] = true
                    stack.push(v)
                }
            }
        }
    }

}
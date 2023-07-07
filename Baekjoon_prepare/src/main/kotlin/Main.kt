import java.util.LinkedList
import java.util.Queue

val visited = Array(100001){ 0 }
fun main() {
    var (x, k) = readLine()?.split(" ")?.map { it.toInt() } ?: return

    println(BFS(x, k))

}

fun BFS(x: Int, k: Int): Int{
    val queue:Queue<Int> = LinkedList<Int>()

    queue.add(x)
    val index = x
    var n = 0

    visited[index] = 1

    while(!queue.isEmpty()){
        n = queue.remove()

        if(n == k){
            return visited[n]-1
        }
        if(n-1 >= 0 && visited[n-1] == 0){
            visited[n-1] = visited[n]+1
            queue.add(n-1)
        }
        if(n+1 <= 100000 && visited[n+1] == 0){
            visited[n+1] = visited[n]+1
            queue.add(n+1)
        }
        if(2*n <= 100000 && visited[n*2] == 0){
            visited[n*2] = visited[n]+1
            queue.add(n*2)
        }
    }
    return -1
}
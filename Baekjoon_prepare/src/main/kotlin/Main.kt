import java.util.ArrayDeque
import java.util.Arrays
import java.util.LinkedList
import java.util.Queue
import java.util.Stack
import kotlin.concurrent.fixedRateTimer

val board = Array(101){ 0 }
val visited = Array(101){ false }
fun main() {
    val (n, m) = readLine()?.split(" ")?.map { it.toInt() } ?: return

    for (i in 0 until n) {
        val (x, y) = readLine()?.split(" ")?.map { it.toInt() } ?: return
        board[x] = y
    }
    for (i in 0 until m) {
        val (u, v) = readLine()?.split(" ")?.map { it.toInt() } ?: return
        board[u] = v
    }
    diceCnt(1, 0)
}

fun diceCnt(start: Int, cnt: Int){
    val queue: Queue<Pair<Int, Int>> = LinkedList<Pair<Int, Int>>()
    queue.offer(Pair(start, cnt))

    while(queue.isNotEmpty()){
        val cur = queue.peek().first
        val curCnt = queue.peek().second
        queue.poll()

        for(i in 1 until 7){
            var next = cur + i
            if(next == 100){
                print(curCnt+1)
                return
            }
            else if(next < 100){
                if(board[next] != 0){
                    next = board[next]
                }
                if(!visited[next]){
                    queue.offer(Pair(next, curCnt+1))
                    visited[next] = true
                }
            }
        }
    }

}




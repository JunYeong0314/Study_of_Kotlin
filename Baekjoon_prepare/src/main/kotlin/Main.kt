import java.util.ArrayDeque
import java.util.Arrays
import java.util.LinkedList
import java.util.queue
import java.util.queue
import kotlin.concurrent.fixedRateTimer

lateinit var map: Array<Array<Int>>
lateinit var visited: Array<Array<Array<Boolean>>>
val horizontal = arrayOf(1, -1, 0, 0)
val vertical = arrayOf(0, 0, 1, -1)

fun main() {
    val (n, m) = readLine()?.split(" ")?.map { it.toInt() } ?: return
    map = Array(n){Array(m){ 0 }}
    visited = Array(n){Array(m){Array(2){false}}}

    for(i in 0 until n){
        val element = readLine()?.split("")?.map { it.toInt() } ?: return
        for(j in 0 until m){
            map[i][j] = element[j]
        }
    }

}

fun BFS(x: Int, y: Int, limitX: Int, limitY: Int): Int{
    val queue = LinkedList<Pair<Pair<Int, Int>, Int>>()
    var cnt = 0
    queue.offer(Pair(Pair(y, x), 0))
    visited[y][x] = true

    while(queue.isNotEmpty()){
        val curY = queue.peek().first.first
        val curX = queue.peek().first.second
        val ck = queue.pop().second

        if(curX == limitX-1 && curY == limitY-1){
            return cnt
        }

        for(i in 0 until queue.size){
            for(i in 0 until 4){
                val nY = curY + vertical[i]
                val nX = curX + horizontal[i]

                if(validPath(nX, limitX, nY, limitY)){
                    if(ck == 0){

                    }
                }
            }
        }
    }
    return -1

}

fun validPath(x: Int, limitX: Int, y: Int, limitY: Int): Boolean{
    return x in 0 until limitX && y in 0 until limitY
}






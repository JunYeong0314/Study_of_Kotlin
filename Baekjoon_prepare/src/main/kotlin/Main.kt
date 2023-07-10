import java.util.Arrays
import java.util.LinkedList
import java.util.Queue
import kotlin.concurrent.fixedRateTimer

val dx = arrayOf(1, -1, 0, 0)
val dy = arrayOf(0, 0, 1, -1)
lateinit var tomato: Array<Array<Int>>
val isArr = mutableListOf<Pair<Int, Int>>()

fun main() {
    val (y, x) = readLine()?.split(" ")?.map { it.toInt() } ?: return
    tomato = Array(x){Array(y){ 0 }}


    for(i in 0 until x){
        val element = readLine()?.split(" ")?.map { it.toInt() } ?: return
        if(element.size != y) println("element is not correct!")
        for(j in 0 until y){
            tomato[i][j] = element[j]
            if(element[j] == 1) isArr.add(Pair(i, j))
        }
    }
    val result = bfs(x, y)

    print(result)
}

fun bfs(x: Int, y: Int): Int{
    val queue: Queue<Pair<Int, Int>> = LinkedList<Pair<Int, Int>>()
    var cnt = -1

    for(i in 0 until isArr.size){
        queue.offer(isArr[i])
    }

    while(queue.isNotEmpty()){
        val qSize = queue.size

        for(i in 0 until qSize){
            val cur = queue.poll()

            for(j in 0 until 4){
                val curX = cur.first + dx[j]
                val curY = cur.second + dy[j]

                if(isValidIndex(curX, curY, x, y) && tomato[curX][curY] != -1 && tomato[curX][curY] != 1){
                    tomato[curX][curY] = 1
                    queue.offer(Pair(curX, curY))
                }
            }
        }
        cnt++
    }

    tomato.forEach { row->
        row.forEach { col->
            if(col == 0){
                cnt = -1
            }
        }
    }

    return cnt
}

fun isValidIndex(x: Int, y: Int, nx: Int, ny: Int): Boolean{
    return x in 0 until nx && y in 0 until ny
}

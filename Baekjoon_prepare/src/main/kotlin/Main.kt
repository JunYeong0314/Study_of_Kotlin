import java.util.Arrays
import java.util.LinkedList
import java.util.Queue
import kotlin.concurrent.fixedRateTimer

val dz = arrayOf(1, -1, 0, 0, 0 ,0)
val dx = arrayOf(0, 0, 1, -1, 0, 0)
val dy = arrayOf(0 ,0, 0, 0, 1, -1)

lateinit var tomato: Array<Array<Array<Int>>>
val isArr = mutableListOf<Triple<Int, Int, Int>>()

fun main() {
    val (y, x, z) = readLine()?.split(" ")?.map { it.toInt() } ?: return
    tomato = Array(z){Array(x){ Array(y){ 0 }}}


    for(i in 0 until z){
        for(j in 0 until x){
            val element = readLine()?.split(" ")?.map { it.toInt() } ?: return
            if(element.size != y) println("element is not correct!")
            for(k in 0 until y){
                tomato[i][j][k] = element[k]
                if(element[k] == 1) isArr.add(Triple(i, j, k))
            }
        }
    }
    val result = bfs(x, y, z)
    print(result)
}

fun bfs(x: Int, y: Int, z: Int): Int{
    val queue: Queue<Triple<Int, Int, Int>> = LinkedList<Triple<Int, Int, Int>>()
    var cnt = -1

    for(i in 0 until isArr.size){
        queue.offer(isArr[i])
    }

    while(queue.isNotEmpty()){
        val qSize = queue.size

        for(i in 0 until qSize){
            val cur = queue.poll()

            for(j in 0 until 6){
                val curZ = cur.first + dz[j]
                val curX = cur.second + dx[j]
                val curY = cur.third + dy[j]

                if(isValidIndex(curZ, curX, curY, z, x, y) && tomato[curZ][curX][curY] != -1 && tomato[curZ][curX][curY] != 1){
                    tomato[curZ][curX][curY] = 1
                    queue.offer(Triple(curZ, curX, curY))
                }
            }
        }
        cnt++
    }

    tomato.forEach { num->
        num.forEach { row->
            row.forEach { col->
                if(col == 0){
                    cnt = -1
                }
            }
        }
    }

    return cnt
}

fun isValidIndex(z: Int, x: Int, y: Int, nz: Int, nx: Int, ny: Int): Boolean{
    return z in 0 until nz && x in 0 until nx && y in 0 until ny
}

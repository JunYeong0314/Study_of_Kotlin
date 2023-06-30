import java.util.LinkedList
import java.util.Queue

lateinit var visited: Array<Array<Boolean>>
lateinit var farm : Array<Array<Int>>
lateinit var numArr : Array<Int>
val dCol = arrayOf(0, 0, 1, -1) // Same left and right
val dRow = arrayOf(1, -1, 0, 0) // Same up and down


fun main() {
    val T = readLine()?.toInt() ?: return // Number of iterations
    numArr = Array(T) { 0 } // Counter of bug number

    for(i in 0 until T){
        val (M, N, K) = readLine()?.split(" ")?.map { it.toInt() } ?: return // Input number of horizontal, veltical and cabbage
        farm = Array(N){Array(M) { 0 }}
        visited = Array(N){Array(M) { false } }
        for(j in 0 until K){
            val (col, row) = readLine()?.split(" ")?.map { it.toInt() } ?: return // Input of cabbage location
            farm[row][col] = 1
        }

        for(k in 0 until N){
            for(l in 0 until M){
                if(farm[k][l] == 1 && !visited[k][l]){
                    BFS(l, k, M, N, i)
                }
            }
        }
    }

    numArr.forEach { v->
        println(v)
    }

}

fun BFS(col : Int, row : Int, M : Int, N : Int, index : Int){
    visited[row][col] = true
    val q : Queue<IntArray> = LinkedList()
    q.add(intArrayOf(row, col))

    while(!q.isEmpty()){
        val curCol = q.peek()[1] // Current horizontal location
        val curRow = q.peek()[0] // Current vertical location
        q.poll()

        for(i in 0 until 4){
            val nCol = curCol + dCol[i] // Horizontal adjacency
            val nRow = curRow + dRow[i] // Vertical adjacency

            if(nCol >= 0 && nRow >= 0 && nCol < M && nRow < N){
                if(farm[nRow][nCol] == 1 && !visited[nRow][nCol]){
                    q.add(intArrayOf(nRow, nCol))
                    visited[nRow][nCol] = true
                }
            }
        }
    }
    numArr[index]++
}

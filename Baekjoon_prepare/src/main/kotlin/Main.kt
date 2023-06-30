import java.util.LinkedList
import java.util.Queue

data class Point(val row: Int, val col: Int)

lateinit var visited: Array<Array<Boolean>>
lateinit var farm : Array<Array<Int>>
lateinit var maze : Array<Array<Int>>
val dCol = arrayOf(0, 0, 1, -1) // Same left and right
val dRow = arrayOf(1, -1, 0, 0) // Same up and down


fun main() {
    val (row, col) = readLine()?.split(" ")?.map { it.toInt() } ?: return
    maze = Array(row){Array(col) {0}}
    visited = Array(row){Array(col) {false} }

    for(i in 0 until row){
        val input = readLine()
        for(j in 0 until col){
            maze[i][j] = input?.substring(j, j+1)?.toInt() ?: 0
        }
    }

    val shortPathLength = BFS(Point(0, 0), Point(row-1, col-1))
    if(shortPathLength != -1){
        println(shortPathLength)
    }else{
        println("ERROR")
    }

}

fun BFS(start: Point, end: Point): Int{
    val queue: Queue<Point> = LinkedList()
    queue.offer(start)
    visited[start.row][start.col] = true

    var pathLength = 1

    while(queue.isNotEmpty()){
        val size = queue.size

        for(i in 0 until size){
            val current = queue.poll()

            if(current == end){
                return pathLength
            }

            for(j in 0 until 4){
                val newRow = current.row + dRow[j]
                val newCol = current.col + dCol[j]

                if(isValidMove(newRow, newCol) && !visited[newRow][newCol]){
                    queue.offer(Point(newRow, newCol))
                    visited[newRow][newCol] = true
                }
            }
        }
        pathLength++
    }
    return -1
}

fun isValidMove(row: Int, col: Int): Boolean{
    val rowSize = maze.size
    val colSize = maze[0].size
    return row in 0 until rowSize && col in 0 until colSize && maze[row][col] != 0
}
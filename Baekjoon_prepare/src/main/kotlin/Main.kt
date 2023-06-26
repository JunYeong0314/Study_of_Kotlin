import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.StringBuilder
import java.util.Arrays
import java.util.Collections
import java.util.LinkedList

lateinit var matrix : Array<Array<Boolean>>
var min = 64

fun main(args: Array<String>) {
    val (row, col) = readLine()?.split(" ")?.map { it.toInt() } ?: return
    matrix = Array(row) {Array(col) {true} }

    for(i in 0 until row){
        val input = readLine() ?: return
        if(input.length != col){
            println("Invalid input")
            return
        }
        for(j in 0 until col){
            if(input[j].toString() == "W"){
                matrix[i][j] = true
            }else{
                matrix[i][j] = false
            }
        }
    }
    val N_row = row - 7
    val N_col = col - 7

    for(i in 0 until N_row){
        for(j in 0 until N_col){
            find(i, j)
        }
    }
    println("$min")
}

fun find(x : Int, y : Int){
    val end_x = x+8
    val end_y = y+8
    var cnt = 0

    var TF = matrix[x][y]

    for(i in x until end_x){
        for(j in y until end_y){
            if(matrix[i][j] != TF){
                cnt++
            }
            TF = (!TF)
        }
        TF = !TF
    }

    cnt = Math.min(cnt, 64-cnt)
    min = Math.min(min, cnt)
}
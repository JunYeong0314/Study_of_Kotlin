import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.StringBuilder
import java.util.Collections
import java.util.LinkedList

fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine()?.toInt() ?: return
    val sb = StringBuilder()
    val numList = mutableListOf<Int>()

    for(i in 0 until n){
        numList.add(br.readLine()?.toInt() ?: return)
    }

    Collections.sort(numList)
    for(i in numList){
        sb.append(i).append('\n')
    }

    print(sb)

}
import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.StringBuilder
import java.util.Collections
import java.util.LinkedList

fun main(args: Array<String>) {
    var n = readLine()?.toInt() ?: return
    n -= 1
    var first = 666

    while(n != 0){
        first += 1
        if(first.toString().contains("666")){
            n -= 1
        }
    }

    print("$first")


}

fun main(args: Array<String>) {
    var (hour, min) = readLine()?.split(" ")?.map{it.toInt()} ?: return
    val plusMin = readLine()?.toInt() ?: return println("정수입력")

    var result = min + plusMin

    if(result >= 60){
        val addHour = result/60
        result %= 60
        val newHour = (hour + addHour) % 24
        println("$newHour $result")
    }else{
        println("$hour $result")
    }


}
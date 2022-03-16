package P13458

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n = readLine().toInt()
    var arr = readLine().split(" ").map { it.toLong() }
    val (a,b) = readLine().split(" ").map { it.toLong() }
    arr =arr.map { it-a }
    var count = arr.size.toLong()
    for (i in arr.indices){
        if(arr[i]<=0) continue
        if(arr[i]%b == 0L){
            count += arr[i]/b
        }else{
            count += arr[i]/b +1
        }
    }
    println(count)
}
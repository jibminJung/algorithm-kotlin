package P1292

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (a,b) = readLine().split(" ").map { it.toInt() }
    val arr = IntArray(1001)
    loop@while (true){
        var i = 1
        var k = 0
        for (j in 1..i){
            if(k+j>1000) break@loop
            arr[k+j] = i
        }
        k += i
        i++

    }
    var sum = 0
    for (i in a..b){
        sum += arr[i]
    }
    println(sum)
}
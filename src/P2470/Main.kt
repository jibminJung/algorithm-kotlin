package P2470

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.absoluteValue

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n = readLine().toInt()
    val arr = readLine().split(" ").map { it.toInt() }.sorted()
    var minDiff = Int.MAX_VALUE
    var minL = 0
    var minR = arr.size-1
    var l = 0
    var r = arr.size-1

    while (l<r){
        val temp = arr[l]+arr[r]
        if (temp.absoluteValue<minDiff) {
            minDiff = temp.absoluteValue
            minL = l
            minR = r
        }
        if(temp>0) r--
        else if(temp<0) l++
        else break
    }
    println("${arr[minL]} ${arr[minR]}")
}
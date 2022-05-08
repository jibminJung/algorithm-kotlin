package P9095

import java.io.BufferedReader
import java.io.InputStreamReader

val sb = StringBuilder()
fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val arr = IntArray(11)
    arr[1] = 1
    arr[2] = 2
    arr[3] = 4
    for (i in 4..10){arr[i] = arr[i-3]+arr[i-2]+arr[i-1]}
    repeat(readLine().toInt()){
        sb.append(arr[readLine().toInt()]).append("\n")
    }
    println(sb)
}
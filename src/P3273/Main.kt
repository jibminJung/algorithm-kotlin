package P3273

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n = readLine().toInt()
    var arr = readLine().split(" ").map { it.toInt() }
    val x = readLine().toInt()
    arr = arr.sorted()
    var i = 0
    var j = arr.size - 1
    var answer = 0
    while (i < j) {
        val temp = arr[i] + arr[j]
        if (temp == x) {
            answer++
            j--
        }else{
            if (temp < x){
                i++
            }else{
                j--
            }
        }
    }
    println(answer)
}
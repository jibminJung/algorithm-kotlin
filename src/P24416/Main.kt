package P24416

import java.io.BufferedReader
import java.io.InputStreamReader

var recur = 0
var dp = 0
fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n = readLine().toInt()
    recur(n)
    dp(n)
    println("$recur $dp")
}

fun recur(n: Int): Int {
    if (n == 1 || n == 2){
        recur++
        return 1
    }
    return (recur(n - 1) + recur(n - 2))
}

fun dp(n:Int){
    val arr = IntArray(n+1)
    arr[1] = 1
    arr[2] = 1
    for (i in 3..n){
        dp++
        arr[i] = arr[i-1]+arr[i-2]
    }
}
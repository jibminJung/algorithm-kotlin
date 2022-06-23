package P1890

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    val n = readLine().toInt()
    val arr = Array(n){readLine().split(" ").map { it.toInt() }.toIntArray()}
    val dp = Array(n){LongArray(n)}
    dp[0][0] = 1
    for (i in 0 until n){
        for (j in 0 until n){
            if(i==n-1&&j==n-1) continue
            val step = arr[i][j]
            if(i+step<n) dp[i+step][j] += dp[i][j]
            if(j+step<n) dp[i][j+step] += dp[i][j]
        }
    }
    println(dp[n-1][n-1])
}
package P2482

import java.io.BufferedReader
import java.io.InputStreamReader

val mod = 1000000003
fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    val n =readLine().toInt()
    val k =readLine().toInt()
    val dp = Array(n+1){IntArray(n+1)}
    for (i in 1..n){
        dp[i][1] = i
        dp[i][0] = 1
    }
    for (i in 3..n){
        for(j in 2..((i+1)/2)){
            dp[i][j] = (dp[i - 1][j] + dp[i - 2][j - 1]) % mod
        }
    }
    println((dp[n - 3][k - 1] + dp[n - 1][k]) % mod)
}
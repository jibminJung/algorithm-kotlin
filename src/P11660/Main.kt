package P11660

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    val (n,m) = readLine().split(" ").map { it.toInt() }
    val arr = Array(1){ IntArray(n+1){0} }+Array(n){ intArrayOf(0)+readLine().split(" ").map { it.toInt() }.toIntArray()}
    val sum = Array(n+1){IntArray(n+1)}
    val sb = StringBuilder()
    for (i in 1..n){
        for (j in 1..n){
            sum[i][j] = sum[i][j-1] + sum[i-1][j] - sum[i-1][j-1] + arr[i][j]
        }
    }
    repeat(m){
        val (x1,y1,x2,y2) = readLine().split(" ").map { it.toInt() }
        val temp = sum[x2][y2] - sum[x1-1][y2] - sum[x2][y1-1] + sum[x1-1][y1-1]
        sb.append(temp).append("\n")
    }
    println(sb)
}
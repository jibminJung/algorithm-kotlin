package P10942

import java.io.BufferedReader
import java.io.InputStreamReader

lateinit var arr: IntArray
lateinit var dp:Array<IntArray>
fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n = readLine().toInt()
    val sb = StringBuilder()
    arr = IntArray(1) + readLine().split(" ").map { it.toInt() }.toIntArray()
    dp = Array(n+1){i -> IntArray(n+1,{-1}) }
    for (i in 1..readLine().toInt()){
        val input = readLine().split(" ").map { it.toInt() }
        sb.append(dp(input.first(),input.last())).append('\n')
    }
    println(sb)
}
fun dp(from:Int,to:Int):Int{
    if(from>=to) return 1
    if(dp[from][to]!=-1){
        return dp[from][to]
    }

    val center = dp(from+1,to-1)
    if(center==1&&(arr[from]==arr[to])){
        dp[from][to] = 1
        return dp[from][to].apply {
            1
        }
    }
    dp[from][to] = 0
    return dp[from][to]
}
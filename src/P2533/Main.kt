package P2533

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.min

lateinit var arr: Array<MutableList<Int>>
lateinit var dp: Array<IntArray>
fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n = readLine().toInt()
    arr = Array(n + 1) { mutableListOf() }
    dp = Array(n+1){ IntArray(2) }
    repeat(n - 1) {
        val (a,b) = readLine().split(" ").map { it.toInt() }
        arr[a].add(b)
        arr[b].add(a)
    }
    dp(1,-1)
    println(min(dp[1][0],dp[1][1]))

}
fun dp(now:Int,parent:Int){
    dp[now][0] = 0
    dp[now][1] = 1
    arr[now].forEach{next ->
        if(next != parent){
            dp(next,now)
            dp[now][0] += dp[next][1]
            dp[now][1] += min(dp[next][0],dp[next][1])
        }
    }
}
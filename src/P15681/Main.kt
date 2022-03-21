package P15681

import java.io.BufferedReader
import java.io.InputStreamReader

lateinit var dp:IntArray
lateinit var arr:Array<MutableList<Int>>
fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (v,root,q) = readLine().split(" ").map { it.toInt() }
    arr = Array(v+1){ mutableListOf()}
    dp = IntArray(v+1){-1}
    repeat(v-1){
        val (from,to) = readLine().split(" ").map { it.toInt() }
        arr[from].add(to)
        arr[to].add(from)
    }
    dfs(root,-1)

    val sb = StringBuilder()
    repeat(q){
        sb.append(dp[readLine().toInt()]).append("\n")
    }
    println(sb)
}

fun dfs(node:Int,parent:Int):Int{
    if(dp[node]!=-1){
        return dp[node]
    }
    dp[node]= 1
    for (next in arr[node]){
        if(next==parent) continue
        dp[node] += dfs(next,node)
    }
    return dp[node]
}
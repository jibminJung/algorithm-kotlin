package P9466

import java.io.BufferedReader
import java.io.InputStreamReader

val sb = StringBuilder()
var cnt = 0
fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    repeat(readLine().toInt()) {
        val n = readLine().toInt()
        val arr = (mutableListOf(0) + readLine().split(" ").map { it.toInt() }).toIntArray()
        val visit = IntArray(n + 1)
        cnt = 0
        for (i in visit.indices) {
            if (visit[i] == 0) {
                dfs(i,arr,visit)
            }
        }
        println(cnt)
        println(visit.joinToString(" "))
    }
}

fun dfs(target:Int,arr:IntArray,visit:IntArray){
    visit[target]++
    if(visit[target]==2) cnt++
    if (visit[arr[target]]<2){
        dfs(arr[target],arr,visit)
    }
    visit[target]--
}
package P4803

import java.io.BufferedReader
import java.io.InputStreamReader

val sb = StringBuilder()
var cycled = false
var cnt = 0
lateinit var arr:Array<MutableList<Int>>
fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    var tc = 0
    while(true){
        tc++
        val (n,m) = readLine().split(" ").map { it.toInt() }
        if(n==0&&m==0) break
        arr = Array(n+1){ mutableListOf<Int>()}
        repeat(m){
            val (from,to) = readLine().split(" ").map { it.toInt() }
            arr[from].add(to)
            arr[to].add(from)
        }
        cnt = 0
        val visit = BooleanArray(n+1)
        for (i in 1 until visit.size){
            if(!visit[i]){
                cycled = false
                dfs(i,0,visit)
                if(!cycled) cnt++
            }
        }
        when(cnt){
            0 -> sb.append("Case $tc: No trees.").append("\n")
            1 -> sb.append("Case $tc: There is one tree.").append("\n")
            else -> sb.append("Case $tc: A forest of $cnt trees.").append("\n")
        }
    }
    println(sb)
}

fun dfs(now:Int,parent:Int,visit:BooleanArray){
    visit[now] = true
    for (next in arr[now]){
        if(next!=parent&&visit[next]) cycled = true
        if(!visit[next]){
            dfs(next,now,visit)
        }
    }
}
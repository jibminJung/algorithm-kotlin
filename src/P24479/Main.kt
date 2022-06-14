package P24479

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.collections.ArrayList

var order = 1
lateinit var arr: Array<ArrayList<Int>>
lateinit var visit: IntArray
fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (n, m, r) = readLine().split(" ").map { it.toInt() }
    arr = Array(n + 1) { ArrayList() }
    visit = IntArray(n + 1)
    repeat(m) {
        val (u, v) = readLine().split(" ").map { it.toInt() }
        arr[u].add(v)
        arr[v].add(u)
    }
    dfs(r)
    println(visit.joinToString("\n").substringAfter("\n"))
}

fun dfs(node:Int){
    if(visit[node]!=0) return
    visit[node] = order++
    arr[node].sorted().forEach {
        dfs(it)
    }
}
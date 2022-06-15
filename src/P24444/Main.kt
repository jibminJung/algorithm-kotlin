package P24444

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

var order = 1
lateinit var arr: Array<ArrayList<Int>>
lateinit var visit: IntArray
fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (n, m, r) = readLine().split(" ").map { it.toInt() }
    arr = Array(n + 1) { ArrayList<Int>() }
    visit = IntArray(n + 1)
    repeat(m) {
        val (u, v) = readLine().split(" ").map { it.toInt() }
        arr[u].add(v)
        arr[v].add(u)
    }
    arr.forEach { it.sort() }
    bfs(r)
    println(visit.joinToString("\n").substringAfter("\n"))
}

fun bfs(node:Int){
    val q = LinkedList<Int>()
    visit[node] = order++
    q.offer(node)
    while(!q.isEmpty()){
        val now = q.poll()
        for(next in arr[now]){
            if(visit[next]!=0) continue
            visit[next] = order++
            q.offer(next)
        }
    }
}
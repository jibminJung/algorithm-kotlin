package P1260

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

lateinit var graph: Array<Array<Boolean>>
lateinit var visit: Array<Boolean>
val sb = StringBuilder()
var n: Int = 0
fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val input = readLine().split(" ").map { it.toInt() }
    n = input[0]
    val m = input[1]
    val v = input[2]
    graph = Array(n + 1) { Array<Boolean>(n + 1) { false } }
    visit = Array(n + 1) { false }
    
    for (i in 1..m) {
        val line = readLine().split(" ").map { it.toInt() }
        graph[line.first()][line.last()] = true
        graph[line.last()][line.first()] = true
    }
    dfs(v)
    sb.append('\n')
    visit = Array(n + 1) { false }
    bfs(v)
    println(sb)
}

fun dfs(node: Int) {
    sb.append(node).append(' ')
    visit[node] = true
    for (i in 1..n) {
        if (graph[node][i] && !visit[i]) {
            dfs(i)
        }
    }
}

fun bfs(start: Int) {
    val q = LinkedList<Int>()
    q.offer(start)
    visit[start] = true
    while (!q.isEmpty()) {
        val now = q.poll()
        sb.append(now).append(' ')
        for (i in 1..n) {
            if (graph[now][i] && !visit[i]) {
                visit[i] = true
                q.offer(i)
            }
        }
    }
}
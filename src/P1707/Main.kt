package P1707

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*


val sb = StringBuilder()
fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    loop@ for (i in 1..readLine().toInt()) {
        val (v, e) = readLine().split(" ").map { it.toInt() }
        val arr = Array(v + 1) { mutableListOf<Int>() }
        repeat(e) {
            val (from, to) = readLine().split(" ").map { it.toInt() }
            arr[from].add(to)
            arr[to].add(from)
        }
        val visit = IntArray(v + 1) { -1 }
        for (start in 1..v) {
            if (visit[start] == -1) {//방문한 적 없을 경우
                if (!bfs(start, arr, visit)){
                    sb.append("NO").append("\n")
                    continue@loop
                }
            }
        }
        sb.append("YES").append("\n")
    }
    println(sb)
}

fun bfs(start: Int, arr: Array<MutableList<Int>>, visit: IntArray): Boolean {
    val q = LinkedList<Int>()
    q.offer(start)
    var flag = true
    loop@ while (!q.isEmpty()) {
        val now = q.poll()
        for (next in arr[now]) {
            if (visit[next] == -1) {
                visit[next] = if (visit[now] == 1) 0 else 1
                q.offer(next)
            }
            if (visit[next] == visit[now]) {
                flag = false
                break@loop
            }
        }
    }
    return flag
}
package P9328

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.collections.HashSet

val sb = StringBuilder()
val dx = arrayOf(1, 0, -1, 0)
val dy = arrayOf(0, 1, 0, -1)
var cnt = 0
fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    repeat(readLine().toInt()) {
        val (h, w) = readLine().split(" ").map { it.toInt() }
        val arr = Array(h+2) {
            if(it in 1..h) ('.'+readLine().trim()+'.').toCharArray()
            else CharArray(w+2){'.'}
        }
        val hs = HashSet<Char>(27)
        hs.addAll(readLine().toCharArray().asIterable())
        cnt = 0
        bfs(arr, hs, h, w)
        sb.append(cnt).append("\n")

    }
    println(sb)
}

fun bfs(arr: Array<CharArray>, hs: HashSet<Char>, h: Int, w: Int) {
    val q = LinkedList<Pair<Int, Int>>()
    val visit = Array(h+2) { BooleanArray(w+2) }
    q.offer(Pair(0,0))
    while (!q.isEmpty()) {
        val qs = q.size
        var flag = true
        repeat(qs) {
            val (x, y) = q.poll()
            if (arr[x][y].isDoor() && hs.contains(arr[x][y].lowercaseChar()).not()) {
                q.offer(Pair(x, y))
                return@repeat
            }
            if (arr[x][y] == '$') cnt++
            flag = false
            for (k in 0..3) {
                val nx = x + dx[k]
                val ny = y + dy[k]
                if ((nx !in 0 .. h+1) || (ny !in 0 .. w+1) || visit[nx][ny]) continue
                if (arr[nx][ny] == '.' || arr[nx][ny] == '$') {
                    q.offer(Pair(nx, ny))
                    visit[nx][ny] = true
                }
                if (arr[nx][ny].isKey()) {
                    hs.add(arr[nx][ny])
                    q.offer(Pair(nx, ny))
                    visit[nx][ny] = true
                }
                if (arr[nx][ny].isDoor()) {
                    q.offer(Pair(nx, ny))
                    visit[nx][ny] = true
                }
            }
        }
        if (flag) break
    }
}

fun Char.isKey(): Boolean = this in 'a'..'z'
fun Char.isDoor(): Boolean = this in 'A'..'Z'


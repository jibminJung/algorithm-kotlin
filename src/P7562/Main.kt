package P7562

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

val sb = StringBuilder()
val dx = arrayOf(2,2,1,1,-1,-1,-2,-2)
val dy = arrayOf(1,-1,2,-2,2,-2,1,-1)
fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    repeat(readLine().toInt()) {
        val l = readLine().toInt()
        val (x, y) = readLine().split(" ").map { it.toInt() }
        val (targetX, targetY) = readLine().split(" ").map { it.toInt() }
        bfs(l, x, y, targetX, targetY)
    }
    println(sb)
}

fun bfs(l: Int, x: Int, y: Int, targetX: Int, targetY: Int) {
    val arr = Array(l) { IntArray(l) }
    val q = LinkedList<Pair<Int, Int>>()
    q.offer(Pair(x, y))
    arr[x][y] = 1
    while (!q.isEmpty()) {
        val (nx, ny) = q.poll()
        if (nx == targetX && ny == targetY) {
            sb.append(arr[nx][ny]-1).append("\n")
            return
        }
        for (k in dx.indices){
            val tx = nx + dx[k]
            val ty = ny + dy[k]
            if(tx !in 0 until l || ty !in 0 until l) continue
            if(arr[tx][ty]==0){
                arr[tx][ty] = arr[nx][ny] + 1
                q.offer(Pair(tx,ty))
            }
        }

    }
}

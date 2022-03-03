package P2178

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

val dx = listOf(1,0,-1,0)
val dy = listOf(0,1,0,-1)

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    val arr = Array(n) { CharArray(m) }
    val dist = Array(n) { IntArray(m) }
    for (i in 0 until n) {
        arr[i] = readLine().toCharArray()
    }
    val q = LinkedList<Pair<Int, Int>>()
    dist[0][0] = 1
    q.offer(Pair(0, 0))
    while (!q.isEmpty()) {
        val (x, y) = q.poll()
        for (k in 0..3){
            var nx = x +dx[k]
            var ny = y +dy[k]
            if(nx<0||nx>=n||ny<0||ny>=m)continue
            if(arr[nx][ny]=='1'&&dist[nx][ny]==0){
                q.offer(Pair(nx,ny))
                dist[nx][ny] = dist[x][y] +1
            }
        }
    }
    println(dist[n-1][m-1])
}
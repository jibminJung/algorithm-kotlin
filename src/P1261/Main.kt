package P1261

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

val dx = arrayOf(0,1,0,-1)
val dy = arrayOf(1,0,-1,0)
fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (m,n) = readLine().split(" ").map { it.toInt() }
    val arr = Array(n){IntArray(m)}
    for (i in 0 until n){
        arr[i] = readLine().toCharArray().map { it.code - '0'.code }.toIntArray()
    }
    var count = 0
    while(true){
        val q = LinkedList<Pair<Int, Int>>()
        val visit = Array(n){BooleanArray(m)}
        q.offer(Pair(0,0))
        visit[0][0] = true
        while(!q.isEmpty()){
            val (x,y) = q.poll()
            for (i in 0..3){
                val nx = x+dx[i]
                val ny = y+dy[i]
                if(nx<0||nx>=n||ny<0||ny>=m) continue
                if(!visit[nx][ny]){
                    visit[nx][ny]=true
                    if(arr[nx][ny]!=1) q.offer(Pair(nx,ny))
                }
            }
        }
        if(visit[n-1][m-1]) break
        count++
        for (i in visit.indices){
            for (j in visit[i].indices){
                if(visit[i][j]) arr[i][j] = 0
            }
        }
    }
    println(count)
}
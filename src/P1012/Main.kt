package P1012

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

val sb =StringBuilder()
val dx = listOf(1,0,-1,0)
val dy = listOf(0,1,0,-1)
lateinit var field:Array<BooleanArray>
fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    repeat(readLine().toInt()){
        val (m,n,k) = readLine().split(" ").map { it.toInt() }
        field = Array(m){BooleanArray(n)}
        repeat(k){
            val (x,y) = readLine().split(" ").map { it.toInt() }
            field[x][y] = true
        }
        var count = 0
        for (i in 0 until m){
            for(j in 0 until n){
                if (field[i][j]){
                    bfs(i,j,m,n)
                    count++
                }
            }
        }
        sb.append(count).append('\n')
    }
    println(sb)
}
fun bfs(i:Int,j:Int,m:Int,n:Int){
    val q = LinkedList<Pair<Int,Int>>()
    q.offer(Pair(i,j))
    field[i][j] = false
    while(!q.isEmpty()){
        val (x,y) = q.poll()
        for (k in 0..3){
            val nx = x + dx[k]
            val ny = y + dy[k]
            if(nx>=0&&nx<m&&ny>=0&&ny<n&&field[nx][ny]){
                q.offer(Pair(nx,ny))
                field[nx][ny] = false
            }
        }
    }
}
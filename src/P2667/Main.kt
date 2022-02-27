package P2667

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

lateinit var arr: Array<IntArray>
var numberOfTown = 1
val towns = mutableListOf<Int>()
val dx = intArrayOf(1, 0, -1, 0)
val dy = intArrayOf(0, 1, 0, -1)
var n =0
fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    n = readLine().toInt()
    arr = Array(n) { IntArray(n) }
    for (i in 0 until n){
        arr[i] = readLine().toCharArray().map { it.code-48 }.toIntArray()
    }
    for (i in 0 until n){
        for (j in 0 until n){
            if(arr[i][j]==1){
                towns.add(bfs(i,j, ++numberOfTown))
            }
        }
    }
    println(numberOfTown-1)
    towns.sort()
    println(towns.joinToString("\n"))
}
fun bfs(i:Int,j:Int,number:Int):Int{
    var count = 1
    val q = LinkedList<Pair<Int,Int>>()
    q.offer(Pair(i,j))
    arr[i][j] = number
    while(!q.isEmpty()){
        val now = q.poll()
        val tx = now.first
        val ty = now.second
        for (k in 0..3){
            val ntx = tx+dx[k]
            val nty = ty+dy[k]
            if(ntx<0||ntx>=n||nty<0||nty>=n){
                continue
            }
            if(arr[ntx][nty]==1){
                q.offer(Pair(ntx,nty))
                arr[ntx][nty] = number
                count++
            }
        }
    }
    return count
}
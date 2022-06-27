package P13549

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.math.min

val max = 100000
fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    val (n,k) = readLine().split(" ").map { it.toInt() }
    val visit = BooleanArray(max+1)
    val q = LinkedList<Pair<Int,Int>>()
    var answer = Int.MAX_VALUE
    q.offer(Pair(n,0))
    while(!q.isEmpty()){
        val now = q.poll()
        visit[now.first] = true
        if(now.first==k) answer = min(answer,now.second)

        if(now.first*2<=max && !visit[now.first*2]) q.offer(Pair(now.first*2,now.second))
        if(now.first+1<=max && !visit[now.first+1]) q.offer(Pair(now.first+1,now.second+1))
        if(now.first-1>=0 && !visit[now.first-1]) q.offer(Pair(now.first-1,now.second+1))
    }
    println(answer)
}
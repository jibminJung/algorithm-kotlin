package P1697

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (n, k) = readLine().split(" ").map { it.toInt() }
    val dist = IntArray(100001)
    val q = LinkedList<Int>()
    q.offer(n)
    dist[n]=1
    loop@ while (!q.isEmpty()) {
        val now = q.poll()
        var next = 0
        for (i in 0..2) {
            when (i) {
                0 -> next = now + 1
                1 -> next = now - 1
                2 -> next = now *2
            }
            if(next<0||next>100000) continue
            if(dist[next]==0){
                q.offer(next)
                dist[next] = dist[now] + 1
                if(next==k) break@loop
            }
        }
    }
    println(dist[k]-1)
}
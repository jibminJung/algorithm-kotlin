package P1715

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    val n = readLine().toInt()
    var ans = 0
    val pq = PriorityQueue<Int>()
    repeat(n){
        pq.offer(readLine().toInt())
    }
    while(pq.size>1){
        val sum = pq.poll() + pq.poll()
        pq.offer(sum)
        ans+=sum
    }
    println(ans)
}
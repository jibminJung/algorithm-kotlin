package P2623

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

val sb = StringBuilder()
fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    val (n,m) = readLine().split(" ").map { it.toInt() }
    val arr =Array(n+1){ mutableListOf<Int>()}
    val inDegree = IntArray(n+1)
    repeat(m){
        val order = readLine().split(" ").map { it.toInt() }
        for (i in 1 until order.size-1){
            arr[order[i]].add(order[i+1])
            inDegree[order[i+1]]++
        }
    }
    val q = LinkedList<Int>()
    var count = 0
    for (i in 1 until inDegree.size){
        if(inDegree[i]==0) q.offer(i)
    }
    if(q.isEmpty()) {
        sb.append("0")
    }
    else{
        while(!q.isEmpty()){
            val now = q.poll()
            sb.append(now).append("\n")
            count++
            for (next in arr[now]){
                if(--inDegree[next]==0){
                    q.offer(next)
                }
            }
        }
    }
    if(count!=n){
        sb.clear()
        sb.append("0")
    }
    println(sb)
}
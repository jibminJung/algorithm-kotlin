package P1916

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.Comparator

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    val n = readLine().toInt()
    val m = readLine().toInt()
    val dist = IntArray(n+1){-1}
    val edges = Array(n+1){mutableListOf<Node>()}
    repeat(m){
        val (from,to,cost) = readLine().split(" ").map { it.toInt() }
        edges[from].add(Node(to,cost))
    }
    val (start,end) = readLine().split(" ").map { it.toInt() }
    val pq = PriorityQueue<Node>(Comparator.comparingInt(Node::cost))
    pq.offer(Node(start,0))
    dist[start]=0
    while(!pq.isEmpty()){
        val (now,cost) = pq.poll()
        if(now==end) break
        for (next in edges[now]){
            if(dist[next.to]==-1||dist[next.to]>cost+next.cost){
                dist[next.to] = cost + next.cost
                pq.offer(Node(next.to,cost+next.cost))
            }
        }
    }
    println(dist[end])

}
data class Node(
    val to:Int,
    val cost:Int
)
package P1238

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.math.max

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (n,m,x) = readLine().split(" ").map { it.toInt() }
    val straight = Array(n+1){ mutableListOf<Edge>()}
    val reverse = Array(n+1){ mutableListOf<Edge>()}
    repeat(m){
        val (from,to,w) = readLine().split(" ").map { it.toInt() }
        straight[from].add(Edge(to,w))
        reverse[to].add(Edge(from,w))
    }
    //start from x
    val pq = PriorityQueue(Comparator.comparingInt(Edge::weight))
    val dist = Array(n+1){Int.MIN_VALUE}
    pq.offer(Edge(x,0))
    dist[x] = 0
    while (!pq.isEmpty()){
        val (now,w) = pq.poll()
        for ((next,weight) in straight[now]){
            if(dist[next]==Int.MIN_VALUE || dist[now]+weight<dist[next]){
                dist[next] = dist[now]+weight
                pq.offer(Edge(next,w+weight))
            }
        }
    }
    val rDist = Array(n+1){Int.MIN_VALUE}
    pq.offer(Edge(x,0))
    rDist[x] = 0
    while (!pq.isEmpty()){
        val (now,w) = pq.poll()
        for ((next,weight) in reverse[now]){
            if(rDist[next]==Int.MIN_VALUE || rDist[now]+weight<rDist[next]){
                rDist[next] = rDist[now]+weight
                pq.offer(Edge(next,w+weight))
            }
        }
    }
    var answer = 0
    for (i in 1..n){
        answer = max(answer,dist[i]+rDist[i])
    }
    println(answer)
}

data class Edge(
    val next:Int,
    val weight : Int
)


package P1948

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

var count = 0
fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val n = readLine().toInt()
    val m = readLine().toInt()
    val edges = Array(n+1){ mutableListOf<Edge>()}
    val inDegree = Array(n+1){0}
    val record = Array(n+1){Node()}
    repeat(m){
        val (from,to,weight) = readLine().split(" ").map { it.toInt() }
        inDegree[to]++
        edges[from].add(Edge(to,weight))
    }
    val (start, end) = readLine().split(" ").map { it.toInt() }
    val q = LinkedList<Pair<Int,Int>>()
    q.offer(Pair(start,0))
    while(!q.isEmpty()){
        val now = q.poll()
        edges[now.first].forEach { next ->
            val time = now.second + next.weight
            inDegree[next.to]--
            if(record[next.to].timeRecord<time){
                record[next.to] = Node(time, mutableListOf(now.first))
            }else if(record[next.to].timeRecord==time){
                record[next.to].parents.add(now.first)
            }
            if(inDegree[next.to]==0){
                q.offer(Pair(next.to,record[next.to].timeRecord))
            }
        }
    }
    println(record[end].timeRecord)

    //end 부터 bfs로 카운트
    bfs(end,n,record)
    println(count)

}

fun bfs(start:Int,n:Int,record:Array<Node>){
    val visit = Array(n+1){false}
    val q = LinkedList<Int>()
    q.offer(start)
    while(!q.isEmpty()){
        val now = q.poll()
        if(visit[now]) continue
        visit[now] = true
        record[now].parents.forEach { next ->
            if(!visit[next]){
                q.offer(next)
            }
            count++
        }
    }

}
data class Edge(
    val to:Int,
    val weight:Int
)
data class Node(
    var timeRecord : Int = 0,
    var parents: MutableList<Int> = mutableListOf()
)

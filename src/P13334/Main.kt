package P13334

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    val n = readLine().toInt()
    val arr = mutableListOf<Pair<Int,Int>>()
    var answer = 0
    repeat(n){
        val (h,o) = readLine().split(" ").map { it.toInt() }
        arr.add(if (h<o) h to o else o to h)
    }
    val d = readLine().toInt()
    arr.sortWith(compareBy({it.second},{it.first}))
    val pq = PriorityQueue<Pair<Int,Int>>(compareBy { it.first })
    for (edge in arr){
        val coverage = edge.second-d
        if(coverage<=edge.first){
            pq.offer(edge)
        }
        while(!pq.isEmpty()&&coverage>pq.peek().first){
            pq.poll()
        }
        answer = Math.max(answer,pq.size)
    }
    println(answer)
}
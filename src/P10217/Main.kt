package P10217

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.math.min

val sb = StringBuilder()
fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    repeat(readLine().toInt()) {
        val (n, m, k) = readLine().split(" ").map { it.toInt() }
        val edges = Array(n + 1) { mutableListOf<Triple<Int, Int, Int>>() }
        val dp = Array(n + 1) { IntArray(m + 1) { Int.MAX_VALUE } }
        repeat(k) {
            val (from, to, c, d) = readLine().split(" ").map { it.toInt() }
            edges[from].add(Triple(to, c, d))
        }
        val pq = PriorityQueue<Triple<Int, Int, Int>>(compareBy { it.third })
        pq.offer(Triple(1, 0, 0))
        dp[1][0] = 0
        while (!pq.isEmpty()) {
            val now = pq.poll()
            if(dp[now.first][now.second]<now.third)continue
            for (next in edges[now.first]) {
                val nextCost = now.second + next.second
                if(nextCost>m)continue
                val nextTIme = now.third + next.third
                if (dp[next.first][nextCost] > nextTIme) {
                    for(i in nextCost..m){
                        dp[next.first][i] = min(dp[next.first][i],nextTIme)
                    }
                    dp[next.first][nextCost] = now.third + next.third
                    pq.offer(Triple(next.first, now.second + next.second, now.third + next.third))
                }
            }
        }
        var answer = Int.MAX_VALUE
        for (i in 0..m){
            answer = min(answer,dp[n][i])
        }
        sb.append(if (answer == Int.MAX_VALUE) "Poor KCM" else answer).append('\n')
    }
    println(sb)
}
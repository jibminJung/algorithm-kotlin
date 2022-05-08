package P1033

import java.io.BufferedReader
import java.io.InputStreamReader

lateinit var visit:BooleanArray
lateinit var arr:Array<MutableList<Triple<Int,Int,Int>>>
lateinit var answer:LongArray
fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n = readLine().toInt()
    visit = BooleanArray(n)
    arr =Array(n){ mutableListOf()}
    var lcm= 1L
    for (i in 0 until n-1){
        val (a,b,p,q) = readLine().split(" ").map { it.toInt() }
        arr[a].add(Triple(b,p,q))
        arr[b].add(Triple(a,q,p))
        lcm *= (p*q)/gcd(p.toLong(),q.toLong())
    }
    answer = LongArray(n)
    answer[0] = lcm
    dfs(0)
    val gcd = answer.reduce{a,b -> gcd(a,b)}
    println(answer.joinToString (separator = " "){(it/gcd).toString() })
}

fun dfs(now:Int){
    visit[now] = true
    for ((next,p,q) in arr[now]){
        if(!visit[next]){
            answer[next] = answer[now] * q/p
            dfs(next)
        }
    }
}

fun gcd(a: Long, b: Long) :Long {
    if (b == 0L) return a
    return gcd(b, a % b)
}
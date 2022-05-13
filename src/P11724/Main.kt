package P11724

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

lateinit var visit:BooleanArray
lateinit var arr:Array<MutableList<Int>>
fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    val (n,m) = readLine().split(" ").map { it.toInt() }
    arr= Array(n+1){ mutableListOf<Int>()}
    visit = BooleanArray(n+1)
    var answer = 0
    repeat(m){
        val st = StringTokenizer(readLine())
        val u = st.nextToken().toInt()
        val v = st.nextToken().toInt()
        arr[u].add(v)
        arr[v].add(u)
    }
    for (i in 1..n){
        if(!visit[i]){
            answer++
            dfs(i)
        }
    }
    println(answer)
}

fun dfs(now:Int){
    visit[now] = true
    for (next in arr[now]){
        if(!visit[next]) dfs(next)
    }
}
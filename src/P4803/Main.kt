package P4803

import java.io.BufferedReader
import java.io.InputStreamReader

var cycled = false
fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    while(true){
        val (n,m) = readLine().split(" ").map { it.toInt() }
        if(n==0&&m==0) break
        val arr = Array(n+1){ mutableListOf<Int>()}
        repeat(m){
            val (from,to) = readLine().split(" ").map { it.toInt() }
            arr[from].add(to)
            arr[to].add(from)
        }
        val visit = BooleanArray(n+1)
        for (i in 1 until visit.size){
            if(!visit[i]){
                cycled = false
                dfs(i,0)
            }
        }
    }
}

fun dfs(now:Int,parent:Int){

}
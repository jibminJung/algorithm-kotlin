package P14425

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    val (n,m) = readLine().split(" ").map { it.toInt() }
    val hs = HashSet<String>()
    repeat(n){
        hs.add(readLine())
    }
    var ans = 0
    repeat(m){
        if(hs.contains(readLine())) ans++
    }
    println(ans)
}
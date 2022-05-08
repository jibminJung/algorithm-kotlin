package P1764

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    val (n,m) = readLine().split(" ").map { it.toInt() }
    val hs = HashSet<String>()
    val arr = mutableListOf<String>()
    repeat(n){hs.add(readLine())}
    repeat(m){ readLine().also { if(hs.contains(it)) arr.add(it) } }
    println(arr.size)
    println(arr.sorted().joinToString("\n"))
}
package P10815

import java.io.BufferedReader
import java.io.InputStreamReader

val sb = StringBuilder()
fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    val n = readLine().toInt()
    val hs = readLine().split(" ").map { it.toInt() }.toHashSet()
    val m = readLine().toInt()
    readLine().split(" ").map { it.toInt() }.forEach{ sb.append(if(hs.contains(it)) 1 else 0).append(" ")}
    println(sb)
}
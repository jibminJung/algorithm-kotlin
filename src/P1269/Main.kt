package P1269

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    fun input() = readLine().split(" ").map { it.toInt() }
    val (a,b) = input()
    val aSet = input().toHashSet()
    val bSet = input().toHashSet()
    val subSet1 = aSet-bSet
    val subSet2 = bSet-aSet
    println(subSet1.size+subSet2.size)
}
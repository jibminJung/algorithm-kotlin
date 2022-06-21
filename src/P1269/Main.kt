package P1269

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    fun input() = readLine().split(" ").map { it.toInt() }
    val (a,b) = input()
    val inter = input().toSet().intersect(input()).count()
    println(a-inter+b-inter)
}
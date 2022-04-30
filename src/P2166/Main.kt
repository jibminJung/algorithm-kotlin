package P2166

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.absoluteValue

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n = readLine().toInt()
    val arr = mutableListOf<Pair<Long, Long>>()
    repeat(n) {
        val (x, y) = readLine().split(" ").map { it.toLong() }
        arr.add(Pair(x, y))
    }
    val pivot = arr[0]
    var sum = 0L
    for (i in 1 until n-1) {
        sum += ccw(pivot, arr[i], arr[i + 1])
    }
    println((sum.absoluteValue / 2).toString() + if(sum%2==0L) ".0" else ".5")
}

fun ccw(p0: Pair<Long, Long>, p1: Pair<Long, Long>, p2: Pair<Long, Long>): Long {
    return ((p0.first * p1.second) + (p1.first * p2.second) + (p2.first * p0.second)) - ((p0.second * p1.first) + (p1.second * p2.first) + (p2.second * p0.first))
}
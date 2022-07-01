package P11758

import java.io.BufferedReader
import java.io.InputStreamReader

typealias Point = Pair<Int,Int>

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    fun readPoint() = readLine().split(" ").map { it.toInt() }.let { Point(it[0],it[1]) }
    println(ccw(readPoint(),readPoint(),readPoint()))
}

fun ccw(p1: Point, p2: Point, p3: Point): Int {
    val result =
        (p1.first * p2.second + p2.first * p3.second + p3.first * p1.second) - (p2.first * p1.second + p3.first * p2.second + p1.first * p3.second)
    if (result > 0) return 1
    else if (result < 0) return -1
    return 0
}
package P1004

import java.io.BufferedReader
import java.io.InputStreamReader

val sb = StringBuilder()
fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    repeat(readLine().toInt()) {
        val (sx, sy, gx, gy) = readLine().split(" ").map { it.toInt() }
        val n = readLine().toInt()
        var count =0
        repeat(n) {
            val (cx, cy, cr) = readLine().split(" ").map { it.toInt() }
            if(check(sx,sy,cx, cy, cr) xor check(gx,gy,cx, cy, cr)) count++
        }
        sb.append(count).append("\n")
    }
    println(sb)
}

fun check(x: Int, y: Int, cx: Int, cy: Int, cr: Int) = (cx - x) * (cx - x) + (cy - y) * (cy - y) < cr * cr


package P1358

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.sqrt

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (w, h, x, y, p) = readLine().split(" ").map { it.toInt() }
    val radius = h/2
    val r1 = Pair(x,y+radius)
    val r2 = Pair(x+w,y+radius)
    var cnt = 0
    repeat(p){
        val (a,b) = readLine().split(" ").map{it.toInt()}
        if(a in x..x+w && b in y..y+h || r1.distanceTo(a,b)<=radius || r2.distanceTo(a,b)<=radius) cnt++
    }
    println(cnt)
}

fun Pair<Int, Int>.distanceTo(a:Int,b:Int) =
    sqrt(((first - a) * (first - a)).toDouble() + ((second - b) * (second - b)))

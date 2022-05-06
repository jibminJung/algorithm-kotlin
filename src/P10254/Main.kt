package P10254

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.Comparator

typealias Point = Pair<Long, Long>

val sb = StringBuilder()
fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    repeat(readLine().toInt()) {
        val arr = Array(readLine().toInt()) { readLine().split(" ").map { it.toLong() } }.map { Pair(it[0], it[1]) }
        rotatingCalipers(getConvexHull(arr))
    }
    println(sb)
}

operator fun Point.minus(point:Point) = Point(this.first-point.first,this.second-point.second)

fun rotatingCalipers(polygon: List<Point>) {
    val n = polygon.size
    var j = 1
    var maxDist = 0L
    var maxI = 0
    var maxJ = 0
    for (i in polygon.indices){
        val caliper = polygon[(i+1)%n] - polygon[i]
        while(ccw(Point(0L,0L),caliper,polygon[(j+1)%n]-polygon[j])>0){
            j = (j+1)%n
        }
        if(maxDist<dist(polygon[i],polygon[j])){
            maxDist = dist(polygon[i],polygon[j])
            maxI = i
            maxJ = j
        }
    }
    sb.append("${polygon[maxI].first} ${polygon[maxI].second} ${polygon[maxJ].first} ${polygon[maxJ].second}").append("\n")
}

fun getConvexHull(points: List<Pair<Long, Long>>): List<Point> {

    var pivot = Point(Long.MAX_VALUE, Long.MAX_VALUE)

    for (point in points) {
        if (point.second < pivot.second) {
            pivot = point
        } else if (point.second == pivot.second) {
            if (point.first < pivot.first) {
                pivot = point
            }
        }
    }

    val sorted = points.sortedWith(Comparator { o1, o2 ->
        val ccw = ccw(pivot, o1, o2)
        if (ccw < 0) return@Comparator 1
        else if (ccw > 0) return@Comparator -1
        val dist1 = dist(pivot, o1)
        val dist2 = dist(pivot, o2)
        if (dist1 > dist2) return@Comparator 1
        else return@Comparator -1
    })

    val stack = Stack<Point>()
    stack.push(sorted.first())
    for (i in 1 until sorted.size) {
        while (stack.size > 1 && ccw(stack[stack.size - 2], stack[stack.size - 1], sorted[i]) <= 0) {
            stack.pop()
        }
        stack.push(sorted[i])
    }

    return stack.toList()
}

fun ccw(p1: Point, p2: Point, p3: Point): Int {
    val result =
        (p1.first * p2.second + p2.first * p3.second + p3.first * p1.second) - (p2.first * p1.second + p3.first * p2.second + p1.first * p3.second)
    if (result > 0) return 1
    else if (result < 0) return -1
    return 0
}

fun dist(p1: Point, p2: Point): Long {
    return (p2.first - p1.first) * (p2.first - p1.first) + (p2.second - p1.second) * (p2.second - p1.second)
}

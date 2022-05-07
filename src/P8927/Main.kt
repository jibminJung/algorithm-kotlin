package P8927

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.Comparator

typealias Point = Pair<Int, Int>

val origin = Point(0, 0)
val sb = StringBuilder()
fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    repeat(readLine().toInt()) {
        val arr = mutableListOf<Point>()
        repeat(readLine().toInt()) {
            val st = StringTokenizer(readLine())
            val x = st.nextToken().toInt()
            val y = st.nextToken().toInt()
            val w = st.nextToken().toInt()
            arr.add(Point(x, y))
            arr.add(Point(x, y + w))
            arr.add(Point(x + w, y))
            arr.add(Point(x + w, y + w))
        }
        rotatingCalipers(getConvexHull(arr))
    }
    println(sb)
}

operator fun Point.minus(point: Point) = Point(this.first - point.first, this.second - point.second)

fun rotatingCalipers(polygon: List<Point>) {
    val n = polygon.size
    var j = 1
    var nextJ = (j + 1) % n
    var maxDist = 0
    for (i in polygon.indices) {
        val caliper = polygon[(i + 1) % n] - polygon[i]
        while (ccw(origin, caliper, polygon[nextJ] - polygon[j]) > 0) {
            j = nextJ
            nextJ = (nextJ + 1) % n
        }
        val dist = dist(polygon[i], polygon[j])
        if (maxDist < dist) {
            maxDist = dist
        }
    }
    sb.append(maxDist).append("\n")
}

fun getConvexHull(points: MutableList<Point>): List<Point> {

    var pivot = Point(Int.MAX_VALUE, Int.MAX_VALUE)

    for (point in points) {
        if (point.second < pivot.second) {
            pivot = point
        } else if (point.second == pivot.second) {
            if (point.first < pivot.first) {
                pivot = point
            }
        }
    }

    points.sortWith(Comparator { o1, o2 ->
        val ccw = ccw(pivot, o1, o2)
        if (ccw < 0) return@Comparator 1
        else if (ccw > 0) return@Comparator -1
        val dist1 = dist(pivot, o1)
        val dist2 = dist(pivot, o2)
        if (dist1 > dist2) return@Comparator 1
        else return@Comparator -1
    })

    val stack = Stack<Point>()
    stack.push(points.first())
    for (i in 1 until points.size) {
        while (stack.size > 1 && ccw(stack[stack.size - 2], stack[stack.size - 1], points[i]) <= 0) {
            stack.pop()
        }
        stack.push(points[i])
    }

    return stack.toList()
}

fun ccw(p1: Point, p2: Point, p3: Point) = (p1.first * p2.second + p2.first * p3.second + p3.first * p1.second) - (p2.first * p1.second + p3.first * p2.second + p1.first * p3.second)


fun dist(p1: Point, p2: Point) = (p2.first - p1.first) * (p2.first - p1.first) + (p2.second - p1.second) * (p2.second - p1.second)

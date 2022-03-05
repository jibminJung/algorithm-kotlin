package P3679

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

typealias Point = Pair<Long, Long>

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    val arr = mutableListOf<Point>()
    var bottomPoint = Point(40001, 40001)
    for (i in 1..readLine().toInt()){ //자료 받으면서 가장 밑 좌표 저장
        val (x,y) = readLine().split(" ").map { it.toLong() }
        arr.add(Pair(x,y))
        if(y<bottomPoint.second){
            bottomPoint = Point(x,y)
        }else if(y==bottomPoint.second){
            if(x<bottomPoint.first){
                bottomPoint = Point(x,y)
            }
        }
    }
    //ccw 방향으로 정렬, 직선 상이면 거리순 정렬
    arr.sortWith(kotlin.Comparator { o1, o2 ->
        val result = ccw(bottomPoint,o1,o2)
        if(result>0) return@Comparator -1
        else if(result<0) return@Comparator 1
        else{
            if(dist(bottomPoint,o1)>dist(bottomPoint,o2)){
                return@Comparator 1
            }
        }
        return@Comparator -1
    })
    //Graham Scan
    val stack = Stack<Point>()
    stack.add(bottomPoint)
    for (i in 1 until arr.size){
        while(stack.size>1&&ccw(stack[stack.size-2], stack[stack.size-1],arr[i])<=0){
            stack.pop()
        }
        stack.add(arr[i])
    }
    println(stack.size)
}

fun ccw(p1: Point, p2: Point, p3: Point): Int {
    /*
    x1 x2 x3 x1
    y1 y2 y3 y1
     */
    val result =
        (p1.first * p2.second + p2.first * p3.second + p3.first * p1.second) - (p2.first * p1.second + p3.first * p2.second + p1.first * p3.second)
    if (result > 0) return 1
    if (result < 0) return -1
    return 0
}

fun dist(p1: Point, p2: Point): Long {
    return (p2.first - p1.first) * (p2.first - p1.first) + (p2.second - p1.second) * (p2.second - p1.second)
}
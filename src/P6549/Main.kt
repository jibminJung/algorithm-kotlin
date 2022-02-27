package P6549

import kotlin.math.max
import kotlin.math.min

val sb = StringBuilder()
lateinit var arr: LongArray
fun main() = with(System.`in`.bufferedReader()) {
    while (true) {
        arr = readLine().split(" ").map { it.toLong() }.toLongArray()
        if (arr[0] == 0L) break;
        arr = arr.sliceArray(1 until arr.size)
        sb.append(dnq(0,arr.size-1)).append('\n')
    }
    println(sb)
}

fun dnq(left: Int, right: Int): Long {
    if (left == right) {
        return arr[left]
    }
    val mid = (left + right) / 2
    val leftSide = dnq(left, mid)
    val rightSide = dnq(mid + 1, right)
    val fromMid = getMidArea(left, right, mid)
    return max(fromMid,max(leftSide, rightSide))
}

fun getMidArea(left: Int, right: Int, mid: Int): Long {
    var toLeft = mid;
    var toRight = mid;
    var height = arr[mid]
    var maxArea = height
    while (left < toLeft && toRight < right) {
        if (arr[toLeft - 1] < arr[toRight + 1]) {
            toRight++;
            height = min(height, arr[toRight])
        } else {
            toLeft--
            height = min(height, arr[toLeft])
        }
        maxArea = max(maxArea, height * (toRight - toLeft + 1))
    }
    while (toRight < right) {
        toRight++
        height = min(height, arr[toRight])
        maxArea = max(maxArea, height * (toRight - toLeft + 1))
    }
    while (left < toLeft) {
        toLeft--
        height = min(height, arr[toLeft])
        maxArea = max(maxArea, height * (toRight - toLeft + 1))
    }
    return maxArea
}
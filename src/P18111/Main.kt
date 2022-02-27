package P18111

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.absoluteValue

lateinit var arr: Array<IntArray>
var n = 0
var m = 0
var b = 0
fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val input = readLine().split(" ").map { it.toInt() }
    n = input[0]
    m = input[1]
    b = input[2]
    arr = Array(n) { IntArray(m) }
    for (i in 0 until n) {
        arr[i] = readLine().split(" ").map { it.toInt() }.toIntArray()
    }
    var minTime = 256 * 500 * 500 * 2 + 1
    var maxHeight = 0
    for (i in 0..256) {
        val time = checkBlock(i)
        if (time != -1) {
            if (time <= minTime){
                minTime = time
                maxHeight = i
            }
        }
    }
    println("$minTime $maxHeight")
}

fun checkBlock(height: Int): Int {
    var sum = 0
    var time = 0
    for (i in 0 until n) {
        for (j in 0 until m) {
            val diff = height - arr[i][j]
            sum += diff
            time += if (diff >= 0) diff else diff.absoluteValue * 2
        }
    }
    return if (sum <= b) time else -1
}
package P2477

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.max

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val k = readLine().toInt()
    var maxW = 0
    var maxH = 0
    var smallArea = 0
    val arr = Array(6) {
        readLine().split(" ").map { it.toInt() }
    }
    val match = arrayOf(0, 3, 4, 2, 1)
    for (i in arr.indices) {
        if (arr[i][0] < 3) {
            maxW = max(maxW, arr[i][1])
        } else {
            maxH = max(maxH, arr[i][1])
        }
        if (match[arr[i][0]] == arr[(i + 1) % 6][0]) {
            smallArea = arr[i][1] * arr[(i + 1) % 6][1]
        }
    }
    val area = maxW * maxH - smallArea
    println(area*k)
}
package P14890

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (n, l) = readLine().split(" ").map { it.toInt() }
    val arr = Array(n) { IntArray(n) }
    for (i in 0 until n) {
        arr[i] = readLine().split(" ").map { it.toInt() }.toIntArray()
    }
    val narr = Array(n) { IntArray(n) }
    for (i in 0 until n) {
        for (j in 0 until n) {
            narr[i][j] = arr[j][i]
        }
    }
    println(solve(arr, n, l)+solve(narr, n, l))

}

fun solve(arr: Array<IntArray>, n: Int, l: Int): Int {
    var countRoad = 0
    for (i in 0 until n) {
        var j = 0
        var flat = 1
        var flag = false
        val ramp = BooleanArray(n)
        while (j < n - 1) {
            if (arr[i][j] == arr[i][j + 1]) {//same level frontward
                flat++
                j++
            } else {
                if (arr[i][j + 1] - arr[i][j] == 1) {//오르막
                    val level = arr[i][j]
                    var count = 0
                    for (x in j downTo 0) {
                        if (arr[i][x] == level && ramp[x].not()) count++
                        else break
                    }
                    if (count >= l) {
                        for (x in 0 until l) {
                            ramp[j - x] = true
                        }
                        j++
                    } else {
                        flag = true
                        break;
                    }
                } else if (arr[i][j + 1] - arr[i][j] == -1) {//내리막
                    val level = arr[i][j + 1]
                    var count = 0
                    for (x in j + 1 until n) {
                        if (arr[i][x] == level && ramp[x].not()) count++
                        else break
                    }
                    if (count >= l) {
                        for (x in 1..l) {
                            ramp[j + x] = true
                        }
                        j++
                    } else {
                        flag = true
                        break;
                    }
                } else {//높이 둘 이상
                    break
                }
            }
            if (j == n - 1) countRoad++
        }
    }
    return countRoad
}

package P21608

import java.io.BufferedReader
import java.io.InputStreamReader

val dx = arrayOf(0, 1, 0, -1)
val dy = arrayOf(1, 0, -1, 0)
var n = 0
lateinit var arr: Array<IntArray>
lateinit var like: Array<BooleanArray>
val list = ArrayList<Int>()
fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    n = readLine().toInt()
    arr = Array(n) { IntArray(n) }
    like = Array(n + 1) { BooleanArray(n + 1) }

    for (i in 1..n * n) {
        val input = readLine().split(" ").map { it.toInt() }
        for (j in 1..4) {
            like[input[0]][input[j]] = true
        }
        list.add(input[0])
    }
    list.forEach {
        var mostLike = 0
        var mostEmpty = 0
        var x = 0
        var y = 0
        for (i in 0 until n) {
            for (j in 0 until n) {
                if (arr[i][j] != 0) continue
                val (like, empty) = check(i, j, it)
                if (like > mostLike) {
                    mostLike = like
                    mostEmpty = empty
                    x = i
                    y = j
                } else if (like == mostLike) {
                    if (empty > mostEmpty) {
                        mostLike = like
                        mostEmpty = empty
                        x = i
                        y = j
                    }
                }
            }
        }
        arr[x][y] = it
    }
    for (i in 0 until n){

    }
}

fun check(i: Int, j: Int, number: Int): Pair<Int, Int> {
    var empty = 0
    var likeCount = 0
    for (k in 0..3) {
        val nx = i + dx[k]
        val ny = j + dy[k]
        if (nx < 0 || ny < 0 || nx >= n || ny >= n) continue
        if (arr[nx][ny] == 0) empty++
        else if (like[number][arr[nx][ny]]) likeCount++
    }
    return Pair(likeCount, empty)
}

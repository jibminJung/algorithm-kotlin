package SK3

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val sol = Solution().solution(2, 2, arrayOf(intArrayOf(1, 1), intArrayOf(2, 2)))
}

var w = 0
var h = 0
val p = 10000019
lateinit var diagArr: Array<BooleanArray>
lateinit var arr: Array<Array<LongArray>>

class Solution {
    fun solution(width: Int, height: Int, diagonals: Array<IntArray>): Int {
        var answer: Int = 0
        w = width
        h = height
        arr = Array(width + 1) { Array(height + 1) { LongArray(2) } }
        diagArr = Array(width + 1) { BooleanArray(height + 1) }
        for (i in diagonals.indices) {
            val (x, y) = diagonals[i]
            diagArr[x][y] = true
        }
        arr[0][0][0] = 1
        return dfs(width, height, 1).toInt()
    }

    fun dfs(x: Int, y: Int, diag: Int): Long {
        if (x == w && y == h) {
            arr[x][y][0] = arr[x][y][0] % p + dfs(x - 1, y, 0) % p
            arr[x][y][1] = arr[x][y][1] % p + dfs(x - 1, y, 1) % p
            arr[x][y][0] = arr[x][y][0] % p + dfs(x, y - 1, 0) % p
            arr[x][y][1] = arr[x][y][1] % p + dfs(x, y - 1, 1) % p
            return arr[x][y][1] % p
        }
        if (arr[x][y][diag] != 0L) return arr[x][y][diag] % p
        if (diag == 1) {
            //왼쪽,밑
            if (x - 1 in 0..w) arr[x][y][1] = arr[x][y][1] % p + dfs(x - 1, y, 1) % p
            if (y - 1 in 0..h) arr[x][y][1] = arr[x][y][1] % p + dfs(x, y - 1, 1) % p
            // 대각선 좌,우
            if (y + 1 <= h && diagArr[x][y + 1]) {
                if (x - 1 in 0..w) arr[x][y][1] = arr[x][y][1] % p + dfs(x - 1, y+1, 0) % p
            }
            if (x + 1 <= w && diagArr[x + 1][y]) {
                if (y - 1 in 0..h) arr[x][y][1] = arr[x][y][1] % p + dfs(x+1, y - 1, 0) % p
            }
            return arr[x][y][1] % p
        } else {
            //왼쪽,밑
            if (x - 1 in 0..w) {
                arr[x][y][0] = arr[x][y][0] % p + dfs(x - 1, y, 0) % p
            }
            if (y - 1 in 0..h) {
                arr[x][y][0] = arr[x][y][0] % p + dfs(x, y - 1, 0) % p
            }
            return arr[x][y][0] % p
        }
    }
}

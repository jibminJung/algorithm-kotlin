package SK1

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.min

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

}

class Solution {
    fun solution(money: Int, costs: IntArray): Int {
        val coin = arrayOf(0, 1, 5, 10, 50, 100, 500)
        val arr = Array(7) { IntArray(money + 1) }
        for (i in 1..money){
            arr[1][i] = costs[0]*i
        }
        for (i in 2..6) {
            for (j in 1..money) {
                if (j - coin[i] > 0) {
                    arr[i][j] = min(min(arr[i - 1][j - coin[i]] + costs[i-1], arr[i - 1][j]),arr[i][j-coin[i]]+costs[i-1])
                }
                if (j - coin[i] == 0){
                    arr[i][j] = min(arr[i-1][j],costs[i-1])
                }
            }
        }
        return arr[6][money]
    }
}
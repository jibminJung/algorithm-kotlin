package P1079

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.max


var n = 0
lateinit var rate: IntArray
lateinit var delta: Array<IntArray>
var full = 0
var me = 0
var answer = 0
var mafia = 0
fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    n = readLine().toInt()
    rate = readLine().split(" ").map { it.toInt() }.toIntArray()
    delta = Array(n) { IntArray(n) }
    for (i in 0 until n) {
        full += (1 shl i)
        delta[i] = readLine().split(" ").map { it.toInt() }.toIntArray()
    }
    me = readLine().toInt()
    mafia = 1 shl me
    dfs(0, 0)

    println(answer)
}

fun dfs(status: Int, turn: Int) {
    if ((n - turn) % 2 == 1) {//낮
        val top = findTop(rate, status)
        val newStatus = status or (1 shl top)
        if (newStatus and mafia == full) {//시민 모두 사망
            answer = max(answer, if (n % 2 == 1) turn / 2 else (turn + 1) / 2)
            return
        } else if (newStatus and mafia != 0) {//마피아 사망
            answer = max(answer, if (n % 2 == 1) turn / 2 else (turn + 1) / 2)
            return
        } else {//진행
            dfs(newStatus, turn + 1)
        }
    } else {//밤
        for (i in 0 until n) {//target
            if (i == me) continue
            val bit = 1 shl i
            if (bit and status == 0) { //살아있다 = 제거 가능
                if (bit or status or mafia == full) {//시민 모두 사망
                    answer = max(answer, turn / 2 + 1)
                    return
                } else {
                    for (x in rate.indices) {
                        rate[x] += delta[i][x]
                    }
                    dfs(status or bit, turn + 1)
                    for (x in rate.indices) {
                        rate[x] -= delta[i][x]
                    }
                }
            }
        }
    }
}

fun findTop(arr: IntArray, status: Int): Int {
    var maxIndex = -1
    var maxValue = Int.MIN_VALUE
    for (i in arr.indices) {
        if (status and (1 shl i) == 0) {
            if (arr[i] > maxValue) {
                maxValue = arr[i]
                maxIndex = i
            }
        }
    }
    return maxIndex
}
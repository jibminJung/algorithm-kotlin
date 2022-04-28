package P9466

import java.io.BufferedReader
import java.io.InputStreamReader

val sb = StringBuilder()
var count = 0
fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    repeat(readLine().toInt()) {
        val n = readLine().toInt()
        val arr = (mutableListOf(0) + readLine().split(" ").map { it.toInt() }).toIntArray()
        val visit = BooleanArray(n + 1)
        val chk = BooleanArray(n + 1)
        count = 0
        for (i in chk.indices) {
            if (!chk[i]) {
                dfs(arr[i], arr, visit, chk)
            }
        }
        sb.append(n-count+1).append("\n")
    }
    println(sb)
}

fun dfs(now: Int, arr: IntArray, visit: BooleanArray, chk: BooleanArray): Pair<Int, Boolean> {
    if (visit[now]) {
        return Pair(now, true)
    }
    visit[now] = true

    val temp = if(!chk[arr[now]]) dfs(arr[now], arr, visit, chk) else Pair(-1,false)
    if (temp.second) count++
    chk[now] = true
    visit[now] = false
    return Pair(temp.first, if (temp.first == now) !temp.second else temp.second)

}
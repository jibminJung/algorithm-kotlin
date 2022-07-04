package P11725

import java.io.BufferedReader
import java.io.InputStreamReader

lateinit var parentArr: IntArray
lateinit var arr: Array<MutableList<Int>>
fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n = readLine().toInt()
    arr = Array(n + 1) { mutableListOf<Int>() }
    parentArr = IntArray(n + 1)
    repeat(n - 1) {
        val (from, to) = readLine().split(" ").map { it.toInt() }
        arr[from].add(to)
        arr[to].add(from)
    }
    dfs(1, 1)
    for (i in 2..n) {
        println(parentArr[i])
    }
}

fun dfs(parent: Int, node: Int) {
    parentArr[node] = parent
    for (next in arr[node]) {
        if (parentArr[next] == 0) {
            dfs(node, next)
        }
    }
}
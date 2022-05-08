package P1620

import java.io.BufferedReader
import java.io.InputStreamReader

val sb = StringBuilder()
fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    val arr = Array<String>(n) { readLine() }
    val hm = HashMap<String, Int>()
    arr.forEachIndexed { index, s -> hm[s] = index + 1 }
    repeat(m) {
        val query = readLine()
        val num = query.toIntOrNull()
        if (num != null) {
            sb.append(arr[num-1]).append("\n")
        }else{
            sb.append(hm[query]).append("\n")
        }
    }
    println(sb)
}
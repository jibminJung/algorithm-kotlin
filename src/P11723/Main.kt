package P11723

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

val sb = StringBuilder()
fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    var full = 0L
    for (i in 1..20) {
        full = full or (1L shl i)
    }
    var set = 0L
    repeat(readLine().toInt()) {
        val st = StringTokenizer(readLine())
        when (st.nextToken()) {
            "add" -> set = set or (1L shl st.nextToken().toInt())
            "remove" -> set = set and (1L shl st.nextToken().toInt()).inv()
            "check" -> sb.append(if((set and (1L shl st.nextToken().toInt()))>1L) 1 else 0).append("\n")
            "toggle" -> set = set xor (1L shl st.nextToken().toInt())
            "all" -> set = set or full
            "empty" -> set = 0L
        }
    }
    println(sb)
}
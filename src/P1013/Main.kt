package P1013

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val sb = StringBuilder()
    val reg = Regex("(100+1+|01)+")
    repeat(readLine().toInt()){
        sb.append(if(readLine().matches(reg))"YES" else "NO").append("\n")
    }
    println(sb)
}
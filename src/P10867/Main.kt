package P10867

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n = readLine()
    println(readLine().split(" ").map { it.toInt() }.toSet().toIntArray().sorted().joinToString(" "))
}
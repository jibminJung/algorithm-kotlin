package P2475

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    var answer = 0
    readLine().split(" ").map { it.toInt() }.forEach {
        answer += (it*it)
        answer %= 10
    }
    println(answer)
}
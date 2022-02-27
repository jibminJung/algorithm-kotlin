package P15829

import java.io.BufferedReader
import java.io.InputStreamReader

val m = 1234567891
val r = 31L
var expo = 1L
fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val l = readLine().toInt()
    var answer = 0L
    readLine().toCharArray().map { it - 'a' + 1 }.forEach { item ->
        answer = (answer + (item * expo)) % m
        expo = (expo * r) % m
    }
    println(answer)
}
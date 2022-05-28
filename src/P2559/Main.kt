package P2559

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.max

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (n, k) = readLine().split(" ").map { it.toInt() }
    val arr = readLine().split(" ").map { it.toInt() }
    var i = 0
    var j = 0
    var answer = Int.MIN_VALUE
    var sum = 0
    while (i<n&&j<n) {
        val range = j - i
        if (range == k) {
            answer = max(sum,answer)
            sum -= arr[i++]
            sum += arr[j++]
        } else if (range > k) {
            sum -= arr[i++]
        } else {
            sum += arr[j++]
        }
    }
    if(j-i==k) answer = max(sum,answer)
    println(answer)
}
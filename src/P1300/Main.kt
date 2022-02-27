package P1300

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.min

var n = 0L
var k = 0L
fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    n = readLine().toLong()
    k = readLine().toLong()
    var lo: Long = 1
    var hi = k

    while (lo < hi) {
        val mid = (lo + hi) / 2
        var count: Long = 0
        for (i in 1..n) {
            count += min(mid / i, n)
        }
        if (k <= count) {
            hi = mid
        } else {
            lo = mid + 1
        }
    }
    println(lo)
}
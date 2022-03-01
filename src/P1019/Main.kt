package P1019

import java.io.BufferedReader
import java.io.InputStreamReader

val arr = IntArray(10)
var k = 1
fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    var n = readLine().toInt()
    while (n != 0) {
        if (n % 10 != 0) {
            calc(n--, k)
        } else {
            val mok = n / 10
            n /= 10
            calc(n, k)
            n--
            update(mok * k)
            k *= 10
        }
    }
    println(arr.joinToString(" "))
}

fun calc(n: Int, k: Int) {
    var i = n
    while (i != 0) {
        arr[i % 10] += k
        i /= 10
    }
}

fun update(n: Int) {
    for (i in 0..9) {
        arr[i] += n
    }
}
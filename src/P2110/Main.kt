package P2110

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

lateinit var arr: IntArray
fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val st = StringTokenizer(readLine())
    val n = st.nextToken().toInt()
    val c = st.nextToken().toInt()
    arr = IntArray(n)
    for (i in 0 until n) {
        arr[i] = readLine().toInt()
    }
    arr.sort()
    var l = 0
    var r = arr.last()
    while (l < r) {
        val mid = (l + r+1) / 2;
        if (pos(mid, c)) {
            l = mid
        } else {
            r = mid-1
        }
    }
    println(l)
}

fun pos(dist: Int, c: Int): Boolean {
    var count = 1;
    var prev = arr[0];
    for (i in 1 until arr.size) {
        if (prev + dist > arr[i]) {
            continue
        } else {
            prev = arr[i];
            count++
        }
    }
    return count >= c
}
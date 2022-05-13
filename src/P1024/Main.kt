package P1024

import java.io.BufferedReader
import java.io.InputStreamReader

val sb = StringBuilder()
fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    var (n, l) = readLine().split(" ").map { it.toDouble() }
    var q = 0.0

    while (true) {
        q = n / l
        if (l > 100) {
            sb.append("-1")
            break
        } else if (q - (l / 2 - 0.5) < 0) {
            sb.append("-1")
            break
        }
        if (l % 2 == 1.0) {
            if (q % 1 == 0.0) {
                print(q, l)
                break
            }
        } else if (l % 2 == 0.0) {
            if (q % 1 == 0.5) {
                print(q, l)
                break
            }
        }
        l++
    }
    println(sb)

}

fun print(q: Double, l: Double) {
    var i = q - (l / 2 - 0.5)
    while (i < q + (l / 2 + 0.5)) {
        sb.append(i.toInt()).append(" ")
        i++
    }
}

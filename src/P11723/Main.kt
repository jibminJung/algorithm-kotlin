package P11723

import java.io.BufferedReader
import java.io.InputStreamReader

val sb = StringBuilder()
fun main()=with(BufferedReader(InputStreamReader(System.`in`))){
    var set = 0L
    repeat(readLine().toInt()) {
        val order = readLine().split(" ")
        val n = order.last().toIntOrNull()?:0
        when (order.first()) {
            "add" -> set = set on n
            "remove" -> set = set off n
            "check" -> sb.append(set chk n).append("\n")
            "toggle" -> set = set toggle n
            "all" -> set = set or 0L.inv()
            "empty" -> set = 0L
        }
    }
    println(sb)
}

infix fun Int.on(i:Int) = this or (1 shl i-1)
infix fun Long.on(i:Int) = this or (1L shl i-1)

infix fun Int.off(i:Int) = this and (1 shl i-1).inv()
infix fun Long.off(i:Int) = this and (1L shl i-1).inv()

infix fun Int.chk(i:Int) = if(this and (1 shl i-1)>=1) 1 else 0
infix fun Long.chk(i:Int) = if(this and (1L shl i-1)>=1L) 1 else 0

infix fun Int.toggle(i:Int) = this xor (1 shl i-1)
infix fun Long.toggle(i:Int) = this xor (1L shl i-1)

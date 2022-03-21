package P11557

import java.io.BufferedReader
import java.io.InputStreamReader

val sb = StringBuilder()
fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    repeat(readLine().toInt()){
        var max = 0
        var str = ""
        repeat(readLine().toInt()){
            val (school, n) = readLine().split(" ")
            if(n.toInt()>max){
                max = n.toInt()
                str = school
            }
        }
        sb.append(str).append("\n")
    }
    println(sb)
}
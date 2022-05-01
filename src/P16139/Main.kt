package P16139

import java.io.BufferedReader
import java.io.InputStreamReader

val sb = StringBuilder()
fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    val str = readLine().toCharArray()
    val arr = Array(26){
        makeCountArray(str,it+97)
    }
    val q = readLine().toInt()
    repeat(q){
        val (target, l,r) = readLine().split(" ")
        val temp = arr[target.first().code-97][r.toInt()] - if(l.toInt()!=0) arr[target.first().code-97][l.toInt()-1] else 0
        sb.append(temp).append("\n")
    }
    println(sb)
}

fun makeCountArray(str:CharArray,code:Int):IntArray{
    val arr = IntArray(str.size)
    var cnt = 0
    for (i in str.indices){
        if(str[i].code == code) cnt++
        arr[i] = cnt
    }
    return arr
}
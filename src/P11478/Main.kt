package P11478

import java.io.BufferedReader
import java.io.InputStreamReader

lateinit var str :String
val hs = HashSet<String>()
fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    str = readLine()
    recur(0,0)
    println(hs.size-1)
}

fun recur(i:Int,j:Int){
    if(i > str.length) return
    if(j > str.length){
        recur(i+1,i+1)
        return
    }
    hs.add(str.substring(i,j))
    recur(i,j+1)
}
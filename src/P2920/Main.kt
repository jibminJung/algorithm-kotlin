package P2920

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val arr = IntArray(1) + readLine().split(" ").map { it.toInt() }.toIntArray()
    var asc = true
    for (i in 1..8) {
        if(i!=arr[i]) asc = false
    }
    var desc = true
    for (i in 1..8) {
        if(9-i!=arr[i]) desc = false
    }
    if(asc){
        println("ascending")
    }else if(desc){
        println("descending")
    }else{
        println("mixed")
    }


}
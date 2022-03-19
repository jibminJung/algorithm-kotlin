package P1268

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n =readLine().toInt()
    val arr = Array(n){IntArray(5)}
    var answer = -1
    var max= -1
    for (i in 0 until n){
        arr[i] = readLine().split(" ").map { it.toInt() }.toIntArray()
    }
    for (i in 0 until n){
        val hs = HashSet<Int>()
        for (g in 0..4){
            for (j in 0 until n){
                if(i==j)continue
                if(arr[i][g]==arr[j][g]) hs.add(j)
            }
        }
        if(hs.size>max) {
            answer = i
            max = hs.size
        }
    }
    println(answer+1)
}
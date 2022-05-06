package P10986

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    val (n,m) = readLine().split(" ").map { it.toInt() }
    val input = readLine().split(" ").map { it.toInt() }
    val arr = LongArray(m)
    var sum = 0
    for (i in input){
        sum = (sum + i)%m
        arr[sum]++
    }
    var answer = arr[0]
    for (count in arr){
        answer += (count * (count -1))/2
    }
    println(answer)
}
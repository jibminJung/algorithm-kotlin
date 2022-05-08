package P1074

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.pow

var answer = 0
fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    val (n,r,c) = readLine().split(" ").map { it.toInt() }
    dnq(0,0,2.0.pow(n).toInt(),r,c)
}

fun dnq(i:Int,j:Int, size:Int,r:Int,c:Int){
    if(size==1){
        println(answer)
        System.exit(0)
        return
    }
    if(r in i until i+ size/2 && c in j until j + size/2){
        dnq(i,j,size/2,r,c)
    }else{
        answer += (size/2)*(size/2)
    }
    if(r in i until i + size/2 && c in j + size/2 until j+size){
        dnq(i,j+size/2,size/2,r,c)
    }else{
        answer += (size/2)*(size/2)
    }
    if(r in i + size/2 until i+size && c in j until j+size/2){
        dnq(i+size/2,j,size/2,r,c)
    }else{
        answer += (size/2)*(size/2)
    }
    if(r in i + size/2 until i+size && c in j + size/2 until j+size){
        dnq(i+size/2,j+size/2,size/2,r,c)
    }else{
        answer += (size/2)*(size/2)
    }
}
package P1039

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.math.pow

var len = 0
var answer = -1
fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    val (n,k) = readLine().split(" ").map { it.toInt() }
    len = n.toString().length
    val visit = Array(1000001) { BooleanArray(k+2) }
    val q = LinkedList<Pair<Int,Int>>()
    q.offer(Pair(n,0))
    while(!q.isEmpty()){
        val (n,depth) = q.poll()
        if(depth==k){
            if(n>answer) answer = n
            continue
        }
        for (i in 1..len){
            for (j in i+1..len){
                if(i==j) continue
                val new = swap(n,i,j)
                if(new==-1 || visit[new][depth+1]) continue
                visit[new][depth+1] = true
                q.offer(Pair(new,depth+1))
            }
        }
    }
    println(answer)
}

fun dfs(number:Int,depth:Int,k:Int){
    if(depth==k){
        if(number>answer) answer = number
        return
    }
    for (i in 1..len){
        for (j in i+1..len){
            if(i==j) continue
            val new = swap(number,i,j)
            if(new==-1) continue
            dfs(new,depth+1,k)
        }
    }

}
fun swap(number:Int,i:Int,j:Int):Int{
    val str = number.toString().reversed()
    if(str.length==j && str[i-1].code==48) return -1
    val minus = str[i-1].toInteger() * 10.0.pow((i - 1)).toInt() + str[j-1].toInteger() * 10.0.pow(j-1).toInt()
    val plus = str[i-1].toInteger() * 10.0.pow((j - 1)).toInt() + str[j-1].toInteger() * 10.0.pow(i-1).toInt()
    return number + plus - minus
}

fun Char.toInteger():Int{
    return Character.getNumericValue(this)
}
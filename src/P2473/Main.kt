package P2473

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.absoluteValue

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n = readLine()
    val arr = readLine().split(" ").map { it.toLong() }.toLongArray()
    arr.sort()
    var minDiff = Long.MAX_VALUE
    var minTriple = Triple(0L,0L,0L)
    for (i in arr.indices){
        val first = arr[i] // 세 용액 중 첫 용액
        var l = i+1 // 세 용액 중 두번째 용액으로 할 용액의 인덱스
        var r = arr.lastIndex // 세 용액 중 세번째 용액으로 할 용액의 인덱스
        while (l<r){ //두번째, 세번째 용액을 투포인터로 찾는다.
            val temp = first+arr[l]+arr[r]
            if(temp.absoluteValue<minDiff){
                minDiff = temp.absoluteValue
                minTriple = Triple(first,arr[l],arr[r])
            }
            if(temp<0){
                l++
            }else{
                r--
            }
        }
    }

    println(minTriple.toList().joinToString(" "))
}
package PG43238

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    
}
class Solution {
    lateinit var times: IntArray
    var n = 0
    fun solution(n: Int, times: IntArray): Long {
        this.times = times
        this.n=n
        var l = 1L
        var r = 1000000000 * 1000000000L
        while(l<r){
            val mid = (l+r)/2
            if(pos(mid)){
                r = mid
            }else{
                l = mid +1
            }
        }

        return l
    }
    fun pos(mid:Long):Boolean{
        var count = 0L
        for (time in times){
            count += mid/time
            if(count>=n) return true
        }
        return false
    }
}
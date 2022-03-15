package PG43165

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){

}

class Solution {
    var n = 0
    var target = 0
    var count = 0
    lateinit var numbers: IntArray
    fun solution(numbers: IntArray, target: Int): Int {
        var answer = 0
        this.n = numbers.size
        this.target = target
        this.numbers = numbers
        dfs(0,0)
        return count
    }
    fun dfs(depth:Int,number:Int){
        if(depth==n){
            if(number==target) count++
            return
        }
        dfs(depth+1,number+numbers[depth])
        dfs(depth+1,number-numbers[depth])
    }
}
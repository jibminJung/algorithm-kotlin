package PG81303


import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    println(Solution().solution(4,1,Array<String>(1){" "}))
}

var s =1
lateinit var tree:IntArray
class Solution {
    fun solution(n: Int, k: Int, cmd: Array<String>): String {
        var answer: String = ""
        getS(n)
        tree = IntArray(2*s +1)

        return answer
    }
    fun getS(n:Int){
        while(s<n){
            s = s.shl(1)
        }
    }
    fun update(index:Int,target:Int){
        var curr = s + index -1
        val diff = target - tree[curr]
        while(curr>0){
            tree[curr] += diff
            curr /= 2
        }
    }
    fun find(node:Int,index:Int){
        if(node>=s) {
            return
        }
        val left = tree[node*2]
        val right = tree[node*2+1]
        if(left>=index){
            find(node*2,index)
        }else{
            find(node*2+1,index-left)
        }

    }
}
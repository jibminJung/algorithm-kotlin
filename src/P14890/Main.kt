package P14890

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (n,l) = readLine().split(" ").map { it.toInt() }
    val arr = Array(n){IntArray(n)}
    var answer = 0
    for (i in 0 until n){
        arr[i] = readLine().split(" ").map { it.toInt() }.toIntArray()
    }
    for (i in 0 until n){
        var cur = arr[i][0]
        var flat = 1
        for (j in 1 until n){
            if(arr[i][j]==cur){
                flat++
                cur = arr[i][j]
            }else{
                if(cur-arr[i][j] == -1){//오르막
                    if(flat>=l){
                        cur=arr[i][j]
                    }else{
                        flat = 1
                    }
                }else if(cur-arr[i][j]==1){//내리막
                    var ff = 1
                    val level = arr[i][j]
                    for (x in 1 until l){
                        if(x+j>=n)break
                        if(level==arr[i][j+x]) {
                            ff++
                        }else{
                            break
                        }
                    }
                    if(ff==l) {
                        cur=arr[i][j]
                    }
                }else{//높이 둘 이상
                    break
                }
            }
        }

    }
}
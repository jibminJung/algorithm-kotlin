package P12100

import java.io.BufferedReader
import java.io.InputStreamReader

var n =0
var answer = 0
fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    n = readLine().toInt()
    val arr = Array(n){IntArray(n)}
    repeat(n){ i ->
        arr[i] = readLine().split(" ").map { it.toInt() }.toIntArray()
    }
    dfs(arr,0)
    println(answer)
}
fun dfs(arr:Array<IntArray>,depth:Int){
    if(depth==5) {
        check(arr)
        return
    }
    dfs(up(arr),depth+1)
    dfs(down(arr),depth+1)
    dfs(left(arr),depth+1)
    dfs(right(arr),depth+1)

}
fun check(arr:Array<IntArray>){
    for (i in arr.indices){
        for (j in arr[i].indices){
            if(answer<arr[i][j]) answer = arr[i][j]
        }
    }
}
fun left(arr:Array<IntArray>):Array<IntArray>{
    val nArr = Array(n){IntArray(n)}
    for (i in arr.indices){
        var cur = 0
        var save = 0
        for (j in arr[i].indices){
            if(arr[i][j]!=0){
                if(save == 0){
                    save = arr[i][j]
                }else{
                    if(save==arr[i][j]){
                        nArr[i][cur++] = save + arr[i][j]
                        save = 0
                    }else{
                        nArr[i][cur++] = save
                        save = arr[i][j]
                    }
                }
            }
        }
        if(save!=0){
            nArr[i][cur] = save
        }
    }
    return nArr
}

fun right(arr:Array<IntArray>):Array<IntArray>{
    val nArr = Array(n){IntArray(n)}
    for (i in arr.indices){
        var cur = n-1
        var save = 0
        for (j in arr[i].indices.reversed()){
            if(arr[i][j]!=0){
                if(save == 0){
                    save = arr[i][j]
                }else{
                    if(save==arr[i][j]){
                        nArr[i][cur--] = save + arr[i][j]
                        save = 0
                    }else{
                        nArr[i][cur--] = save
                        save = arr[i][j]
                    }
                }
            }
        }
        if(save!=0){
            nArr[i][cur] = save
        }
    }
    return nArr
}

fun up(arr:Array<IntArray>):Array<IntArray>{
    val nArr = Array(n){IntArray(n)}
    for (j in 0 until n){
        var cur = 0
        var save = 0
        for (i in 0 until n){
            if(arr[i][j]!=0){
                if(save == 0){
                    save = arr[i][j]
                }else{
                    if(save==arr[i][j]){
                        nArr[cur++][j] = save + arr[i][j]
                        save = 0
                    }else{
                        nArr[cur++][j] = save
                        save = arr[i][j]
                    }
                }
            }
        }
        if(save!=0){
            nArr[cur][j] = save
        }
    }
    return nArr
}

fun down(arr:Array<IntArray>):Array<IntArray>{
    val nArr = Array(n){IntArray(n)}
    for (j in 0 until n){
        var cur = n-1
        var save = 0
        for (i in n-1 downTo  0){
            if(arr[i][j]!=0){
                if(save == 0){
                    save = arr[i][j]
                }else{
                    if(save==arr[i][j]){
                        nArr[cur--][j] = save + arr[i][j]
                        save = 0
                    }else{
                        nArr[cur--][j] = save
                        save = arr[i][j]
                    }
                }
            }
        }
        if(save!=0){
            nArr[cur][j] = save
        }
    }
    return nArr
}

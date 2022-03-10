package P2239

import java.io.BufferedReader
import java.io.InputStreamReader

lateinit var arr: Array<IntArray>
fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    arr = Array(10) { IntArray(10) }
    for (i in 1..9) {
        val input = readLine().toCharArray().map { it.code-48 }
        for (j in 1..9) {
            arr[i][j] = input[j - 1]
        }
    }
    dfs(1,1)

}
fun dfs(i: Int,j: Int){
    if(j>9){
        dfs(i+1,j%9)
        return
    }
    if(i>9){
        //flag
        for (x in 1..9) {
            println(arr[x].joinToString("").drop(1))
        }
        System.exit(0)
        return
    }
    if(arr[i][j]!=0) {
        dfs(i,j+1)
        return
    }
    for (k in 1..9){
        if(checkRow(i,k)&& checkColumn(j,k)&& checkBox(i,j,k)){
            arr[i][j] = k
            dfs(i,j+1)
            arr[i][j]=0
        }
    }
}

fun checkRow(row: Int, n: Int): Boolean {
    for (i in 1..9) {
        if (arr[row][i] == n) return false
    }
    return true
}
fun checkColumn(col: Int, n: Int): Boolean {
    for (i in 1..9) {
        if (arr[i][col] == n) return false
    }
    return true
}
fun checkBox(i:Int,j:Int,n:Int):Boolean{
    var i = ((i-1)/3)*3
    var j = ((j-1)/3)*3
    for (r in i+1..i+3){
        for (c in j+1..j+3){
            if(arr[r][c]==n) return false
        }
    }
    return true
}
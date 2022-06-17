package P14499

import java.io.BufferedReader
import java.io.InputStreamReader

val dice = Array(3) { IntArray(3) }
var diceTop = 0
val dx = arrayOf(0,0,0,-1,1)
val dy = arrayOf(0,1,-1,0,0)
val sb = StringBuilder()
fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    fun input() = readLine().split(" ").map { it.toInt() }
    var (n, m, x, y, k) = input()
    val arr = Array(n) { input().toIntArray() }
    for(order in input()){
        val nx = x + dx[order]
        val ny = y + dy[order]
        if(nx !in 0 until n || ny !in 0 until m) continue
        roll(order)
        if(arr[nx][ny]==0){
            arr[nx][ny] = bot()
        }else{
            setBot(arr[nx][ny])
            arr[nx][ny] = 0
        }
        x = nx
        y = ny
        sb.append(diceTop).append("\n")
    }
    println(sb)
}

fun bot() = dice[1][1]
fun setBot(i:Int){dice[1][1] = i}
fun roll(direction: Int) {
    when (direction) {
        1 -> {
            val temp = diceTop
            diceTop = dice[1][0]
            dice[1][0] = dice[1][1]
            dice[1][1] = dice[1][2]
            dice[1][2] = temp
        }
        2 -> {
            val temp = diceTop
            diceTop = dice[1][2]
            dice[1][2] = dice[1][1]
            dice[1][1] = dice[1][0]
            dice[1][0] = temp
        }
        3 -> {
            val temp = diceTop
            diceTop = dice[2][1]
            dice[2][1] = dice[1][1]
            dice[1][1] = dice[0][1]
            dice[0][1] = temp
        }
        4 -> {
            val temp = diceTop
            diceTop = dice[0][1]
            dice[0][1] = dice[1][1]
            dice[1][1] = dice[2][1]
            dice[2][1] = temp
        }
    }
}
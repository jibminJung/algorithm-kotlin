package SK2

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

val dx = arrayOf(1, 0, -1, 0)
val dy = arrayOf(0, 1, 0, -1)

//하,우,상,좌
fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

}

/*
bfs를 이용해서 풀어본다
왼쪽으로 갈 수 있으면 진행하고 못하면 직진

 */
class Solution {
    fun solution(n: Int, clockwise: Boolean): Array<IntArray> {
        var answer: Array<IntArray> = Array(n) { IntArray(n) }
        val q = LinkedList<Node>()
        q.offer(Node(0, 0, 1))
        answer[0][0] = 1
        q.offer(Node(n - 1, n - 1, 3))
        answer[n - 1][n - 1] = 1
        q.offer(Node(n - 1, 0, 2))
        answer[n - 1][0] = 1
        q.offer(Node(0, n - 1, 0))
        answer[0][n - 1] = 1
        while (!q.isEmpty()) {
            val (x, y, dir) = q.poll()
            if (x + dx[dir] in 0 until n && y + dy[dir] in 0 until n && answer[x + dx[dir]][y + dy[dir]] == 0) {
                q.offer(Node(x + dx[dir], y + dy[dir], dir))
                answer[x+dx[dir]][y+dy[dir]] = answer[x][y] +1
            } else {//막히면 우측 회전
                val newDir = ((dir + 4) - 1) % 4
                if (x + dx[newDir] in 0 until n && y + dy[newDir] in 0 until n &&answer[x + dx[newDir]][y + dy[newDir]] == 0) {
                    q.offer(Node(x + dx[newDir], y + dy[newDir], newDir))
                    answer[x+dx[newDir]][y+dy[newDir]] = answer[x][y] +1
                }
            }
        }
        if(!clockwise){
            flip(answer)
        }
        return answer
    }
}
fun flipUp(arr:Array<IntArray>){
    for (i in 1..arr.size / 2) {
        val temp = arr[i]
        arr[i] = arr[arr.size - i]
        arr[arr.size - i] = temp
    }
}
fun flip(arr:Array<IntArray>){
    for (i in 0 until arr.size) {
        for (j in 0 until arr.size / 2) {
            val temp: Int = arr[i][j]
            arr[i][j] = arr[i][arr[i].size - j -1]
            arr[i][arr[i].size - j -1] = temp
        }
    }
}

data class Node(val x: Int, val y: Int, val dir: Int)
package P13460

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*


val dx = arrayOf(-1, 0, 1, 0)
val dy = arrayOf(0, 1, 0, -1)
var rx = 0
var ry = 0
var bx = 0
var by = 0
lateinit var arr: Array<CharArray>
var record = Int.MAX_VALUE
fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    arr = Array(n) { CharArray(m) }
    for (i in 0 until n) {
        val input = readLine().toCharArray()
        for (j in 0 until m) {
            arr[i][j] = input[j]
            if (arr[i][j] == 'R') {
                rx = i
                ry = j
            }
            if (arr[i][j] == 'B') {
                bx = i
                by = j
            }
        }
    }
    val q= LinkedList<Node>()
    q.offer(Node(arr,0))
    while(!q.isEmpty()){
        val node = q.poll()
        val arr = node.arr
        val depth = node.depth
        if(depth>10) continue
        for (k in 0..3){

        }
    }
    backtracking(1, n, m)
    println(record)
}
class Node(
    val arr:Array<CharArray>,
    val depth: Int
)

fun backtracking(depth: Int, n: Int, m: Int) {
    if (depth > 10) return

    val restore = Array(n){CharArray(m)}
    for (i in 0 until n){
        restore[i] = arr[i].copyOf()
    }
    //상,우,하,좌로 기울여보기
    for (k in 0..3) {
        val mrx = rx
        val mry = ry
        val mbx = bx
        val mby = by
        tilt(k, n, m,arr)
        println("k,depth = $k,$depth")
        printArr(arr)
        if (rx != 0 && bx != 0) {
            backtracking(depth + 1, n, m)
        } else if (rx == 0 && bx != 0) {
            //success
            println("success")
            record = Math.min(record, depth)
        }
        for (i in 0 until n){
            arr[i] = restore[i].copyOf()
        }
        rx=mrx
        ry=mry
        bx=mbx
        by=mby
    }
}

fun tilt(dir: Int, n: Int, m: Int,arr: Array<CharArray>) {//기울이기 함수, 공이 빠졌는지에 대한 정보 리턴
    if (dir == 0) {
        if (ry == by) {
            var j = ry
            for (i in 0 until n) {
                move(i, j, dir,arr)
            }
        } else {
            var j = ry
            for (i in 0 until n) {
                move(i, j, dir,arr)
            }
            j = by
            for (i in 0 until n) {
                move(i, j, dir,arr)
            }
        }
    } else if (dir == 1) {
        if (rx == bx) {
            var i = rx
            for (j in m-1 downTo 0) {
                move(i, j, dir,arr)
            }
        } else {
            var i = rx
            for (j in m-1 downTo 0) {
                move(i, j, dir,arr)
            }
            i = bx
            for (j in m-1 downTo 0) {
                move(i, j, dir,arr)
            }
        }
    } else if (dir == 2) {
        if (ry == by) {
            var j = ry
            for (i in n-1 downTo 0) {
                move(i, j, dir,arr)
            }
        } else {
            var j = ry
            for (i in n-1 downTo 0) {
                move(i, j, dir,arr)
            }
            j = by
            for (i in n-1 downTo 0) {
                move(i, j, dir,arr)
            }
        }
    } else {
        if (rx == bx) {
            var i = rx
            for (j in 0 until m) {
                move(i, j, dir,arr)
            }
        } else {
            var i = rx
            for (j in 0 until m) {
                move(i, j, dir,arr)
            }
            i = bx
            for (j in 0 until m) {
                move(i, j, dir,arr)
            }
        }
    }
}

fun move(i: Int, j: Int, dir: Int,arr:Array<CharArray>) {
    if (arr[i][j] == 'R' || arr[i][j] == 'B') {
        val obj = arr[i][j]
        arr[i][j] = '.'
        var ni = i + dx[dir]
        var nj = j + dy[dir]
        while (arr[ni][nj] == '.') {
            ni += dx[dir]
            nj += dy[dir]
        }
        if (arr[ni][nj] == 'O') {
            if (obj == 'R') {
                rx = 0
                ry = 0
            } else {
                bx = 0
                by = 0
            }
        } else {
            if (obj == 'R') {
                rx = ni- dx[dir]
                ry = nj - dy[dir]
                arr[rx][ry] = 'R'
            } else {
                bx = ni -dx[dir]
                by = nj - dy[dir]
                arr[bx][by] = 'B'
            }
        }
    }
}

fun printArr(arr:Array<CharArray>){
    for (i in 0..arr.size-1){
        println(arr[i].joinToString(""))
    }
}
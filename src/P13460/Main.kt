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
var record = Int.MAX_VALUE
val visit = Array(11){Array(11){Array(11){BooleanArray(11)} } }
fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    val arr = Array(n) { CharArray(m) }
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
    q.offer(Node(copyArr(arr),1,rx, ry, bx, by))
    visit[rx][ry][bx][by] = true
    while(!q.isEmpty()){
        val node = q.poll()
        val (arr,depth,mrx,mry,mbx,mby) = node
//        printArr(copyArr(arr))
        if(depth>10) continue
        for (k in 0..3){
            val nArr = tilt(copyArr(arr),k,n,m)
            if(rx!=0&&bx!=0&&!visit[rx][ry][bx][by]){
                q.offer(Node(nArr,depth+1,rx,ry,bx,by))
                visit[rx][ry][bx][by]=true
            }else if(rx==0&&bx!=0){
                record = Math.min(record,depth)
                break;
            }
            rx = mrx; ry=mry;bx=mbx;by=mby;
        }
    }
    println(if(record==Int.MAX_VALUE)-1 else record)
}
data class Node(
    val arr:Array<CharArray>,
    val depth: Int,
    val rx:Int,
    val ry:Int,
    val bx:Int,
    val by:Int
)

fun tilt(arr: Array<CharArray>,dir:Int,n:Int,m:Int) :Array<CharArray>{//기울이기 함수, 공이 빠졌는지에 대한 정보 리턴
    if (dir == 0||dir==3) {
        for (i in 0 until n){
            for (j in 0 until m){
                move(i,j,dir,arr)
            }
        }
    } else {
        for (i in n-1 downTo 0){
            for (j in m-1 downTo 0){
                move(i,j,dir,arr)
            }
        }
    }
    return arr
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

fun copyArr(arr:Array<CharArray>):Array<CharArray>{
    val newArr = Array(arr.size){CharArray(arr.first().size)}
    for (i in 0 until arr.size){
        newArr[i] = arr[i].copyOf()
    }
    return newArr
}

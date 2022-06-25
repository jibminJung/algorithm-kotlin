package P16928

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    fun i() = readLine().split(" ").map { it.toInt() }
    val (l, s) = i()
    val arr = IntArray(101)
    val chk = IntArray(101)
    repeat(l + s) {
        val (from, to) = i()
        arr[from] = to
    }
    val q = LinkedList<Int>()
    q.offer(1)
    chk[1] = 1
    while (!q.isEmpty()) {
        val now = q.poll()
        if(now==100)break
        for (i in 1..6) {
            val next = now+i
            if(next !in 1..100) continue
            if (chk[next] != 0) continue
            if(arr[next]!=0){ //ladder or snake
                if(chk[arr[next]]==0){
                    chk[arr[next]] = chk[now]+1
                    q.offer(arr[next])
                }
            }else{// nothing
                chk[next] = chk[now]+1
                q.offer(next)
            }
        }
    }
    println(chk[100]-1)
}
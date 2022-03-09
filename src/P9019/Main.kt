package P9019

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

/*
DSLR
d*2 mod 10000
S -> n-1
L -> shl
R -> shr
 */

val sb = StringBuilder()
fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    repeat(readLine().toInt()){
        val (from,to) = readLine().split(" ").map { it.toInt() }
        val route = Array<String?>(10000){null}
        val visit = IntArray(10000)
        val q = LinkedList<Int>()
        q.offer(from)
        visit[from] = 1
        route[from] = ""
        while(!q.isEmpty()){
            val now = q.poll()

            val d = D(now)
            if(visit[d]==0||visit[d]>visit[now]+1){
                visit[d] = visit[now]+1
                route[d] = route[now].plus("D")
                q.offer(d)
            }
            val s = S(now)
            if(visit[s]==0||visit[s]>visit[now]+1){
                visit[s] = visit[now]+1
                route[s] = route[now].plus("S")
                q.offer(s)
            }
            val l = L(now)
            if(visit[l]==0||visit[l]>visit[now]+1){
                visit[l] = visit[now]+1
                route[l] = route[now].plus("L")
                q.offer(l)
            }
            val r = R(now)
            if(visit[r]==0||visit[r]>visit[now]+1){
                visit[r] = visit[now]+1
                route[r] = route[now].plus("R")
                q.offer(r)
            }
        }
        sb.append(route[to]).append('\n')
    }
    println(sb)
}
fun D(n:Int):Int{
    return n*2 % 10000
}
fun S(n:Int):Int{
    return if(n==0) 9999 else n-1
}
fun L(n:Int):Int{
    return (n*10 + n/1000)%10000
}
fun R(n:Int):Int{
    return n/10+((n%10) *1000)
}
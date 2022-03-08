package P7662

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

val sb = StringBuilder()
fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    repeat(readLine().toInt()){
        val order = readLine().toInt()
        val tm = TreeMap<Int,Int>()
        for (i in 1..order){
            val cmd = readLine()
            if(cmd.startsWith("I")){
                val input = cmd.drop(2).toInt()
                tm.put(input,tm.getOrDefault(input,0)+1)
            }else if(cmd.endsWith("-1")){
                if(tm.isEmpty()) continue
                val fe = tm.firstEntry()
                if(fe.value==1){
                    tm.remove(fe.key)
                }else{
                    tm.put(fe.key,fe.value-1)
                }
            }else{
                if(tm.isEmpty()) continue
                val le = tm.lastEntry()
                if(le.value==1){
                    tm.remove(le.key)
                }else{
                    tm.put(le.key,le.value-1)
                }
            }
        }//end for
        if(tm.isEmpty()){
            sb.append("EMPTY").append('\n')
        }else{
            sb.append(tm.lastKey()).append(" ").append(tm.firstKey()).append('\n')
        }
    }
    println(sb)
}
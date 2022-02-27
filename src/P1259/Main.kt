package P1259

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    while(true){
        val n = readLine()
        if(n[0]=='0') break
        var flag = true
        for(i in 0 until n.length/2){
            if(n[i]!=n[n.length-1-i]){
                flag = false
                break
            }
        }
        bw.append(if(flag) "yes" else "no").append('\n')
    }
    bw.flush()
    bw.close()
}
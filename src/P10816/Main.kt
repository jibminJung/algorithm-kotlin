package P10816

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.absoluteValue

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    val sb = StringBuilder()
    val n = readLine().toInt()
    val cards = IntArray(10000001)
    val mCards = IntArray(10000001)
    readLine().split(" ").map { it.toInt() }.forEach{ card ->
        if(card>=0){
            cards[card]++;
        }else{
            mCards[card.absoluteValue]++;
        }
    }
    val m = readLine().toInt()
    readLine().split(" ").map { it.toInt() }.forEach {
        sb.append(if(it>=0) cards[it] else mCards[it.absoluteValue]).append(' ')
    }
    println(sb)
}
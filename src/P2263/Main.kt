package P2263

import java.io.BufferedReader
import java.io.InputStreamReader

val sb = StringBuilder()
lateinit var inOrder:IntArray
lateinit var postOrder:IntArray
lateinit var indice:IntArray
fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    val n = readLine().toInt()
    inOrder =readLine().split(" ").map { it.toInt() }.toIntArray()
    postOrder =readLine().split(" ").map { it.toInt() }.toIntArray()
    indice = IntArray(inOrder.size)
    inOrder.forEachIndexed{i,data -> indice[data-1] = i}
    getPreOrder(0,n-1,0,n-1)
    println(sb)
}

fun getPreOrder(inStart:Int,inEnd:Int,postStart:Int,postEnd:Int){
    if(inStart>inEnd || postStart>postEnd) return

    val rootIndex = indice[postOrder[postEnd]-1]
    val leftSize = rootIndex - inStart
    sb.append(inOrder[rootIndex]).append(" ")

    getPreOrder(inStart, rootIndex - 1, postStart, postStart + leftSize - 1)
    getPreOrder(rootIndex + 1, inEnd, postStart + leftSize, postEnd - 1)
}
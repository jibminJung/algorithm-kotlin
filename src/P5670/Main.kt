package P5670

import java.io.BufferedReader
import java.io.InputStreamReader

var totalCount = 0
val sb = StringBuilder()
fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    while (true) {
        val n = readLine()
        if (n==null||n.isEmpty()||n.equals("")) break
        val root = Node()
        for (i in 1..n.toInt()) {
            root.input(readLine())
        }
        totalCount = 0
        for (node in root.child) {
            if (node != null) {
                dfs(node, 1)
            }
        }
        sb.append(String.format("%.02f", (totalCount.toDouble() / n.toDouble()))).append('\n')
    }
    println(sb)
}

fun dfs(node: Node, count: Int) {
    if (node.isTerminal) {
        totalCount += count
    }
    for (child in node.child) {
        child?.let {
            dfs(child, count + if (node.numberOfChild > 1 || node.isTerminal) 1 else 0)
        }
    }
}

class Node {
    var isTerminal: Boolean = false
    var numberOfChild = 0
    val child = Array<Node?>(26) { null }

    fun input(str: String) {
        if (str.isEmpty()) {
            isTerminal = true
            return
        }
        val initial = str.first()
        child[initial.code - 97]?.let {
            it.input(str.drop(1))
        } ?: kotlin.run {
            child[initial.code - 97] = Node()
            numberOfChild++
            child[initial.code - 97]!!.input(str.drop(1))
        }
    }
}

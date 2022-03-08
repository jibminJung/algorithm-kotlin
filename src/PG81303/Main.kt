package PG81303


import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    println(Solution().solution(8, 2, arrayOf("D 2","C","U 3","C","D 4","C","U 2","Z","Z")))
}

var s = 1
lateinit var tree: IntArray

class Solution {
    fun solution(n: Int, k: Int, cmd: Array<String>): String {
        var cursor = k + 1
        getS(n)
        tree = IntArray(2 * s)
        init(n)
        val stack = Stack<Int>()
        for (input in cmd) {
            val command = input.split(" ")
            when (command[0]) {
                "U" -> {
                    cursor -= command[1].toInt()
                }
                "D" -> {
                    cursor += command[1].toInt()
                }
                "C" -> {
                    val loc = find(1, cursor)
                    update(loc, 0)
                    stack.push(loc)
                    cursor = Math.min(tree[1], cursor)
                }
                "Z" -> {
                    val loc = find(1, cursor)
                    val addLoc = stack.pop()
                    update(addLoc, 1)
                    if (addLoc < loc) cursor++
                }
            }
        }
        val sb = StringBuilder()
        for (i in 1..n) {
            sb.append(if (tree[s + i - 1] == 1) "O" else "X")
        }
        return sb.toString()
    }

    fun getS(n: Int) {
        while (s < n) {
            s = s.shl(1)
        }
    }

    fun init(n: Int) {
        for (i in 1..n) {
            update(i, 1)
        }
    }

    fun update(index: Int, target: Int) {
        var curr = s + index - 1
        val diff = target - tree[curr]
        while (curr > 0) {
            tree[curr] += diff
            curr /= 2
        }
    }

    fun find(node: Int, index: Int): Int {
        if (node >= s) {
            return node - s + 1
        }
        val left = tree[node * 2]
        if (left >= index) {
            return find(node * 2, index)
        } else {
            return find(node * 2 + 1, index - left)
        }
    }
}
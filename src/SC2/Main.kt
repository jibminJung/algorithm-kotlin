package SC2

import kotlin.math.max

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    val height = intArrayOf(140,21,21,32)
    val width = intArrayOf(2,1,3,7)
    solution(height, width)
}


fun solution(height: IntArray, width: IntArray){
    val books = mutableListOf<Pair<Int,Int>>()
    var totalWidth = 0L
    var answer = 0L
    for (i in height.indices){
        books.add(Pair(height[i],width[i]))
        totalWidth += width[i]
    }
    val sortedBooks = books.sortedBy { it.first }
    for (book in sortedBooks){
        println("book.first = ${book.first}")
        println("totalWidth = ${totalWidth}")
        val area = book.first * totalWidth
        answer = max(answer,area)

        totalWidth -= book.second
    }
    println(answer)
}

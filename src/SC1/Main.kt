package SC1

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.max

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val sol = Solution()
}
class Solution{
    var s = 1 shl 20
    lateinit var tree:IntArray
    fun solution(rectangles: Array<IntArray>): Array<String> {
        var answer = arrayOf<String>()
        tree = IntArray(2*s){Int.MIN_VALUE}
        var rects = rectangles.mapIndexed {index, rect -> Rect(index,rect[0],rect[1],rect[2],rect[3]) }
        rects = rects.sortedBy {it.y1}
        for (rect in rects){
            val maxHeight = query(1,1,s,rect.x1+1,rect.x2)
            val height = rect.y2-rect.y1
            if(maxHeight==Int.MIN_VALUE){
                updateRange(rect.x1,rect.x2,height)
                rect.y2 -= rect.y1
                rect.y1 = 0
            }else{
                updateRange(rect.x1,rect.x2,maxHeight+height)
                rect.y2 = maxHeight + height
                rect.y1 = maxHeight
            }
        }
        tree = IntArray(2*s){Int.MIN_VALUE}
        rects = rects.sortedBy {it.x1}
        for (rect in rects){
            val maxHeight = query(1,1,s,rect.y1+1,rect.y2)
            val height = rect.x2-rect.x1
            if(maxHeight==Int.MIN_VALUE){
                updateRange(rect.y1,rect.y2,height)
                rect.x2 -= rect.x1
                rect.x1 = 0
            }else{
                updateRange(rect.y1,rect.y2,maxHeight+height)
                rect.x2 = maxHeight + height
                rect.x1 = maxHeight
            }
        }
        answer = rects.sortedBy { it.index }.map { "${it.x1} ${it.y1} ${it.x2} ${it.y2}" }.toTypedArray()
        return answer
    }
    fun updateRange(x1:Int,x2:Int,target:Int){
        for (x in x1+1 until x2+1){
            update(x,target)
        }
    }
    fun update(index:Int,target:Int){
        var curr = s + index -1
        tree[curr] = target
        curr /= 2
        while(curr>0){
            val maxi = max(tree[curr*2],tree[curr*2 +1])
            if(tree[curr] == maxi) break
            tree[curr] = maxi
            curr /= 2
        }
    }
    fun query(node:Int,start:Int,end:Int,left:Int,right:Int):Int{
        if(right<start||left>end){
            return Int.MIN_VALUE
        }
        if(left<=start&&end<=right){
            return tree[node]
        }
        val mid = (start + end) / 2
        val leftSide = query(node * 2, start, mid, left, right)
        val rightSide = query(node * 2 + 1, mid + 1, end, left, right)
        return max(leftSide,rightSide)
    }
}
data class Rect(val index:Int,var x1:Int,var y1:Int,var x2:Int,var y2:Int)
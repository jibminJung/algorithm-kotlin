package P11444

import java.io.BufferedReader
import java.io.InputStreamReader


val MOD = 1000000007

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    var n = readLine().toLong();

    var I: Array<LongArray> = arrayOf(longArrayOf(1, 0), longArrayOf(0, 1))
    var matrix: Array<LongArray> = arrayOf(longArrayOf(1, 1), longArrayOf(1, 0))
    if(n==1L||n==0L){
        println(n)
        System.exit(0)
    }
    n--;
    while(n>0){
        if((n % 2) == 1L){
            I = matMul(I,matrix)
        }
        matrix = matMul(matrix,matrix)
        n/=2
    }
    println(I[0][0])
}

fun matMul(m1: Array<LongArray>, m2: Array<LongArray>): Array<LongArray> {
    val n: Int
    val m: Int
    val k: Int
    n = m1.size
    m = m2.size
    k = m2[0].size
    val result = Array(n) { LongArray(k) }
    for (i in 0 until n) {
        for (j in 0 until k) {
            for (l in 0 until m) {
                result[i][j] += m1[i][l] * m2[l][j]
                result[i][j] = result[i][j] % MOD
            }
        }
    }
    return result
}

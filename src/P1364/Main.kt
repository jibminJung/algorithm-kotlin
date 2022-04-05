package P1364

/*
울타리 치기
N개의 울타리로 육각형 블록 맵에서 얻을 수 있는 최대 넓이
 */
/*
1 -> 1      1
2 -> 2      1
3 -> 3      1
4 -> 4      1
5 -> 5      1
6 -> 7          2
7 -> 8      1
8 -> 10         2
9-> 12          2
10 -> 14        2
11 -> 16        2
12-> 19             3
13 -> 21        2
14 -> 24            3
15 -> 27            3
16 -> 30            3
17 -> 33            3
18 -> 37                4
19 -> 40            3
20 -> 44                4
21 -> 48                4
22 -> 52                4
23 -> 56                4
24 -> 61                    5
25 -> 65                4
26 -> 70                    5
27 -> 75                    5
28 -> 80                    5
29 -> 85                    5
30 -> 91                        6
 */
import java.io.*

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n = readLine().toInt()
    var answer = 1L
    var x = 1L
    for(i in 2..n){
        if(i%6==0) x++
        if(i%6==1) answer--
        answer += x
    }
    println(answer)
}
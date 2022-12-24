package Daily;

import java.util.Scanner;

public class d_221225 {
    /*
        재귀는 자기 자신을 호출하는 것을 말한다!
        (자주 씀!)
        
        예시로는 팩토리얼을 많이 쓴다.
        n이 0보다 크면 자기 자신을 다시 호출하는 형태 (값은 하나씩 줄어든다.)

        직접 재귀도 있고 간접 재귀도 있는데,
        간접 재귀는 a에서 b를 호출하고 b에서 a를 다시 호출하고 a가 다시 b를 호출하고 <- 같은 형태이다

        최대공약수도 재귀적으로 구할 수 있는데, EuclidGCD <- 클래스와 같이 짜면 됨...

        재귀를 분석해서 루프문으로도 바꿀 수 있고, 시간복잡도에 따라 결정해서 짜면 됨.
        메모화라는 기법도 있는데, 이는 값을 배열 등에 계산해 놨다가 사용하는 걸 말하나 봄.
        이걸 하면 매번 중복 계산을 안 해도 되서 좋음.

        8x8 에서는 정답은 92가지라고 하는데, 모든 조합을 나열해서 짜야 함.
        일단 QueenB에서는 퀸을 배치를 하고 (조합을 구한 상태는 아님)
        QueenBB에서 재귀ㅣㅣㅣ적으로 배치하는걸 나열하나 봄.

        결론적으로는 문제 해결하려면 현재 퀸의 값 / 대각선 값 1 / 반대편 대각선 값 1 / 각 열 현재 위치 값
        같은걸 사용해서 EightQueen과 같이 풀면 됨...
        (이거 라떼에도 재귀 문제로 나왔었는데 추억이군요)

        나무위키에 파이썬 예제로도 있는데

        def n_queens (i, col):
            n = len(col) -1
            if (promising(i, col)):
                if (i == n):
                    print(col[1: n+1])
                else:
                    for j in range(1, n+1):
                        col[i+1] = j
                        n_queens(i+1, col)

        def promising (i, col):
            k = 1
            flag = True
            while (k < i and flag):
                if (col[i] == col[k] or abs(col[i] - col[k]) == (i - k)):
                    flag = False
                k += 1
            return flag
        
        요런 식으로 짠다.


    
    */    
}


class EuclidGCD {
    //--- 정수 x, y의 최대공약수를 구하여 반환 ---//
    static int gcd(int x, int y) {
        if (y == 0)
            return x;
        else
            return gcd(y, x % y);
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.println("두 정수의 최대공약수를 구합니다.");

        System.out.print("정수를 입력하세요 : ");  int x = stdIn.nextInt();
        System.out.print("정수를 입력하세요 : ");  int y = stdIn.nextInt();

        System.out.println("최대공약수는 " + gcd(x, y) + "입니다.");
    }
}

// 8퀸 문제 풀이

class EightQueen {
    static boolean[] flag_a = new boolean[8];     // 각 행에 퀸이 이미 배치되었는가?
    static boolean[] flag_b = new boolean[15];    // 대각선 ↙에 퀸이 이미 배치되었는가?
    static boolean[] flag_c = new boolean[15];    // 대각선 ↘에 퀸이 이미 배치되었는가?
    static int[] pos = new int[8];    // 각 열의 퀸의 위치

    //--- 각 열의 퀸의 위치를 출력 ---//
    static void print() {
        for (int i = 0; i < 8; i++)
            System.out.printf("%2d", pos[i]);
        System.out.println();
    }

    //--- i열의 알맞은 위치에 퀸을 배치 ---//
    static void set(int i) {
        for (int j = 0; j < 8; j++) {
            if (flag_a[j] == false &&                    // 가로(j행)에 아직 배치하지 않음
                    flag_b[i + j] == false &&            // 대각선 ↙에 아직 배치하지 않음
                    flag_c[i - j + 7] == false) {        // 대각선 ↘에 아직 배치하지 않음
                pos[i] = j;                              // 퀸을 j행에 배치함
                if (i == 7)                              // 모든 열에 배치함
                    print();
                else {
                    flag_a[j] = flag_b[i + j] = flag_c[i - j + 7] = true;
                    set(i + 1);
                    flag_a[j] = flag_b[i + j] = flag_c[i - j + 7] = false;
                }
            }
        }
    }

    public static void main(String[] args) {
        set(0);
    }
}
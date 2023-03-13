package baekjoon;

import java.util.Scanner;

public class No11653 {

    public static void main(String[] args) {
        // 소수가 아닌 수는 x % i ~ , x = x/i , i 출력
        // 소수일 경우 자기자신 출력
        Scanner in = new Scanner(System.in);

        Long N = in.nextLong();

        for (int i = 2; i < N; i++) {
            while (N % i == 0) {
                System.out.println(i);
                N /= i;
            }
            if(N==1) break;
        }
        if (N >= 2) System.out.println(N);
    }
}

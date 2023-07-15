package baekjoon;

import java.util.Scanner;

public class No11050 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();

        int[][] pascal = new int[N + 1][N + 1];

        pascal[0][0] = 1;
        for(int i=1;i<=N;i++) {
            pascal[i][0] = 1;
            pascal[i][i] = 1;

            for(int j=1;j<i;j++) {
                pascal[i][j] = pascal[i-1][j-1] + pascal[i-1][j];
            }
        }

//        파스칼 삼각형 출력
//        for(int i=0;i<pascal.length;i++) {
//            for(int j=0;j<=i;j++) {
//                System.out.print(pascal[i][j]+" ");
//            }System.out.println();
//        }

        int result = pascal[N][K];
        System.out.println(result);
    }
}

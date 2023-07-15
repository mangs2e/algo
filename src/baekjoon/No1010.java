package baekjoon;

import java.util.Scanner;

public class No1010 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int T = sc.nextInt();

        int[][] pascal = makePascal(30);

        for(int k=0;k<T;k++) {
            int K = sc.nextInt();
            int N = sc.nextInt();


            int result = pascal[N][K];
            sb.append(result).append("\n");
        }

        System.out.println(sb.toString());
    }

    private static int[][] makePascal(int size) {
        int[][] pascal = new int[size][size];
        pascal[0][0] = 1;
        for (int i = 1; i < pascal.length; i++) {
            pascal[i][0] = 1;
            pascal[i][i] = 1;

            for (int j = 1; j < i; j++) {
                pascal[i][j] = pascal[i - 1][j - 1] + pascal[i - 1][j];
            }
        }
        // 출력
//        for(int i=0;i<pascal.length;i++) {
//            for(int j=0;j<=i;j++) {
//                System.out.print(pascal[i][j]+" ");
//            }System.out.println();
//        }
        return pascal;
    }
}

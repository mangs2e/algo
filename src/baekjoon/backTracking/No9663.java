package baekjoon.backTracking;

import java.util.Scanner;

public class No9663 {
    static boolean[] flag_row; //행
    static boolean[] flag_diagonalA; //오른쪽 위 대각선
    static boolean[] flag_diagonalB; //오른쪽 아래 대각선
    static int[] pos; //N퀸
    static int N;
    static int count = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        pos = new int[N];
        flag_row = new boolean[N];
        flag_diagonalA = new boolean[N * 2 - 1];
        flag_diagonalB = new boolean[N * 2 - 1];

        set(0);
        System.out.println(count);
    }

    private static void set(int i) {
        for (int j = 0; j < N; j++) {
            if (!flag_row[j] && !flag_diagonalA[i + j] && !flag_diagonalB[i - j + (N - 1)]) {
                pos[i] = j;
                if (i == (N - 1)) {
                    count++;
                } else {
                    flag_row[j] = flag_diagonalA[i + j] = flag_diagonalB[i - j + (N - 1)] = true;
                    set(i + 1);
                    flag_row[j] = flag_diagonalA[i + j] = flag_diagonalB[i - j + (N - 1)] = false;
                }
            }
        }
    }
}

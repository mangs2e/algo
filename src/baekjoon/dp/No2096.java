package baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No2096 {
    static int[][] mindp;
    static int[][] maxdp;
    static int[][] arr;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        mindp = new int[N][3];
        maxdp = new int[N][3];
        arr = new int[N][3];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j = 0; j < 3; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int j = 0; j < 3; j++) {
            maxdp[0][j] = arr[0][j];
            mindp[0][j] = arr[0][j];
        }

        int min = currMin();
        int max = currMax();

        System.out.print(max + " " + min);
    }

    private static int currMax() {
        for (int i = 1; i < N; i++) {
            for (int j = 0; j < 3; j++) {
                if (j == 0) {
                    maxdp[i][j] = Math.max(maxdp[i - 1][j], maxdp[i - 1][j + 1]) + arr[i][j];
                    continue;
                }

                if (j == 1) {
                    maxdp[i][j] = Math.max(Math.max(maxdp[i - 1][j - 1], maxdp[i - 1][j]), maxdp[i - 1][j + 1]) + arr[i][j];
                    continue;
                }

                if (j == 2) {
                    maxdp[i][j] = Math.max(maxdp[i - 1][j], maxdp[i - 1][j - 1]) + arr[i][j];
                }
            }
        }

        return Math.max(Math.max(maxdp[N - 1][0], maxdp[N - 1][1]), maxdp[N - 1][2]);
    }

    private static int currMin() {
        for (int i = 1; i < N; i++) {
            for (int j = 0; j < 3; j++) {
                if (j == 0) {
                    mindp[i][j] = Math.min(mindp[i - 1][j], mindp[i - 1][j + 1]) + arr[i][j];
                    continue;
                }

                if (j == 1) {
                    mindp[i][j] = Math.min(Math.min(mindp[i - 1][j - 1], mindp[i - 1][j]), mindp[i - 1][j + 1]) + arr[i][j];
                    continue;
                }

                if (j == 2) {
                    mindp[i][j] = Math.min(mindp[i - 1][j], mindp[i - 1][j - 1]) + arr[i][j];
                }
            }
        }

        return Math.min(Math.min(mindp[N - 1][0], mindp[N - 1][1]), mindp[N - 1][2]);
    }
}

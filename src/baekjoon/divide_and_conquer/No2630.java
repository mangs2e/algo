package baekjoon.divide_and_conquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No2630 {
    static int[][] paper;
    static int resultWhite = 0;
    static int resultBlue = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        paper = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j = 1; j <= N; j++) {
                int color = Integer.parseInt(st.nextToken());
                paper[i][j] = color;
            }
        }

        recursive(1, 1, N);

        System.out.println(resultWhite);
        System.out.println(resultBlue);
    }

    private static void recursive(int x, int y, int N) {
        if (isAllColorSame(x, y, N)) {
            if (paper[x][y] == 1) {
                resultBlue++;
            } else {
                resultWhite++;
            }
        } else {
            int length = N / 2;
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 2; j++) {
                    recursive(x + i * length, y + j * length, length);
                }
            }
        }
    }

    private static boolean isAllColorSame(int x, int y, int length) {
        int start = paper[x][y];

        for (int i = x; i < x + length; i++) {
            for (int j = y; j < y + length; j++) {
                if (paper[i][j] != start) {
                    return false;
                }
            }
        }
        return true;
    }
}

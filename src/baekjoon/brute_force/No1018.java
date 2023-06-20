package baekjoon.brute_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No1018 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        char[][] chess = new char[N][M];
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                chess[i][j] = line.charAt(j);
            }
        }

        for (int x = 0; x <= N - 8; x++) {
            for (int y = 0; y <= M - 8; y++) {
                int count = 0;
                char startColor = chess[x][y]; // 시작 색깔 저장
                for (int i = x; i < x + 8; i++) {
                    for (int j = y; j < y + 8; j++) {
                        // 시작과 다른 색깔인 경우
                        if ((i - x) % 2 == (j - y) % 2 && chess[i][j] != startColor) {
                            count++;
                        }
                        // 시작과 같은 색깔인 경우
                        if ((i - x) % 2 != (j - y) % 2 && chess[i][j] ==  startColor) {
                            count++;
                        }
                    }
                }
                count = Math.min(count, 64 - count);
                min = Math.min(min, count);
            }
        }
        System.out.println(min);
    }
}



package baekjoon.brute_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No18111 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int[][] ground = new int[N][M];
        int min = Integer.MAX_VALUE;
        int max = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                ground[i][j] = Integer.parseInt(st.nextToken());
                if(ground[i][j] < min) min = ground[i][j];
                if(ground[i][j] > max) max = ground[i][j];
            }
        }

        int time = Integer.MAX_VALUE;
        int high = 0;
        for (int i = min; i <= max; i++) {
            int preTime = 0;
            int block = B;
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if(i < ground[j][k]) {
                        block += (ground[j][k] - i);
                        preTime += (ground[j][k] - i) * 2;
                    } else if (i > ground[j][k]) {
                        block -= (i - ground[j][k]);
                        preTime += (i - ground[j][k]);
                    } else {
                        continue;
                    }
                }

            }
            if(block < 0) break;

            if(preTime <= time) {
                time = preTime;
                high = i;
            }
        }
        System.out.println(time + " " + high);
    }
}

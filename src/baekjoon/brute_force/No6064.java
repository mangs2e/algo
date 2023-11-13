package baekjoon.brute_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No6064 {
    static int M, N, x, y;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());

            int rx, ry = 0;

            if (x > y) { //y를 1로 설정
                rx = x - y + 1;
                ry = 1;
            } else { //x를 1로 설정
                rx = 1;
                ry = y - x + 1;
            }

            int result = comb(rx, ry);
            sb.append(result).append("\n");
        }

        System.out.println(sb);
    }

    private static int comb(int rx, int ry) {
        int cnt = 1;
        int nx = 1;
        int ny = 1;
        boolean flag = false;

        while (!flag) {
            if (nx == rx && ny == ry) { //정답
                cnt = cnt + x - rx;
                nx = x;
                ny = y;
                flag = true;
            } else if (M - nx < N - ny) { //x가 먼저 1이 되는 경우
                ny = ny + M - nx + 1;
                cnt = cnt + M - nx + 1;
                nx = 1;
            } else if (M - nx > N - ny) { //y가 먼저 1이 되는 경우
                nx = nx + N - ny + 1;
                cnt = cnt + N - ny + 1;
                ny = 1;
            } else { //답이 안 나오는 경우
                cnt = cnt + N - ny;
                nx = M;
                ny = N;
                flag = true;
            }
        }

        if (nx == x && ny == y) {
            return cnt;
        } else {
            return -1;
        }

    }
}

package baekjoon.divide_and_conquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No1074 {
    static int x = 0;
    static int y = 0;
    static int count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int result = find((int) Math.pow(2, N), r, c);
        System.out.println(result);
    }

    private static int find(int n, int r, int c) {
        n /= 2; //리턴될 때마다 값을 줄여준다. 1이 될 때까지

        //왼쪽 위
        if (r < n + x && c < n + y) {
            count += (n * n * 0);
        //오른쪽 위
        } else if (r < n + x && c >= n + y) {
            count += (n * n * 1);
            y += n;
        //왼쪽 아래
        } else if (c < n + y) {
            count += (n * n * 2);
            x += n;
        //오른쪽 아래
        } else {
            count += (n * n * 3);
            x += n;
            y += n;
        }

        if (n == 1) {
            return count;
        }
        return find(n, r, c);
    }
}

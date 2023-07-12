package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No17103 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        boolean[] flag = new boolean[1000001];

        getPrimeList(flag);

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int num = Integer.parseInt(br.readLine());
            int count = 0;

            for (int j = 2; j <= num / 2; j++) {
                if (!flag[j] && !flag[num - j]) {
                    count++;
                }
            }
            sb.append(count).append("\n");
        }
        System.out.println(sb.toString());
    }

    private static void getPrimeList(boolean[] flag) {
        //소수면 false
        flag[0]=flag[1]=true;

        for (int i = 2; i * i < flag.length; i++) {
            if (!flag[i]) {
                for (int j = i * i; j < flag.length; j += i) {
                    flag[j] = true;
                }
            }
        }

    }
}

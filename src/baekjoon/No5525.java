package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No5525 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        char[] IOI = br.readLine().toCharArray();

        int cnt = 0;
        int flag = 0;
        for (int i = 1; i < M - 1; i++) {
            if (IOI[i - 1] == 'I' && IOI[i] == 'O' && IOI[i + 1] == 'I') {
                flag++;

                if (flag == N) {
                    flag--;
                    cnt++;
                }
                i++;
            } else {
                flag = 0;
            }
        }

        System.out.println(cnt);
    }
}

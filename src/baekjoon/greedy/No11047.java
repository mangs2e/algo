package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No11047 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); //동전 종류
        int money = Integer.parseInt(st.nextToken()); //총 가치

        Integer[] coins = new Integer[N];
        int start = 0;
        int count = 0; //최소의 동전 갯수

        for (int i = 0; i < N; i++) {
            coins[i] = Integer.parseInt(br.readLine());
            if(coins[i] <= money) start = i;
        }

        for (int i = start; i >= 0; i--) {
            count += (money / coins[i]);
            money %= coins[i];

            if (money == 0) {
                break;
            }
        }

        System.out.println(count);
    }
}

package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class No1541 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        Deque<Integer> num = new ArrayDeque<>();

        int current = 0;
        char lastChar = ' ';

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            if (c == '+' || c == '-') {
                if (lastChar == '+') {
                    num.offerLast(num.pollLast() + current);
                } else {
                    num.offerLast(current);
                }
                current = 0;
                lastChar = c;
            } else {
                current = current * 10 + (c - '0');
            }
        }

        if (lastChar == '+') {
            num.offerLast(num.pollLast() + current);
        } else {
            num.offerLast(current);
        }

        int result = Integer.MAX_VALUE;
        while (!num.isEmpty()) {
            int n = num.pollFirst();
            if (result == Integer.MAX_VALUE) {
                result = n;
            } else {
                result -= n;
            }
        }

        System.out.println(result);
    }
}

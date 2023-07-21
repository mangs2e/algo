package baekjoon.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class No10773 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> stack = new Stack<>();

        int K = Integer.parseInt(br.readLine());
        long sum = 0;

        for (int i = 0; i < K; i++) {
            int n = Integer.parseInt(br.readLine());

            if(n != 0) {
                stack.push(n);
            } else {
                stack.pop();
            }
        }

        for(int num : stack) {
            sum += num;
        }
        System.out.println(sum);
    }
}

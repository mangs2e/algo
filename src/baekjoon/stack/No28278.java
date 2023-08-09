package baekjoon.stack;

import java.util.Scanner;
import java.util.Stack;

public class No28278 {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int T = sc.nextInt();

        for (int i = 0; i < T; i++) {
            String text = sc.next();
            switch (text) {
                case "1":
                    int n = sc.nextInt();
                    stack.push(n);
                    break;
                case "2":
                    sb.append(stack.isEmpty() ? -1 : stack.pop()).append("\n");
                    break;
                case "3":
                    sb.append(stack.size()).append("\n");
                    break;
                case "4":
                    sb.append(stack.isEmpty() ? 1 : 0).append("\n");
                    break;
                case "5":
                    sb.append(stack.isEmpty() ? -1 : stack.peek()).append("\n");
                    break;
            }
        }

        System.out.println(sb.toString());
    }
}

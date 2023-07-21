package baekjoon.stack;

import java.util.Scanner;
import java.util.Stack;

public class No10828 {
    static int Top = -1;
    static Stack<Integer> stack = new Stack<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int T = sc.nextInt();

        for (int i = 0; i < T; i++) {
            String text = sc.next();
            switch (text) {
                case "push":
                    int n = sc.nextInt();
                    push(n);
                    break;
                case "pop":
                    sb.append(pop()).append("\n");
                    break;
                case "size":
                    sb.append(stack.size()).append("\n");
                    break;
                case "empty":
                    sb.append(isEmpty()).append("\n");
                    break;
                case "top":
                    sb.append(top()).append("\n");
                    break;
            }
        }

        System.out.println(sb.toString());
    }

    private static int isEmpty() {
        if(stack.isEmpty()) {
            return 1;
        } else {
            return 0;
        }
    }

    private static int top() {
        if(Top == -1) {
            return -1;
        } else {
            return stack.get(Top);
        }
    }

    private static int pop() {
        if(stack.isEmpty()) {
            return -1;
        } else {
            Top--;
            return stack.pop();
        }
    }

    private static void push(int n) {
        stack.push(n);
        Top++;
    }
}

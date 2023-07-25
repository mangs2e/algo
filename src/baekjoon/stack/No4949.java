package baekjoon.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class No4949 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();

        while(true) {
            boolean flag = false;
            String str = br.readLine();

            if(str.equals(".")) break;

            for (int i = 0; i < str.length(); i++) {
                if(str.charAt(i) == '(') {
                    stack.push(1);
                } else if (str.charAt(i) == ')') {
                    if (stack.isEmpty() || stack.peek() == 2) {
                        flag = true;
                        break;
                    } else if (stack.peek() == 1) {
                        stack.pop();
                    }
                } else if (str.charAt(i) == '[') {
                    stack.push(2);
                } else if (str.charAt(i) == ']') {
                    if (stack.isEmpty() || stack.peek() == 1) {
                        flag = true;
                        break;
                    } else if (stack.peek() == 2) {
                        stack.pop();
                    }
                }
            }

            if(stack.isEmpty() && !flag) {
                sb.append("yes").append("\n");
            } else {
                sb.append("no").append("\n");
            }
            stack.clear();
        }

        System.out.println(sb.toString() );
    }
}

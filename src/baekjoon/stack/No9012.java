package baekjoon.stack;

import java.util.Scanner;
import java.util.Stack;

public class No9012 {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int T = sc.nextInt();
        boolean flag2;

        for(int i = 0;i<T;i++) {
            int flag;
            int Top = -1;
            flag2 = false;
            String bracket = sc.next();
            for(int j = 0;j < bracket.length();j++) {
                if (bracket.charAt(j) == '(') {
                    flag = 1;
                } else flag = 0;

                if(stack.isEmpty() && flag == 0) {
                    flag2 = true;
                    continue;
                }
                stack.push(flag);
                Top++;
                if(Top > 0 && (stack.peek() * stack.get(Top-1)) == 0) {
                    stack.pop();
                    stack.pop();
                    Top -= 2;
                }
            }
            if(!flag2 && stack.isEmpty()) {
                sb.append("YES").append("\n");
            } else sb.append("NO").append("\n");
            stack.clear();
        }
        System.out.println(sb.toString());

    }
}

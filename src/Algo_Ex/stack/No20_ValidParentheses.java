package Algo_Ex.stack;

import java.util.Stack;

public class No20_ValidParentheses {
    public static void main(String[] args) {
        System.out.println(isValid2("([]){"));
    }

    //내가 푼 방법!
    public static boolean isValid(String s) {
        Stack<Integer> stack = new Stack<>();

        //() : 1, {} : 2, [] : 3
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(1);
            } else if (s.charAt(i) == ')') {
                if (stack.isEmpty() || stack.peek() == 2 || stack.peek() == 3) {
                    return false;
                } else {
                    stack.pop();
                }
            } else if (s.charAt(i) == '{') {
                stack.push(2);
            } else if (s.charAt(i) == '}') {
                if (stack.isEmpty() || stack.peek() == 1 || stack.peek() == 3) {
                    return false;
                } else {
                    stack.pop();
                }
            } else if (s.charAt(i) == '[') {
                stack.push(3);
            } else if (s.charAt(i) == ']') {
                if (stack.isEmpty() || stack.peek() == 1 || stack.peek() == 2) {
                    return false;
                } else {
                    stack.pop();
                }
            }
        }

        if(stack.isEmpty()) {
            return true;
        } else return false;
    }

    //스택 풀이1
    public static boolean isValid1(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }

                char top = stack.peek();
                if ((c == ')' && top == '(') || (c == '}' && top == '{') || (c == ']' && top == '[')) {
                    stack.pop();
                } else return false;
            }
        }

        return stack.isEmpty();
    }

    //스택 풀이2
    public static boolean isValid2(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(')');
            } else if (c == '{') {
                stack.push('}');
            } else if (c == '[') {
                stack.push(']');
            } else if (stack.isEmpty() || stack.pop() != c) {
                return false;
            }
        }

        return stack.isEmpty();
    }
}

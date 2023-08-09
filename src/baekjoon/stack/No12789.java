package baekjoon.stack;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class No12789 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Queue<Integer> queue = new LinkedList<>();
        Stack<Integer> stack = new Stack<>();

        int N = sc.nextInt();
        int count = 1;

        for (int i = 0; i < N; i++) {
            queue.add(sc.nextInt());
        }

        while (!queue.isEmpty()) {
            if (queue.peek() == count) {
                queue.poll();
                count++;
            } else if (!stack.isEmpty() && stack.peek() == count) {
                stack.pop();
                count++;
            } else {
                stack.push(queue.poll());
            }
        }

        while (!stack.isEmpty()) {
            if (stack.peek() == count) {
                stack.pop();
                count++;
            } else {
                System.out.println("Sad");
                return;
            }
        }

        System.out.println("Nice");
    }
}

package baekjoon.deque;

import java.util.*;

public class No2346 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        Deque<Integer> deque = new ArrayDeque<>();

        int N = sc.nextInt();
        int[] arr = new int[N + 1];

        for(int i = 1; i <= N ; i++) {
            deque.add(i);
            arr[i] = sc.nextInt();
        }
        int pollN = deque.pollFirst();
        sb.append(pollN).append(" ");

        while (deque.size() > 1) {

            for (int i = 0; i < Math.abs(arr[pollN]) - 1; i++) {
                if(arr[pollN] > 0) {
                    deque.addLast(deque.pollFirst());
                } else {
                    deque.addFirst(deque.pollLast());
                }
            }
            if(arr[pollN] > 0) {
                pollN = deque.pollFirst();
                sb.append(pollN).append(" ");
            } else {
                pollN = deque.pollLast();
                sb.append(pollN).append(" ");
            }
        }
        sb.append(deque.poll());
        System.out.println(sb.toString());
    }
}

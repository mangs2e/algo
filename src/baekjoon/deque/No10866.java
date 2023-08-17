package baekjoon.deque;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class No10866 {
    public static void main(String[] args) throws IOException {
        Deque<Integer> deque = new ArrayDeque<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String text = st.nextToken();
            switch (text) {
                case "push_front":
                    int n = Integer.parseInt(st.nextToken());
                    deque.addFirst(n);
                    break;
                case "push_back":
                    n = Integer.parseInt(st.nextToken());
                    deque.addLast(n);
                    break;
                case "pop_front":
                    sb.append(deque.isEmpty() ? -1 : deque.pollFirst()).append("\n");
                    break;
                case "pop_back":
                    sb.append(deque.isEmpty() ? -1 : deque.pollLast()).append("\n");
                    break;
                case "size":
                    sb.append(deque.size()).append("\n");
                    break;
                case "empty":
                    sb.append(deque.isEmpty() ? 1 : 0).append("\n");
                    break;
                case "back":
                    sb.append(deque.isEmpty() ? -1 : deque.getLast()).append("\n");
                    break;
                case "front":
                    sb.append(deque.isEmpty() ? -1 : deque.getFirst()).append("\n");
                    break;
            }
        }

        System.out.println(sb.toString());
    }
}

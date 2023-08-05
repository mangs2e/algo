package baekjoon.queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class No18258 {
    public static void main(String[] args) throws IOException {
        Deque<Integer> queue = new ArrayDeque<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String text = st.nextToken();
            switch (text) {
                case "push":
                    int n = Integer.parseInt(st.nextToken());
                    queue.offer(n);
                    break;
                case "pop":
                    if(queue.isEmpty()) { sb.append(-1).append("\n"); } else { sb.append(queue.poll()).append("\n"); }
                    break;
                case "size":
                    sb.append(queue.size()).append("\n");
                    break;
                case "empty":
                    if(queue.isEmpty()) { sb.append(1).append("\n"); } else { sb.append(0).append("\n"); }
                    break;
                case "back":
                    if (queue.isEmpty()) {
                        sb.append(-1).append("\n");
                    } else {
                        sb.append(queue.getLast()).append("\n");
                    }
                    break;
                case "front":
                    if(queue.isEmpty()) { sb.append(-1).append("\n"); } else { sb.append(queue.getFirst()).append("\n"); }
                    break;
            }
        }

        System.out.println(sb.toString());

    }
}

package baekjoon.queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class No11866 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        Queue<Integer> queue = new LinkedList<>();

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            queue.add(i+1);
        }

        sb.append("<");

        while(queue.size()>1) {
            for (int i = 0; i < K - 1; i++) {
                queue.offer(queue.poll());
            }
            sb.append(queue.poll()).append(", ");
        }
        sb.append(queue.poll()).append(">");

        System.out.println(sb.toString());
    }
}

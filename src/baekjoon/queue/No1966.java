package baekjoon.queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class No1966 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        Queue<Integer> queue = new LinkedList<>();

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int pointer = Integer.parseInt(st.nextToken());
            int max = 0;
            int count = 0;

            queue.clear();

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int num = Integer.parseInt(st.nextToken());
                if(max < num) max = num;
                queue.add(num);
            }

            while(!queue.isEmpty()) {
                if(queue.peek() == max) {
                    count++;

                    if(pointer == 0) {
                        sb.append(count).append("\n");
                        break;
                    } else {
                        queue.poll();
                    }

                    max = Collections.max(queue);
                } else {
                    queue.add(queue.poll());
                }

                pointer--;
                if(pointer < 0) {
                    pointer = queue.size() - 1;
                }
            }

        }
        System.out.println(sb.toString());
    }
}

package baekjoon.queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

public class No5430 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while (T --> 0) {
            String p = br.readLine();
            int size = Integer.parseInt(br.readLine());
            Deque<Integer> deque = new ArrayDeque<>();
            String str = br.readLine();
            String arr = str.substring(1, str.length()-1);

            String[] num = arr.split(",");
            for (int i = 0; i < size; i++) {
                deque.offerLast(Integer.parseInt(num[i]));
            }

            int count = 1;
            boolean isError = false;
            for (int i = 0; i < p.length(); i++) {
                char ch = p.charAt(i);
                if (ch == 'R') {
                    count++;
                }

                if (ch == 'D') {
                    if (count % 2 == 0 && !deque.isEmpty()) {
                        deque.pollLast();
                    } else if (count % 2 != 0 && !deque.isEmpty()) {
                        deque.pollFirst();
                    } else {
                        isError = true;
                        break;
                    }
                }
            }

            if (count % 2 == 0 && !isError) {
                sb.append("[");
                Iterator<Integer> descendingIterator = deque.descendingIterator();
                while (descendingIterator.hasNext()) {
                    sb.append(descendingIterator.next());
                    if (descendingIterator.hasNext()) {
                        sb.append(",");
                    }
                }
                sb.append("]").append("\n");
            } else if (count % 2 != 0 && !isError) {
                sb.append("[");
                Iterator<Integer> iterator = deque.iterator();
                while (iterator.hasNext()) {
                    sb.append(iterator.next());
                    if (iterator.hasNext()) {
                        sb.append(",");
                    }
                }
                sb.append("]").append("\n");
            } else {
                sb.append("error").append("\n");
            }
        }

        System.out.println(sb);
    }
}

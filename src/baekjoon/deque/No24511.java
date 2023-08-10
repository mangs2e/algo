package baekjoon.deque;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;
import java.util.StringTokenizer;

public class No24511 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        Deque<Integer> deque = new ArrayDeque<>();
        int[] flag = new int[100001];

        int N = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            flag[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            int num = Integer.parseInt(st.nextToken());
            if(flag[i] == 0) {
                deque.add(num);
            }
        }

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M-1; i++) {
            if (deque.isEmpty()) {
                sb.append(Integer.parseInt(st.nextToken())).append(" ");
            } else {
                sb.append(deque.pollLast()).append(" ");
                if (st.hasMoreTokens()) {
                    deque.addFirst(Integer.parseInt(st.nextToken()));
                }
            }
        }

        if(deque.isEmpty()) {
            sb.append(Integer.parseInt(st.nextToken()));
        } else {
            sb.append(deque.pollLast());
        }

        System.out.println(sb.toString());

        }
}

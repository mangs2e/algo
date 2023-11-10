package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class No1931 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Node[] n = new Node[100001];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            n[i] = new Node(start, end);
        }

        Arrays.sort(n, 0, N, Node::compareTo);

        int cnt = 0;
        int finish = 0;
        for (int i = 0; i < N; i++) {
            if (finish <= n[i].start) {
                cnt++;
                finish = n[i].end;
            }
        }

        System.out.println(cnt);
    }

    static class Node implements Comparable<Node> {
        int start, end;

        public Node(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Node o) {
            if (this.end == o.end) { //종료시작이 같을 때는 시작시간이 빠른 회의를 앞에 배치
                return Integer.compare(this.start, o.start);
            }
            return Integer.compare(this.end, o.end);
        }
    }
}

package baekjoon.queue;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class No7662 {
    static int k;
    static PriorityQueue<int[]> asc;
    static PriorityQueue<int[]> desc;
    static boolean[] flag;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine()); //test case
        while (T-- > 0) {
            asc = new PriorityQueue<>(new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return o1[0] - o2[0];
                }
            }); //minHeap
            desc = new PriorityQueue<>(new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return o2[0] - o1[0];
                }
            }); //maxHeap
            flag = new boolean[1000000];

            k = Integer.parseInt(br.readLine()); //operation case
            for (int i = 0; i < k; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String str = st.nextToken();
                int num = Integer.parseInt(st.nextToken());

                if (str.equals("D")) {
                    remove(num);
                } else {
                    insert(num, i);
                }
            }

            int max = Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;

            while (!asc.isEmpty()) {
                int[] now = asc.poll();

                if (!flag[now[1]]) {
                    if (now[0] > max) {
                        max = now[0];
                    }
                    if (now[0] < min) {
                        min = now[0];
                    }
                }
            }

            if (max == Integer.MIN_VALUE && min == Integer.MAX_VALUE) {
                sb.append("EMPTY").append("\n");
            } else {
                sb.append(max).append(" ").append(min).append("\n");
            }
        }
        System.out.println(sb);
    }

    private static void insert(int num, int i) {
        int[] node = {num, i};

        asc.add(node);
        desc.add(node);
    }

    private static void remove(int num) {
        if (num < 0) {
            poll(asc);
        } else {
            poll(desc);
        }
    }

    private static void poll(PriorityQueue<int[]> queue) {
        while (!queue.isEmpty()) {
            int[] node = queue.poll();

            if (flag[node[1]]) {
                continue;
            }

            flag[node[1]] = true;
            break;
        }
    }
}

//시간초과 걸린 풀이 - remove 때문인듯
//public class Main {
//    static int k;
//    static PriorityQueue<Integer> asc;
//    static PriorityQueue<Integer> desc;
//    static StringBuilder sb = new StringBuilder();
//    public static void main(String[] args) throws Exception {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        int T = Integer.parseInt(br.readLine()); //test case
//        while (T-- > 0) {
//            asc = new PriorityQueue<>(); //minHeap
//            desc = new PriorityQueue<>((a, b) -> Integer.compare(b, a)); //maxHeap
//
//            k = Integer.parseInt(br.readLine()); //operation case
//            for (int i = 0; i < k; i++) {
//                StringTokenizer st = new StringTokenizer(br.readLine());
//                String str = st.nextToken();
//                int num = Integer.parseInt(st.nextToken());
//
//                if (str.equals("D")) {
//                    remove(num);
//                } else {
//                    insert(num);
//                }
//            }
//            if (asc.isEmpty()) {
//                sb.append("EMPTY").append("\n");
//            } else {
//                sb.append(desc.poll()).append(" ").append(asc.poll()).append("\n");
//            }
//        }
//        System.out.println(sb);
//    }
//
//    private static void insert(int num) {
//        asc.add(num);
//        desc.add(num);
//    }
//
//    private static void remove(int num) {
//        if (asc.isEmpty()) {
//            return;
//        }
//
//        if (num < 0) {
//            int node = asc.poll();
//            desc.remove(node);
//        } else {
//            int node = desc.poll();
//            asc.remove(node);
//        }
//    }
//}

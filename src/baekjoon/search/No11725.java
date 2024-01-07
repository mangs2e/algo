package baekjoon.search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class No11725 {
    static ArrayList<Integer> subNodes[];
    static int[] parentNode;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        subNodes = new ArrayList[N + 1];
        parentNode = new int[N + 1];
        visited = new boolean[N + 1];

        for (int i = 0; i < N + 1; i++) {
            subNodes[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int curr = Integer.parseInt(st.nextToken());
            int sub = Integer.parseInt(st.nextToken());

            subNodes[curr].add(sub);
            subNodes[sub].add(curr);
        }

        dfs(1);
        for (int i = 2; i < parentNode.length; i++) {
            System.out.println(parentNode[i]);
        }
    }

    private static void dfs(int root) {
        visited[root] = true;
        for (int node : subNodes[root]) {
            if (!visited[node]) {
                parentNode[node] = root;
                dfs(node);
            }
        }
    }
}

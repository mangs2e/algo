package baekjoon.search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

class Graph {
    private int V; // 노드의 개수
    private List<List<Integer>> adj; // 인접 리스트

    public Graph(int V) {
        this.V = V;
        adj = new ArrayList<>(V + 1);
        for (int i = 0; i <= V; i++) {
            adj.add(new LinkedList<>());
        }
    }

    public void addEdge(int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }

    public int countConnectedComponents() {
        boolean[] visited = new boolean[V + 1];
        int count = 0;
        for (int i = 1; i <= V; i++) {
            if (!visited[i]) {
                dfs(i, visited);
                count++;
            }
        }
        return count;
    }

    private void dfs(int v, boolean[] visited) {
        visited[v] = true;
        for (int neighbor : adj.get(v)) {
            if (!visited[neighbor]) {
                dfs(neighbor, visited);
            }
        }
    }
}

public class No11724 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Graph g = new Graph(N);
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            g.addEdge(u, v);
        }

        int count = g.countConnectedComponents();
        System.out.println(count);
    }
}


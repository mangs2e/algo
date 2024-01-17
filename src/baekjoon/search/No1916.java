package baekjoon.search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class No1916 {
    //노드 클래스 지정
    public static class Node {
        int end;
        int cost;

        public Node(int end, int cost) {
            this.end = end;
            this.cost = cost;
        }
    }

    static ArrayList<ArrayList<Node>> graph;
    static int cityN, busN;
    static int[] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        cityN = Integer.parseInt(br.readLine());
        busN = Integer.parseInt(br.readLine());

        //1. 인접리스트를 활용한 그래프 초기화
        graph = new ArrayList<>();
        for (int i = 0; i <= cityN; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < busN; i++) {
            st = new StringTokenizer(br.readLine());
            graph.get(Integer.parseInt(st.nextToken())).add(new Node(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
        }

        //2. 최소 거리 정보를 담을 배열을 초기화
        dist = new int[cityN + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        dijkstra(start, end);
    }

    //3. 다익스트라 알고리즘 진행 (우선순위 큐 사용)
    private static void dijkstra(int start, int end) {
        //다익스트라 알고리즘의 최소비용을 기준으로 추출해야함! 최악의 경우 지수시간 만큼 연산을 해야할 수도 있음
        //중복 저장을 방지하기 위해 인접 노드들만, 갱신된 최소비용을 가지는 노드들만 힙에 저장해야함
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.cost, o2.cost));

        pq.offer(new Node(start, 0));
        dist[start] = 0;

        while (!pq.isEmpty()) {
            Node currNode = pq.poll();

            //목표 정점이 꺼내졌다면 해당 노드까지는 최솟값 갱신이 완료되었다는 뜻!
            if (currNode.end == end) {
                System.out.println(dist[currNode.end]);
                return;
            }

            //해당 노드의 비용이 dist 배열의 값보다 크다면 최소비용에 대한 부분을 고려할 필요가 없음
            if (dist[currNode.end] < currNode.cost) {
                continue;
            }

            //인접 노드들만 탐색하면 되므로 범위를 해당 노드의 인접 노드 개수만큼
            for (int i = 0; i < graph.get(currNode.end).size(); i++) {
                Node nxtNode = graph.get(currNode.end).get(i);
                //주변 노드까지의 현재 비용과 선택된 노드로부터 주변 노드로 가는 비용을 계산하고 더 작은 값 선택!
                if (dist[nxtNode.end] > currNode.cost + nxtNode.cost) {
                    dist[nxtNode.end] = currNode.cost + nxtNode.cost;
                    //갱신이 되지 않았다면 중복 저장이 될 수 있으므로 갱신이 된 경우에만 힙에 저장
                    pq.offer(new Node(nxtNode.end, dist[nxtNode.end]));
                }
            }
        }

        System.out.println(dist[end]);
    }

}

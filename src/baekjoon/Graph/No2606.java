package baekjoon.Graph;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Computer {
    class Node{
        int data;
        LinkedList<Node> adjacent; //인접한 노드
        boolean marked; //방문 여부

        //생성자
        Node(int data) {
            this.data = data;
            this.marked = false;
            adjacent = new LinkedList<Node>();
        }
    }

    Node[] nodes; //노드 저장 배열
    Computer(int size) {
        nodes = new Node[size+1]; //노드 개수는 고정으로 생성!
        for(int i=1;i<=size;i++) {
            nodes[i] = new Node(i);
        }
    }

    void addEdge(int i1, int i2) {
        Node n1 = nodes[i1];
        Node n2 = nodes[i2];
        //인접한 노드에 서로가 포함되어있지 않다면 포함
        if(!n1.adjacent.contains(n2)) {
            n1.adjacent.add(n2);
        }
        if(!n2.adjacent.contains(n1)) {
            n2.adjacent.add(n1);
        }
    }

    public int dfs(int v) {
        Node root = nodes[v];
        Stack<Node> stack = new Stack<Node>();
        stack.push(root);
        root.marked = true;
        List<Integer> result = new ArrayList<>();
        //stack이 빌 때까지 반복
        while(!stack.isEmpty()) {
            //처음 저장된 root노드를 꺼내고,
            Node r = stack.pop();
            //인접한 노드들에 방문을 하지 않았다면 stack에 저장
            for(Node n : r.adjacent) {
                if(n.marked == false) {
                    n.marked = true;
                    stack.push(n);
                }
            }
            result.add(r.data);
        }
        return result.size();
    }
}

public class No2606 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        Computer g = new Computer(N);
        for(int i=0;i<M;i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            g.addEdge(u, v);
        }

        int count = g.dfs(1);
        System.out.println(count-1);
    }
}

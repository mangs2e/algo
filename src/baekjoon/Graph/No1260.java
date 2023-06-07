package baekjoon.Graph;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Queue<T> {
    class Node<T> {
        private T data;
        private Node<T> next;
        public Node(T item) {
            this.data = item;
        }
    }

    private Node<T> first;
    private Node<T> last;

    public void enqueue(T item) {
        Node<T> t = new Node<T>(item);

        if(last != null) {
            last.next = t;
        }
        last = t;
        if(first == null) {
            first = last;
        }
    }

    public T dequeue() {
        if(first == null) {
            throw new NoSuchElementException();
        }
        T data = first.data;
        first = first.next;
        if(first == null) {
            last = null;
        }
        return data;
    }

    public boolean isEmpty() {
        return first == null;
    }
}

class Graph2 {
    class Node {
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

    Graph2(int size) {
        nodes = new Node[size+1]; //노드 개수는 고정으로 생성!
        for (int i = 1; i <= size; i++) {
            nodes[i] = new Node(i);
        }
    }

    //두 노드의 관계 저장 함수
    void addEdge(int i1, int i2) {
        Node n1 = nodes[i1];
        Node n2 = nodes[i2];
        //인접한 노드에 서로가 포함되어있지 않다면 포함
        if (!n1.adjacent.contains(n2)) {
            n1.adjacent.add(n2);
        }
        if (!n2.adjacent.contains(n1)) {
            n2.adjacent.add(n1);
        }
    }

    //DFS알고리즘 - 시작 인덱스를 받아서 호출
    void dfs(int index) {
        Node root = nodes[index];
        Stack<Node> stack = new Stack<Node>();
        stack.push(root);
        root.marked = true;
        //stack이 빌 때까지 반복
        while (!stack.isEmpty()) {
            //처음 저장된 root노드를 꺼내고,
            Node r = stack.pop();
            //인접한 노드들에 방문을 하지 않았다면 stack에 저장
            for (Node n : r.adjacent) {
                if (n.marked == false) {
                    n.marked = true;
                    stack.push(n);
                }
            }
            //꺼낸 노드 출력
            visit(r);
        }
    }

    //재귀함수 이용
    void dfsR(Node r) {
        if(r == null) return;
        r.marked = true;
        visit(r);

        // 인접한 노드를 정렬하여 작은 수부터 방문하도록 수정
        r.adjacent.sort((a, b) -> a.data - b.data);

        for(Node n:r.adjacent) {
            if(!n.marked) {
                dfsR(n);
            }
        }
    }
    //indes를 매개변수로 받는 재귀함수도 생성
    void dfsR(int index) {
        Node r = nodes[index];
        dfsR(r);
    }

    //BFS알고리즘 - 시작 인덱스를 받아서 호출
    void bfs(int index) {
        Node root = nodes[index];
        Queue<Node> queue = new Queue<Node>();
        queue.enqueue(root);
        root.marked = true;
        //queue가 빌 때까지 반복
        while (!queue.isEmpty()) {
            Node r = queue.dequeue();
            for (Node n : r.adjacent) {
                if (n.marked == false) {
                    n.marked = true;
                    queue.enqueue(n);
                }
            }
            visit(r);
        }
    }

    void visit(Node r) {
        System.out.print(r.data+" ");
    }
}

public class No1260{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        Graph2 g = new Graph2(N);
        for(int i=0;i<M;i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            g.addEdge(u, v);
        }
        g.dfsR(V);
        System.out.println();
        for(int i = 1; i <= N; i++) {
            g.nodes[i].marked = false; // marked 상태 초기화
        }
        g.bfs(V);
    }
}

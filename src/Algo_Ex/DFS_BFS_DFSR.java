package Algo_Ex;

import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Stack;

class Queue<T> {

    class Node<T> {
        private T data;
        private Node<T> next;
        public Node(T data) {
            this.data = data;
        }
    }

    private Node<T> first;
    private Node<T> last;

    //큐에 데이터 추가
    public void enqueue(T item) {
        Node<T> t = new Node<T>(item);

        //마지막 노드가 없을 때 새로운 노드를 마지막에 붙여줌
        if(last != null) {
            last.next = t;
        }
        last = t;
        //데이터가 없을때
        if(first == null) {
            first = last;
        }
    }

    //큐 데이터 제거
    public T dequeue() {
        //데이터가 없을 때 예외 발생
        if(first == null) {
            throw new NoSuchElementException();
        }
        //큐에서 첫번째 노드를 제거했으므로 first는 first.next 값이 되어야 함
        T data = first.data;
        first = first.next;

        if(first == null) {
            last = null;
        }
        return data;
    }

    //첫번째 노드 조회
    public T peek() {
        //데이터가 없으면 예외를 발생시키고, 있으면 data 반환
        if(first == null) {
            throw new NoSuchElementException();
        }
        return first.data;
    }

    public boolean isEmpty() {
        return first == null;
    }
}

class Graph{
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
    Graph(int size) {
        nodes = new Node[size]; //노드 개수는 고정으로 생성!
        for(int i=0;i<size;i++) {
            nodes[i] = new Node(i);
        }
    }

    //두 노드의 관계 저장 함수
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

    //DFS알고리즘 - 매개변수를 주지 않고 호출시 0번부터 호출
    void dfs() {
        dfs(0);
    }
    //DFS알고리즘 - 시작 인덱스를 받아서 호출
    void dfs(int index) {
        Node root = nodes[index];
        Stack<Node> stack = new Stack<Node>();
        stack.push(root);
        root.marked = true;
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
            //꺼낸 노드 출력
            visit(r);
        }
    }

    //BFS알고리즘 - 매개변수를 주지 않고 호출시 0번부터 호출
    void bfs(){
        bfs(0);
    }
    //BFS알고리즘 - 시작 인덱스를 받아서 호출
    void bfs(int index) {
        Node root = nodes[index];
        Queue<Node> queue = new Queue<Node>();
        queue.enqueue(root);
        root.marked = true;
        //queue가 빌 때까지 반복
        while(!queue.isEmpty()) {
            Node r = queue.dequeue();
            for(Node n : r.adjacent) {
                if(n.marked == false) {
                    n.marked = true;
                    queue.enqueue(n);
                }
            }
        visit(r);
        }
    }

    //재귀함수 이용
    void dfsR(Node r) {
        if(r == null) return;
        r.marked = true;
        visit(r);
        for(Node n:r.adjacent) {
            if(n.marked == false) {
                dfsR(n);
            }
        }
    }
    //indes를 매개변수로 받는 재귀함수도 생성
    void dfsR(int index) {
        Node r = nodes[index];
        dfsR(r);
    }
    void dfsR() {
        dfsR(0);
    }

    //출력하는 함수
    private void visit(Node r) {
        System.out.print(r.data+" ");
    }
}

/*
*   0
*  /
* 1 -- 3   7
* |  / | \ /
* | /  |  5
* 2 -- 4   \
*           6 - 8
* */
public class DFS_BFS_DFSR {
    public static void main(String[] args) {
        Graph g = new Graph(9);
        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(1, 3);
        g.addEdge(2, 3);
        g.addEdge(2, 4);
        g.addEdge(3, 4);
        g.addEdge(3, 5);
        g.addEdge(5, 6);
        g.addEdge(5, 7);
        g.addEdge(6, 8);
        g.dfs(); // 0 1 3 5 7 6 8 4 2
        g.dfs(3); // 3 5 7 6 8 4 2 1 0
        g.bfs(); // 0 1 2 3 4 5 6 7 8
        g.bfs(3); // 3 1 2 4 5 0 6 7 8
        g.dfsR(); // 0 1 2 3 4 5 6 8 7
        g.dfsR(3); // 3 1 0 2 4 5 6 8 7
    }
}

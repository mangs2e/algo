package Algo_Ex;

//배열을 이진트리로 만들기
class Tree {
    class Node {
        int data;
        Node left;
        Node right;
        Node(int data) {
            this.data = data;
        }
    }
    Node root;

    public void makeTree(int[] a) {
        root = makeTreeR(a, 0, a.length - 1);
    }
    public Node makeTreeR(int[] a, int start, int end) {
        //배열, 시작 인덱스, 끝 인덱스 매개변수
        if (start > end) return null; //재귀함수 종료
        int mid = (start + end) / 2;
        Node node = new Node(a[mid]); //중간값으로 노드 생성
        //왼쪽, 오른쪽 노드 범위 변경
        node.left = makeTreeR(a, start, mid - 1);
        node.right = makeTreeR(a, mid + 1, end);
        return node;
    }

    public void searchBTree(Node n, int find) {
        if (find < n.data) {
            System.out.println("Data is smaller than "+n.data);
            searchBTree(n.left, find);
        }else if(find > n.data) {
            System.out.println("Data is bigger than "+n.data);
            searchBTree(n.right, find);
        }else{
            System.out.println("Data found!");
        }
    }
}

public class Binary_Tree {
    public static void main(String[] args) {
        int[] a = new int[10];
        for(int i=0;i<a.length;i++) {
            a[i] = i;
        }

        Tree t = new Tree();

        /*
        *        (4)
        *       /   \
        *      /     \
        *    (1)     (7)
        *    / \     / \
        *  (0) (2) (5) (8)
        *       \   \   \
        *      (3) (6) (9)
        * */

        t.makeTree(a);
        t.searchBTree(t.root, 7);

    }
}

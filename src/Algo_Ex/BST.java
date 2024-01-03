package Algo_Ex;

class BinarySearchTree {
    class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
        }
    }
    Node root;

    public Node search(Node root, int key) {
        if(root == null || root.data == key) return root;
        if(root.data>key) return search(root.left, key);
        return search(root.right, key);
    }

    public void insert(int data) {
        root = insert(root, data);
    }
    private Node insert(Node root, int data) {
        if(root == null) {
            root = new Node(data);
            return root;
        }
        if(data < root.data) {
            root.left = insert(root.left, data);
        }else if(data > root.data) {
            root.right = insert(root.right,data);
        }
        return root;
    }

    public void delete(int data) {
        root = delete(root, data);
    }
    private Node delete(Node root, int data) {
        if(root == null) return root;
        if(data < root.data) {
            root.left = delete(root.left, data);
        }else if(data > root.data) {
            root.right = delete(root.right, data);
        }else{
            //자식이 없는 경우
            if(root.left == null && root.right == null) return null;
            //자식이 하나만 있는 경우
            else if(root.left == null) return root.right;
            else if(root.right == null) return root.left;
            //자식이 둘 다 있는 경우
            root.data = findMin(root.right); //삭제한 노드의 바로 앞이나 바로 뒤 노드
            //-> 오른쪽 노드의 최솟값이나 왼쪽 노드의 최댓값을 구해야함
            //위에서 찾은 root.right중 최솟값이 남아있으므로 삭제까지 완료해야함
            root.right = delete(root.right, root.data);
        }
        return root;
    }

    int findMin(Node root) {
        int min = root.data;
        while(root.left != null) {
            min = root.left.data;
            root = root.left;
        }
        return min;
    }

    public void inorder() {
        inorder(root);
        System.out.println("");
    }
    private void inorder(Node root) {
        if(root != null) {
            inorder(root.left);
            System.out.print(root.data + " ");
            inorder(root.right);
        }
    }
}

public class BST {
    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        /*
        *      4
        *    /   \
        *   2     6
        *  / \   / \
        * 1  3  5  7
        */

        tree.insert(4);
        tree.insert(2);
        tree.insert(1);
        tree.insert(3);
        tree.insert(6);
        tree.insert(5);
        tree.insert(7);

        tree.inorder(); //1 2 3 4 5 6 7
        tree.delete(7);
        tree.inorder(); //1 2 3 4 5 6
    }
}

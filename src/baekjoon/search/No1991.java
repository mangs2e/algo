package baekjoon.search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No1991 {
    static StringBuilder sb = new StringBuilder();
    static TreeNode node = new TreeNode("A");
    public static class TreeNode {
        String val;
        TreeNode left;
        TreeNode right;

        TreeNode(String val) {
            this.val = val;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int nodeN = Integer.parseInt(br.readLine());

        for (int i = 0; i < nodeN; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            String root = st.nextToken();
            String left = st.nextToken();
            String right = st.nextToken();

            makeTree(node, root, left, right);
        }

        preOrder(node);
        sb.append("\n");
        inOrder(node);
        sb.append("\n");
        postOrder(node);
        sb.append("\n");
        System.out.println(sb);
    }

    private static void makeTree(TreeNode node, String root, String left, String right) {
        if (node.val.equals(root)) {
            node.left = (left.equals(".") ? null : new TreeNode(left));
            node.right = (right.equals(".") ? null : new TreeNode(right));
        } else {
            if (node.left != null) {
                makeTree(node.left, root, left, right);
            }
            if (node.right != null) {
                makeTree(node.right, root, left, right);
            }
        }
    }

    //후위 순회
    private static void postOrder(TreeNode node) {
        if(node == null) return;
        postOrder(node.left);
        postOrder(node.right);
        sb.append(node.val);
    }

    //중위 순회
    private static void inOrder(TreeNode node) {
        if(node == null) return;
        inOrder(node.left);
        sb.append(node.val);
        inOrder(node.right);
    }

    //전위 순회
    private static void preOrder(TreeNode node) {
        if(node == null) return;
        sb.append(node.val);
        preOrder(node.left);
        preOrder(node.right);
    }

}

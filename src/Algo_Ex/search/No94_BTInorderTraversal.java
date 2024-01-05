package Algo_Ex.search;

import java.util.ArrayList;
import java.util.List;

public class No94_BTInorderTraversal {
     public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
        }
     }

    public static void main(String[] args) {
        //바이너리 트리 (중위 순회)
        TreeNode node = new TreeNode(1, null, new TreeNode(2, new TreeNode(3), null));
        List<Integer> result = inorderTraversal(node);
        for (int k : result) {
            System.out.print(k+" ");
        }
    }

    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> nodes = new ArrayList<>();
        inorderTraversal(root, nodes);
        return nodes;
    }

    private static void inorderTraversal(TreeNode root, List<Integer> nodes) {
        if (root != null) {
            inorderTraversal(root.left, nodes);
            nodes.add(root.val);
            inorderTraversal(root.right, nodes);
        }
    }


}

package Algo_Ex.search;

import static Algo_Ex.search.No94_BTInorderTraversal.*;

public class No100_SameTree {
    public static void main(String[] args) {
        //같은 트리인지 확인하는 문제
        TreeNode node1 = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        TreeNode node2 = new TreeNode(1, new TreeNode(2, new TreeNode(4), null), new TreeNode(3));

        System.out.println(isSameTree(node1, node2));
    }

    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }

        if (p == null || q == null || (p.val != q.val)) {
            return false;
        }

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}

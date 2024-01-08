package Algo_Ex.search;

import Algo_Ex.search.No94_BTInorderTraversal.*;

public class No110_BalancedBT {
    public static void main(String[] args) {
        //균형 이진 트리가 맞는지 아닌지 확인하는 문제
        TreeNode node = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        System.out.println(isBalanced(node));

        node = new TreeNode(1, new TreeNode(2, new TreeNode(3, new TreeNode(4), new TreeNode(4)), new TreeNode(3)), new TreeNode(2));
        System.out.println(isBalanced(node));
    }

    public static boolean isBalanced(TreeNode root) {
        if(root == null) return true;

        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);

        if (Math.abs(leftHeight - rightHeight) > 1) {
            return false;
        }

        return isBalanced(root.right) && isBalanced(root.left);
    }

    private static int getHeight(TreeNode root) {
        if (root == null) return 0;

        int left = getHeight(root.left);
        int right = getHeight(root.right);

        return Math.max(left, right) + 1;
    }
}

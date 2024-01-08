package Algo_Ex.search;

import Algo_Ex.search.No94_BTInorderTraversal.*;


public class No111_MinimumDepth {
    public static void main(String[] args) {
        //이진 트리 최소 깊이 구하는 문제
        TreeNode node = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        System.out.println(minDepth(node));
    }

    public static int minDepth(TreeNode root) {
        if(root == null) return 0;

        int left = minDepth(root.left);
        int right = minDepth(root.right);

        //현재 노드가 리프 노드인 경우 노드가 존재하는 값 + 1
        if(left == 0 || right == 0) return Math.max(left, right) + 1;
        //둘 다 리프 노드가 아닌 경우 둘 중 더 작은 값 + 1
        else return Math.min(left, right) + 1;
    }
}

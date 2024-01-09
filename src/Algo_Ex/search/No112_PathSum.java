package Algo_Ex.search;

import Algo_Ex.search.No94_BTInorderTraversal.*;

public class No112_PathSum {
    public static void main(String[] args) {
        //root-to-leaf 합산과 target 일치 여부 확인 문제
        TreeNode node = new TreeNode(5,
                new TreeNode(4, new TreeNode(11, new TreeNode(7), new TreeNode(2)), null),
                new TreeNode(8, new TreeNode(13), new TreeNode(4, null, new TreeNode(1))));
        System.out.println(hasPathSum(node, 22));

        TreeNode node2 = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        System.out.println(hasPathSum2(node2, 22));
    }

    //dfs - 재귀이용 (targetSum에서 값을 빼나간다는 생각을 못했는데 발상의 전환!)
    public static boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null) return false;

        targetSum -= root.val;

        if (root.left == null && root.right == null) {
            if(targetSum == 0) return true;
        }

        boolean leftIsLeaf = hasPathSum(root.left, targetSum);
        boolean rightIsLeaf = hasPathSum(root.right, targetSum);

        return leftIsLeaf || rightIsLeaf;
    }

    //빼는게 아니라 더하는 방식
    public static boolean hasPathSum2(TreeNode root, int targetSum) {
        int sum = 0;
        return rootToLeafSum(root, targetSum, sum);
    }

    private static boolean rootToLeafSum(TreeNode root, int targetSum, int sum) {
        if(root == null) return false;

        if (root.left == null && root.right == null) {
            sum = sum + root.val;
            if(sum == targetSum) return true;
        }

        return rootToLeafSum(root.left, targetSum, sum + root.val) || rootToLeafSum(root.right, targetSum, sum + root.val);
    }
}

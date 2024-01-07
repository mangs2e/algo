package Algo_Ex.search;

import java.util.Stack;

import static Algo_Ex.search.No94_BTInorderTraversal.*;

public class No104_MaximumDepth {
    public static void main(String[] args) {
        //바이너리 트리 최대 깊이 구하기
        TreeNode node = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        System.out.println(maxDepth(node));
        System.out.println(maxDepthRecur(node));
    }

    //내가 짠 코드 (dfs - Stack 활용)
    public static int maxDepth(TreeNode root) {
        if(root == null) return 0;

        Stack<TreeNode> nodeStack = new Stack<>();
        Stack<Integer> depthStack = new Stack<>();
        nodeStack.push(root);
        depthStack.push(1);

        int result = 0;

        while (!nodeStack.isEmpty()) {
            TreeNode currNode = nodeStack.pop();
            int currDepth = depthStack.pop();
            result = Math.max(result, currDepth);

            if (currNode.left != null) {
                nodeStack.push(currNode.left);
                depthStack.push(currDepth + 1);
            }

            if (currNode.right != null) {
                nodeStack.push(currNode.right);
                depthStack.push(currDepth + 1);
            }
        }

        return result;
    }

    //(dfs - 재귀 사용)
    public static int maxDepthRecur(TreeNode root) {
        if(root == null) return 0;

        int left = maxDepthRecur(root.left);
        int right = maxDepthRecur(root.right);

        return Math.max(left, right) + 1;
    }
}

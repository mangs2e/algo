package Algo_Ex.search;

import java.util.Stack;

import static Algo_Ex.search.No94_BTInorderTraversal.*;

public class No101_SymmetricTree {
    public static void main(String[] args) {
        //root 노드를 중심으로 양옆 노드들이 대칭을 이루는지 확인하는 문제
        TreeNode val1 = new TreeNode(3);
        TreeNode val2 = new TreeNode(4);
        TreeNode left = new TreeNode(2, val1, val2);
        TreeNode right = new TreeNode(2, val2, val1);
        TreeNode node = new TreeNode(1, left, right);

        System.out.println(isSymmetric(node));
        System.out.println(isSymmetricStack(node));
    }

    //내가 짠 코드
    public static boolean isSymmetric(TreeNode root) {
        //node를 좌우로 쪼개서 2개의 노드로 순회하는 메소드를 새로 생성
        TreeNode left = root.left;
        TreeNode right = root.right;
        return recursive(left, right);
    }

    private static boolean recursive(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }

        if (left == null || right == null || (left.val != right.val)) {
            return false;
        }

        return recursive(left.left, right.right) && recursive(left.right, right.left);
    }

    //재귀를 사용하지 않고 Stack 사용
    public static boolean isSymmetricStack(TreeNode root) {
        if(root == null) return true;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root.left);
        stack.push(root.right);

        while (!stack.isEmpty()) {
            TreeNode node1 = stack.pop();
            TreeNode node2 = stack.pop();

            if(node1 == null && node2 == null) continue;
            if(node1 == null || node2 == null || (node1.val != node2.val)) return false;

            stack.push(node1.left);
            stack.push(node2.right);
            stack.push(node1.right);
            stack.push(node2.left);
        }

        return true;
    }
}

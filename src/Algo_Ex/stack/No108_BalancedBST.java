package Algo_Ex.stack;

public class No108_BalancedBST {
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
        //균형 이진 탐색 트리로 전환하는 방법
        int[] nums = {-10, -3, 0, 5, 9};
        TreeNode result = sortedArrayToBST(nums);
        inorderTraversal(result);
    }

    //중위 순회 출력
    private static void inorderTraversal(TreeNode result) {
        if (result != null) {
            inorderTraversal(result.left);
            System.out.print(result.val + " ");
            inorderTraversal(result.right);
        }
    }

    //균형 이진 탐색 트리 구현 (분할과 정복)
    public static TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }

        return sortedArrayToBST(nums, 0, nums.length - 1);
    }

    private static TreeNode sortedArrayToBST(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }

        int mid = start + (end - start) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = sortedArrayToBST(nums, start, mid - 1);
        root.right = sortedArrayToBST(nums, mid + 1, end);

        return root;
    }
}

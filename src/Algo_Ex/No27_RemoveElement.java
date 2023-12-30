package Algo_Ex;


public class No27_RemoveElement {
    public static void main(String[] args) {
        int[] nums = {3, 2, 2, 3};
        int val = 3;
        //배열 nums에서 val과 같은 값을 삭제하는 메소드
        removeElement(nums, val);
    }


    //Time complexity : O(n)
    //Space complexity : O(1)
    public static int removeElement(int[] nums, int val) {
        if (nums.length == 0) {
            return 0;
        }

        int idx = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[idx] = nums[i];
                idx++;
            }
        }

        return idx;
    }
}

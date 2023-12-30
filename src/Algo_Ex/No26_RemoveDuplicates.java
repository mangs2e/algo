package Algo_Ex;

import java.util.Set;
import java.util.TreeSet;

public class No26_RemoveDuplicates {
    //배열 Nums 값들 중 중복값을 제외한 값들만 출력!
    //[0,1,1,2,2,3]의 경우 [0,1,2,3,_,_,_]

    //배열만을 이용한 방법
    protected static int removeDuplicates1(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int k = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[k] = nums[i];
                k++;
            }
        }

        return k;
    }

    //set을 이용한 방법
    protected static int removeDuplicates2(int[] nums) {
        Set<Integer> integerSet = new TreeSet<>();

        for (int i = 0; i < nums.length; i++) {
            integerSet.add(nums[i]);
        }

        int idx = 0;
        for (int k : integerSet) {
            nums[idx] = k;
            idx++;
        }

        return integerSet.size();
    }
}

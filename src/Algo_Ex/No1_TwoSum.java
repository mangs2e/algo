package Algo_Ex;


import java.util.HashMap;
import java.util.Map;

public class No1_TwoSum {
    public static void main(String[] args) {
        //nums 배열의 값 2개를 더해서 target 값이 되는 인덱스를 출력! 무조건 하나의 정답이 있다고 간주

        int[] nums = {2, 7, 11, 16};
        int target = 9;

    }

    //브루트 포스
    public int[] twoSum1(int[] nums, int target) {

        int n = nums.length;

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums[j] + nums[i] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{};
    }

    //해시 테이블 사용 - Two pass
    public int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> numMap = new HashMap<>();
        int n = nums.length;

        //해시맵 초기화
        for (int i = 0; i < n; i++) {
            numMap.put(nums[i], i);
        }
        //{2, 0}{7, 1}{11, 2}{16, 3}

        for (int i = 0; i < n; i++) {
            int complement = target - nums[i]; //7
            if (numMap.containsKey(complement) && numMap.get(complement) != i) {
                return new int[]{i, numMap.get(complement)};
            }
        }

        return new int[]{};
    }

    //해시 테이블 - One pass
    public int[] twoSum3(int[] nums, int target) {
        Map<Integer, Integer> numMap = new HashMap<>();
        int n = nums.length;

        for (int i = 0; i < n; i++) { //i : 1
            int complement = target - nums[i]; //2
            if (numMap.containsKey(complement)) {
                return new int[]{numMap.get(complement), i};
            }
            numMap.put(nums[i], i);
        }

        return new int[]{};
    }
}

package Algo_Ex;

import java.util.HashMap;
import java.util.Map;

public class No136_SingleNumber {
    public static void main(String[] args) {
        //중복되지 않은 유일한 값 찾는 문제
        int[] nums = {4, 1, 2, 1, 4};
        System.out.println(singleNumber(nums));
        System.out.println(singleNumber2(nums));
    }

    //내가 푼 코드 ! map 이용
    public static int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int value = map.getOrDefault(nums[i], 0);
            map.put(nums[i], value + 1);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue().equals(1)) {
                return entry.getKey();
            }
        }

        return 0;
    }

    //^ 연산자 사용
    public static int singleNumber2(int[] nums) {
        int uniqueNum = 0;

        for (int i = 0; i < nums.length; i++) {
            uniqueNum ^= nums[i];
        }

        return uniqueNum;
    }
}

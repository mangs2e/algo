package Algo_Ex;


import java.util.Arrays;

public class No66_PlusOne {
    public static void main(String[] args) {
        //{1, 2, 3, 4}의 값은 정수 1234라고 생각! 정수에서 +1을 한 값을 다시 배열의 형태로 출력하는 문제
        //{9} -> {1, 0] | {2, 3} -> {2, 4}
        int[] digits = {7,2,8,5,0,9,1,2,9,5,3,6,6,7,3,2,8,4,3,7,9,5,7,7,4,7,4,9,4,7,0,1,1,1,7,4,0,0,6};
        System.out.println(Arrays.toString(plusOne(digits)));
    }

    public static int[] plusOne(int[] digits) {
        int n = digits.length;

        for (int i = n - 1; i >= 0; i--) {
            digits[i]++;

            if (digits[i] == 10) {
                digits[i] = 0;
            } else return digits;
        }

        int[] result = new int[n + 1];
        result[0] = 1;
        return result;
    }
}

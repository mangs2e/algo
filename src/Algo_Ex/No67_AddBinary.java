package Algo_Ex;

import java.math.BigInteger;
import java.util.Arrays;

public class No67_AddBinary {
    public static void main(String[] args) {
        //이진수 a, b의 합을 구하는 문제
        String a = "1010";
        String b = "1101";
        System.out.println(addBinary1(a, b));
    }

    //내가 짠 BigInteger 활용 코드
    public static String addBinary(String a, String b) {
        BigInteger aNum = new BigInteger(a, 2);
        BigInteger bNum = new BigInteger(b, 2);
        BigInteger sum = aNum.add(bNum);

        return sum.toString();
    }

    //반복문을 이용한 풀이
    public static String addBinary1(String a, String b) {
        StringBuilder sb = new StringBuilder();

        int carry = 0;
        int i = a.length() - 1;
        int j = b.length() - 1;

        while (i >= 0 || j >= 0 || carry == 1) {
            if (i >= 0) {
                carry += a.charAt(i--) - '0';
            }
            if (j >= 0) {
                carry += b.charAt(j--) - '0';
            }
            sb.append(carry % 2);
            carry /= 2;
        }

        return sb.reverse().toString();
    }
}

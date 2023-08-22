package baekjoon;

import java.util.Scanner;

public class No15829 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int length = sc.nextInt();
        String str = sc.next();

        long sum = 0;
        long pow = 1;

        for (int i = 0; i < length; i++) {
            long num = (long) str.charAt(i) - 96;
            sum += num * pow;
            pow = (pow * 31) % 1234567891;
        }

        System.out.println(sum % 1234567891);
    }
}

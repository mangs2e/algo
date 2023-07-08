package baekjoon;

import java.util.Scanner;

public class No13241 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long A = sc.nextInt();
        long B = sc.nextInt();
        long result = 0;

        result = (A*B) / recursive(A, B);

        System.out.println(result);
    }

    private static long recursive(long a, long b) {
        if(b == 0) {
            return a;
        }
        return recursive(b, a%b);
    }
}

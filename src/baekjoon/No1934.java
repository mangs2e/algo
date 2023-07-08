package baekjoon;

import java.util.Scanner;

public class No1934 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuffer sb = new StringBuffer();

        int T = sc.nextInt();
        for(int i=0;i<T;i++) {
            int A = sc.nextInt();
            int B = sc.nextInt();
            int result = 0;

            result = (A*B) / recursive(A, B);
            sb.append(result+"\n");
        }

        System.out.println(sb.toString());
    }

    private static int recursive(int a, int b) {
        if(b == 0) {
            return a;
        }
        return recursive(b, a%b);
    }
}

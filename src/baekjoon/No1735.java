package baekjoon;

import java.util.Scanner;

public class No1735 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuffer sb = new StringBuffer();

        //분자 numer 분모 denom

        int numer1 = sc.nextInt();
        int denom1 = sc.nextInt();
        int numer2 = sc.nextInt();
        int denom2 = sc.nextInt();

        int numer = (numer1*denom2) + (numer2*denom1);
        int denom = denom1*denom2;
        int gcd = 1; //최대공약수

        for (int i = 2; i <= numer && i <= denom; i++) {
            if (numer % i == 0 && denom % i == 0) {
                gcd = i;
            }
        }

        sb.append(numer/gcd).append(" ").append(denom/gcd);

        System.out.println(sb.toString());

    }
}

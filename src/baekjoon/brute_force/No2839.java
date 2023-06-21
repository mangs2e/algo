package baekjoon.brute_force;

import java.util.Scanner;

public class No2839 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int bag = 0;

        while(true) {
            if(N%5 == 0) {
                bag += N/5;
                break;
            } else if (N<3) {
                bag = -1;
                break;
            }
            N -= 3;
            bag++;
        }
        System.out.println(bag);

    }
}

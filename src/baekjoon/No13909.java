package baekjoon;

import java.util.Scanner;

public class No13909 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        System.out.println((int) Math.sqrt(N));
    }
}

/*
* 2 -> 1 0
* 3 -> 1 0 0
* --------------------------------------
* 4 -> 1 0 0 1
* 5 -> 1 0 0 1 0
* 6 -> 1 0 0 1 0 0
* 7 -> 1 0 0 1 0 0 0
* 8 -> 1 0 0 1 0 0 0 0
* --------------------------------------
* 9 -> 1 0 0 1 0 0 0 0 1
*10 -> 1 0 0 1 0 0 0 0 1 0
*11 -> 1 0 0 1 0 0 0 0 1 0 0
*12 -> 1 0 0 1 0 0 0 0 1 0 0 0
*13 -> 1 0 0 1 0 0 0 0 1 0 0 0 0
*14 -> 1 0 0 1 0 0 0 0 1 0 0 0 0 0
*15 -> 1 0 0 1 0 0 0 0 1 0 0 0 0 0 0
* --------------------------------------
*16 -> 1 0 0 1 0 0 0 0 1 0 0 0 0 0 0 1
 */
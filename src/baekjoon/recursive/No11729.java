package baekjoon.recursive;

import java.util.Scanner;

public class No11729 {
    static int count = 0;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        hanoi(N, 1, 2, 3);
        System.out.println(count);
        System.out.println(sb.toString());
    }

    private static void hanoi(int N, int start, int other, int to) {
        count++;
        if(N == 1) {
            sb.append(start + " " + to).append("\n");
            return;
        }

        hanoi(N-1, start, to, other);

        sb.append(start + " " + to).append("\n");

        hanoi(N-1, other, start, to);
    }
}

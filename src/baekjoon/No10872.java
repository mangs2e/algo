package baekjoon;

import java.util.Scanner;

public class No10872 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();

        int result = factorial(num);
        System.out.println(result);
    }

    private static int factorial(int num) {
        if(num == 0) return 1;
        else if(num <= 1) return num;
        else return num * factorial(num - 1);
    }
}

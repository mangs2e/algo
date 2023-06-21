package baekjoon.brute_force;

import java.util.Scanner;

public class No1436 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int num = sc.nextInt();
        int count = 0;
        int i = 666;
        boolean flag;


        while(true) {
            String str = String.valueOf(i);
            flag = str.contains("666");
            int dup = 0;
            if(flag) {
                count++;
            }
            if(count == num) {
                System.out.println(i);
                break;
            }
            i++;
        }
    }
}

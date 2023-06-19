package baekjoon;

import java.util.Scanner;

public class No1085 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int x = sc.nextInt();
        int y = sc.nextInt();
        int w = sc.nextInt();
        int h = sc.nextInt();
        int rx = 0;
        int ry = 0;
        int result = 0;

        if((double)w/2 <= x) {
            rx = w - x;
        }else{
            rx = x;
        }
        if((double)h/2 <= y){
            ry = h - y;
        }else{
            ry = y;
        }

        result = Math.min(rx, ry);

        System.out.println(result);
    }
}

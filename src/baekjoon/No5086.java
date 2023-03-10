package baekjoon;

import java.util.Scanner;

public class No5086 {

   public static void main(String[] args) {
       // 1. 첫번째 숫자가 두번째 숫자의 약수
       // 2. 첫번째 숫자가 두 번째 숫자의 배수
       // 3. 약수와 배수
       // x, y -> y % x == 0 (1)
       // x, y -> x / y == 0 (2)
       Scanner in = new Scanner(System.in);
       int x;
       int y;

       while(true) {
           x = in.nextInt();
           y = in.nextInt();

           if(x == 0 && y == 0) {
               break;
           }
           if(y%x==0) {
               System.out.println("factor");
           }else if(x%y == 0) {
               System.out.println("multiple");
           }else{
               System.out.println("neither");
           }
       }

    }
}

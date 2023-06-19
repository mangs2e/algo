package baekjoon;

import java.util.Scanner;

public class No2231 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String N = sc.next();
        int num = Integer.parseInt(N);
        String[] str;
        boolean flag = false;
        int sum = 0;

        for(int i=0;i<num;i++) {
            String string = String.valueOf(i);
            str = new String[string.length()];
            for (int j = 0; j < string.length(); j++) {
                str[j] = string.substring(j,j+1);
                sum += Integer.parseInt(str[j]);
            }
            if (sum+i == num) {
                flag = true;
                System.out.println(i);
                break;
            }
            sum = 0;
        }
        if(!flag) {
            System.out.println("0");
        }
    }
}

package baekjoon;

import java.util.Scanner;

public class No8958 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int T = in.nextInt();
        String[] strArr=new String[T];

        for(int i=0;i<T;i++) {
            strArr[i]=in.next();
        }

        for(int i=0;i<T;i++) {
            int count=0;
            int sum=0;
            for (int j = 0; j < strArr[i].length(); j++) {
                if (strArr[i].charAt(j) == 'O') {
                    count++; //3
                    sum += count; //10
                } else count = 0;
            }
            System.out.println(sum);
        }

        }
    }


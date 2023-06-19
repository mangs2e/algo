package baekjoon;

import java.util.ArrayList;
import java.util.Scanner;

public class No3009 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int x4, y4;
        int[] x = new int[3];
        int[] y = new int[3];
        ArrayList<Integer> xArr = new ArrayList<>();
        ArrayList<Integer> yArr = new ArrayList<>();

        for(int i=0;i<3;i++) {
            x[i] = sc.nextInt();
            y[i] = sc.nextInt();
        }

        xArr.add(x[0]);
        yArr.add(y[0]);
        for(int i=1;i<=2;i++) {
            if(xArr.contains(x[i])) {
                xArr.remove((Integer) x[i]);
            }else{
                xArr.add(x[i]);
            }
            if(yArr.contains(y[i])) {
                yArr.remove((Integer) y[i]);
            }else{
                yArr.add(y[i]);
            }
        }
        x4 = xArr.get(0);
        y4 = yArr.get(0);

        System.out.println(x4+" "+y4);
    }
}

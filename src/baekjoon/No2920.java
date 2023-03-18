package baekjoon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class No2920 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        List<Integer> list3 = new ArrayList<>();

        for(int i=0;i<8;i++) {
            int n = in.nextInt();
            list.add(n);
            list2.add(n);
            list3.add(n);
        }
        Collections.sort(list2);
        Collections.sort(list3);
        Collections.reverse(list3);

        if(list.equals(list2)) {
            System.out.println("ascending");
        }else if(list.equals(list3)) {
            System.out.println("descending");
        }else{
            System.out.println("mixed");
        }



    }
}

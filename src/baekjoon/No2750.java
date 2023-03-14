package baekjoon;

import java.util.*;

public class No2750 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        List<Integer> list = new ArrayList<>();
        int N = in.nextInt();

        for(int i=0;i<N;i++) {
            int n = in.nextInt();
            list.add(n);
        }
        Collections.sort(list);
        for(Integer k:list) {
            System.out.println(k);
        }

    }
}

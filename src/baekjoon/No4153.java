package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class No4153 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> list = new ArrayList<>();

        while(true) {
            String str = br.readLine();
            StringTokenizer st = new StringTokenizer(str);
            if(str.equals("0 0 0")) break;

            for (int i = 0; i < 3; i++) {
                int num = Integer.parseInt(st.nextToken());
                list.add(num);
            }
            Collections.sort(list);
            int max = list.get(2);
            int min = list.get(0);

            if ((int) Math.pow(list.get(1), 2) + (int) Math.pow(min, 2) == (int) Math.pow(max, 2)) {
                System.out.println("right");
            } else System.out.println("wrong");
            list.clear();
        }
    }
}

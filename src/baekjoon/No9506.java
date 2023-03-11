package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class No9506 {
    public static void main(String[] args) throws Exception {
        //본인을 제외한 나머지 약수들의 합들이 본인과 같은 값이 나오면 완전수
        //if ( x % i == 0 ) x = (x/i)
        //12%1 12%2 6%3 2%4 -> 1 + 2 + 3 + 2

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List <Integer> list = new ArrayList<>();

        int x;
        int sum;

        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
//            list.add(x);
            sum = 0;

            if (x == -1) {
                br.close();
                break;
            }

            for (int i = 1; i < x; i++) {
                if (x % i == 0) {
//                        x = (x / i);
                    sum += i;
                    list.add(i);
                }
            }
            if (sum == x) {
                System.out.print(x + " = ");
                for (int j = 0; j <= list.size() - 1; j++) {
                    if ((list.size() - 1) != j) {
                        System.out.print(list.get(j) + " + ");
                    } else {
                        System.out.println(list.get(j));
                    }
                }

            } else {
                System.out.println(x + " is NOT perfect.");
            }
            list.clear();
        }

    }
}

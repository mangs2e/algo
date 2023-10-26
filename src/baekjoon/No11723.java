package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class No11723 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        Set<Integer> basic = new HashSet<>();
        Set<Integer> all = new HashSet<>();

        for (int i = 0; i < 20; i++) {
            all.add(i + 1);
        }

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String str = st.nextToken();

            if (str.equals("add")) {
                basic.add(Integer.parseInt(st.nextToken()));
            } else if (str.equals("remove")) {
                basic.remove(Integer.parseInt(st.nextToken()));
            } else if (str.equals("check")) {
                if (basic.contains(Integer.parseInt(st.nextToken()))) {
                    sb.append("1").append("\n");
                } else {
                    sb.append("0").append("\n");
                }
            } else if (str.equals("toggle")) {
                int num = Integer.parseInt(st.nextToken());
                if (basic.contains(num)) {
                    basic.remove(num);
                } else {
                    basic.add(num);
                }
            } else if (str.equals("all")) {
                basic.addAll(all);
            } else if (str.equals("empty")) {
                basic.clear();
            }
        }

        System.out.println(sb);
    }
}

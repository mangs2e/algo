package baekjoon.set_map;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class No9375 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int cloth = Integer.parseInt(br.readLine());
            int mul = 1;
            Map<String, Integer> cloths = new HashMap<>();

            if (cloth == 0) {
                sb.append("0").append("\n");
                continue;
            }

            for (int j = 0; j < cloth; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                st.nextToken();
                String clothKind = st.nextToken();

                if (!cloths.containsKey(clothKind)) {
                    cloths.put(clothKind, 1);
                } else cloths.put(clothKind, cloths.get(clothKind) + 1);
            }

                for (int k : cloths.values()) {
                    mul *= (k + 1);
                }
            sb.append(mul-1).append("\n");
        }
        System.out.println(sb);
    }
}

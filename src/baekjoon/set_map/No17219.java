package baekjoon.set_map;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class No17219 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        Map<String, String> siteMap = new HashMap<>();

        int site = Integer.parseInt(st.nextToken());
        int find = Integer.parseInt(st.nextToken());

        for (int i = 0; i < site; i++) {
            st = new StringTokenizer(br.readLine());
            siteMap.put(st.nextToken(), st.nextToken());
        }

        for (int i = 0; i < find; i++) {
            String str = br.readLine();

            sb.append(siteMap.get(str)).append("\n");
        }

        System.out.println(sb);
    }
}

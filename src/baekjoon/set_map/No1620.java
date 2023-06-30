package baekjoon.set_map;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class No1620 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Map<String, Integer> monster = new HashMap<>();
        List<String> num = new ArrayList<>();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int count = 1;

        for(int i=0;i<N;i++) {
            String name = br.readLine();
            monster.put(name, count++);
            num.add(name);
        }

        StringBuffer sb = new StringBuffer();
        for(int i=0;i<M;i++) {
            String keyword = br.readLine();

            if(!keywordIsInt(keyword)) {
                sb.append(monster.get(keyword)+"\n");
            } else {
                sb.append(num.get(Integer.parseInt(keyword)-1)+"\n");
            }
        }

        System.out.println(sb.toString());
    }

    private static boolean keywordIsInt(String keyword) {
        char ch = keyword.charAt(0);
        boolean flag = Character.isDigit(ch);
        return flag;
    }
}

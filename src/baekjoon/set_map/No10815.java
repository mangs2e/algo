package baekjoon.set_map;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class No10815 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        Set<Integer> card = new HashSet<>();
        st = new StringTokenizer(br.readLine());

        for(int i=0;i<N;i++) {
            card.add(Integer.parseInt(st.nextToken()));
        }

        int M = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int i=0;i<M;i++) {
            if(card.contains(Integer.parseInt(st.nextToken()))) {
                sb.append("1");
            }else{
                sb.append("0");
            }
            sb.append(" ");
        }

        System.out.print(sb.toString());
    }
}

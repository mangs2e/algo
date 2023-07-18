package baekjoon.set_map;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class No26069 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        Set<String> dancer = new HashSet<>();
        dancer.add("ChongChong");
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String A = st.nextToken();
            String B = st.nextToken();

            if(dancer.contains(A) || dancer.contains(B)) {
                dancer.add(A);
                dancer.add(B);
            }
        }
//        for(String set:dancer) {
//            System.out.println(set);
//        }
        System.out.println(dancer.size());
    }
}

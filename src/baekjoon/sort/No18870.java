package baekjoon.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class No18870 {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[] tmp = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) {
            int n = Integer.parseInt(st.nextToken());
            arr[i] = tmp[i] = n;
        }

        Arrays.sort(tmp);

        Map<Integer, Integer> ranking = new HashMap<>();
        int rank = 0;

        for(int key : tmp) {
            if(!ranking.containsKey(key)) {
                ranking.put(key, rank);
                rank++;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int result : arr) {
            int rankN = ranking.get(result);
            sb.append(rankN).append(" ");
        }

        System.out.println(sb.toString());

    }
}

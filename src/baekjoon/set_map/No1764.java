package baekjoon.set_map;

import java.io.*;
import java.util.*;

public class No1764 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Map<String, Integer> not_heard = new HashMap<>();
        Set<String> not_heard_seen = new TreeSet<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int count = 1;

        for(int i=0;i<N;i++) {
            not_heard.put(br.readLine(),count++);
        }

        for(int i = 0;i<M;i++) {
            String not_seen = br.readLine();
            if(not_heard.containsKey(not_seen)) {
                not_heard_seen.add(not_seen);
            }
        }

        bw.write(not_heard_seen.size()+"\n");
        for(String result : not_heard_seen) {
            bw.write(result+"\n");
        }

        bw.flush();
    }
}

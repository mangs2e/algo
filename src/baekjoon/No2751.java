package baekjoon;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class No2751 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        List<Integer> list = new ArrayList<>();

        int N = Integer.parseInt(br.readLine());

        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            list.add(a);
        }
        br.close();
        Collections.sort(list);

        for(Integer k:list) {
            bw.write(k+"\n");
        }
        bw.flush();
        bw.close();
    }
}

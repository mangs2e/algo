package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class No9063 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Math.abs(Integer.parseInt(br.readLine()));
        List<Integer> x = new ArrayList<>();
        List<Integer> y = new ArrayList<>();

        for(int i=0;i<N;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            x.add(Integer.parseInt(st.nextToken()));
            y.add(Integer.parseInt(st.nextToken()));
        }

        int xMax = Collections.max(x);
        int yMax = Collections.max(y);
        int xMin = Collections.min(x);
        int yMin = Collections.min(y);

        int result = (xMax - xMin) * (yMax - yMin);
        System.out.println(result);
    }
}

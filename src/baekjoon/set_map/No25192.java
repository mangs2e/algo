package baekjoon.set_map;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class No25192 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Set<String> id = new HashSet<>();
        int count = 0;

        int N = Integer.parseInt(br.readLine());

        for(int i=0;i<N;i++) {
            String name = br.readLine();
            if(name.equals("ENTER")) {
                id.clear();
                continue;
            }
            if(!id.contains(name)) {
                id.add(name);
                count++;
            }
        }
        System.out.println(count);
    }
}

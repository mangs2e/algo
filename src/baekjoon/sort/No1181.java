package baekjoon.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class No1181 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Integer> map = new TreeMap<>();

        int N = Integer.parseInt(br.readLine());
        for(int i=0;i<N;i++) {
            String str = br.readLine();
            map.put(str, str.length());
        }
        
        List<Map.Entry<String, Integer>> entryList = new LinkedList<>(map.entrySet());
        entryList.sort(Map.Entry.comparingByValue());

        for (Map.Entry<String, Integer> entry : entryList) {
            System.out.println(entry.getKey());
        }

    }
}

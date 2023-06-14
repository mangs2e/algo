package baekjoon.search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class No10816 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        Map<Integer, Integer> map = new TreeMap<>();

        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) {
            int key = Integer.parseInt(st.nextToken());
            if(!map.containsKey(key)) {
                map.put(key, 1);
            }else{
                map.put(key, map.get(key)+1);
            }
        }
//        for (Integer key : map.keySet()) {
//            System.out.println(key + ": " + map.get(key));
//        }
        StringBuilder sb = new StringBuilder();
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<M;i++) {
            int number = Integer.parseInt(st.nextToken());
            sb.append(getCount(number, map)+" ");
        }

        System.out.println(sb.toString());
    }

    private static int getCount(int number, Map<Integer, Integer> map) {
        if(map.containsKey(number))
            return map.get(number);
        return 0;
    }
}

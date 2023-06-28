package baekjoon.set_map;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class No7785 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        Comparator<String> comparator = Comparator.reverseOrder();
        Map<String, String> empMap = new TreeMap<>(comparator);

        int n = Integer.parseInt(br.readLine());

        for(int i=0;i<n;i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            String entrance = st.nextToken();

            if(entrance.equals("enter")) {
                empMap.put(name, entrance);
            }else{
                empMap.remove(name);
            }
        }

        StringBuilder sb = new StringBuilder();
        for(String result : empMap.keySet()) {
            sb.append(result).append("\n");
        }

        System.out.println(sb.toString());
    }
}

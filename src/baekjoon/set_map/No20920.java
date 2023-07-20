package baekjoon.set_map;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class No20920 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        Map<String, Integer> wordMap = new HashMap<>();
        List<String> sorted = new ArrayList<>();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            String word = br.readLine();

            if(word.length() >= M) {
                wordMap.put(word, wordMap.getOrDefault(word, 0) + 1);
            }
        }

        while(!wordMap.isEmpty()) {
            int maxValue = 0;

            for (int key : wordMap.values()) {
                maxValue = Math.max(maxValue, key);
            }
            for (Map.Entry<String, Integer> map : wordMap.entrySet()) {
                if (map.getValue() == maxValue) {
                    sorted.add(map.getKey());
                }
            }

            if (sorted.size() != 1) {
                Collections.sort(sorted, new Comparator<String>() {
                    @Override
                    public int compare(String o1, String o2) {
                        if (o1.length() != o2.length()) {
                            return Integer.compare(o2.length(), o1.length());
                        } else {
                            return o1.compareTo(o2);
                        }
                    }
                });
            }
            for (String list : sorted) {
                sb.append(list).append("\n");
                wordMap.remove(list);
            }
            sorted.clear();
        }

        System.out.println(sb.toString());

    }
}

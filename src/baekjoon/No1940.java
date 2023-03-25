package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class No1940 {
    public static void main(String[] args) throws Exception {
        //재료값들을 받아서 정렬하고 1. + > M - end-- / 2. + < M - start++ / 3. + = M - count++ start++ end--
        int N; // 재료 갯수
        int M; // 비교할 합계
        List<Integer> list = new ArrayList<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(list);
//        for(Integer k:arr) {
//            System.out.print(k+" ");
//        }
//        list.forEach(i -> System.out.print(i+" "));
//        System.out.println();

        int start = 0;
        int end = list.size()-1;
        int count = 0;

        while(end>start) {
            if(list.get(start)+list.get(end) < M) {
                start++;
            }else if(list.get(start)+list.get(end) > M){
                end--;
            }else if(list.get(start)+list.get(end) == M) {
                count++;
                start++;
                end--;
            }
        }
        System.out.println(count);
        br.close();
    }
}
package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class No1427 {
    public static void main(String[] args) throws Exception{
        //선택 정렬 이용!
        //int N : 정렬할
        //List에 저장 -> Collections.max -> swap (제일 처음) -> index++

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> list = new ArrayList<>();

        char[] chars = br.readLine().toCharArray();

        for(int i=0;i<chars.length;i++) {
            list.add(chars[i]-'0');
        }

        int index = 0;
        while(index != list.size()-1) {
            int max = 0;
            int maxI = 0;
            boolean flag = false;
            for(int i=index;i<list.size();i++) {
                if(list.get(i) > max) {
                    max = list.get(i);
                    maxI = i;
                    flag = true;
                }
            }
            if(flag) {
                Collections.swap(list, index, maxI);
            }
            index++;
        }
        list.forEach(i -> System.out.print(i));

        br.close();

    }
}

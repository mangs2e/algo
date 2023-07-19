package baekjoon.set_map;

import java.util.*;

public class No2108 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> seq = new ArrayList<>();
        Map<Integer, Integer> fre = new HashMap<>();

        int N = sc.nextInt();
        int sum = 0;
        int maxValue = 0;
        int maxKey = 0;

        for(int i=0;i<N;i++) {
            int number = sc.nextInt();

            sum += number;
            seq.add(number);
            fre.put(number, fre.getOrDefault(number,0) + 1);
        }
        Collections.sort(seq);
        int midN = seq.get(N/2);
        int minus = seq.get(N-1) - seq.get(0);

        for(int key : fre.values()) {
            maxValue = Math.max(maxValue, key);
        }

        seq.clear(); //빈도수가 같은 경우 두번째로 작은 값을 출력하기 위해 리스트 재사용
        for(int key : fre.keySet()) {
            if(fre.get(key) == maxValue) {
                seq.add(key);
            }
        }
        Collections.sort(seq); //빈도수가 같은 값들만 리스트 저장후 정렬

        if(seq.size() == 1) { //하나의 값만 입력받았을 수도 있으므로
            maxKey = seq.get(0);
        } else {
            maxKey = seq.get(1);
        }


        System.out.println(Math.round(((double) sum / N)));
        System.out.println(midN);
        System.out.println(maxKey);
        System.out.println(minus);
    }
}

package baekjoon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class No2587 {

    public static void main(String[] args) {

        // 값들을 입력받고 평균과 중앙값 구하기
        Scanner in = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();
        int score;
        int avg;
        int sum=0;
        int mid;

        for(int i=0;i<5;i++) {
            score=in.nextInt();
            list.add(score);
            sum += score;
        }
        Collections.sort(list);

        avg = sum / 5;
        mid = list.get(2);

        System.out.println(avg);
        System.out.println(mid);
    }
}

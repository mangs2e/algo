package baekjoon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class No25305 {

    public static void main(String[] args) {
        //N : 응시자수, k : 상을 받는 사람 수
        //전체 점수를 받아서 정렬한 후, k명의 점수 출력 : 커트라인

        Scanner in = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();
        int N;
        int k;

        N = in.nextInt();
        k = in.nextInt();

        for(int i=0;i<N;i++) {
            int score = in.nextInt();
            list.add(score);
        }
        Collections.sort(list);
        Collections.reverse(list);

        System.out.println(list.get(k-1));
    }

}

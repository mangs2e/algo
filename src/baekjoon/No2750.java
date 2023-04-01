package baekjoon;

import java.util.*;

public class No2750 {

    public static void main(String[] args) {
        //버블정렬 이용하기!
        //for(N-1만큼 루프) if(i > i+1) swap
        //만약 1번째에서 swap이 한번도 안 이루어졌다면 종료
        //그렇지 않다며 루프 범위를 하나씩 줄여가면서 정렬

        Scanner in = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();
        int N = in.nextInt(); //N: 정렬할 수의 갯수

        //list에 값 입력 받기
        for(int i=0;i<N;i++) {
            list.add(in.nextInt());
        }

        //버블정렬 구현
        for(int i=0;i<N-1;i++) {
            int count = 0;
            for(int j=0;j<N-1-i;j++) {
                if(list.get(j) > list.get(j+1)) {
                    Collections.swap(list,j,j+1);
                    count++;
                }
            }if(count == 0) break;
        }

        //결과 출력
        list.forEach(i -> System.out.println(i));

    }
}

package baekjoon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class No1978 {

    public static void main(String[] args){
        // 소수 구하기
        // 1과 본인을 뺀 나머지 수들로 나눴을 때 나머지가 한번도 0이 나오지 않는 수들이 소수
        // 테스트 케이스를 받고, 값들을 차례차례 받아서 for(int i=2;i<x;i++) if(x%i != 0) add

        Scanner in = new Scanner(System.in);
        List<Integer> list = new ArrayList<>(); // 소수들만 넣을 리스트
        int T; // 테스트 케이스
        int x; // 소수를 구할 값
        boolean flag; // true면 소수

        T = in.nextInt();

        for(int i=0;i<T;i++) {
            flag = false;
            x = in.nextInt();
            for(int j=1;j<x;j++) {  // j가 1이 아니고, 한번이라도 나머지가 0이 되면 소수가 아니므로 break;
                if(j!=1 && (x%j == 0)) {
                flag = true;
                break;
                }
            }
            if(!flag && x!=1) {
                list.add(x);
            }
        }
        System.out.println(list.size());
    }
}

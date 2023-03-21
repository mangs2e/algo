package baekjoon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class No9020 {

    public static void main(String[] args) {
        //골드바흐의 추측 : 2보다 큰 모든 짝수는 두 소수의 합으로 이루어져있다
        //소수를 먼저 구하기 -> 에르토스테네스의 체 : 1은 제외, 제일 작은 2를 소수로 채택 -> 2의 배수 모드 지우기,
        // 3을 소수 채택 -< 3의 배수 모두 지우기
        Scanner in = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();
        boolean[] flag = new boolean[10001];


        for (boolean k : flag) {
            k = true;
        }
        System.out.println(flag[10000]);

        for (int i = 2; i * i < flag.length; i++) {
            if (flag[i]) {
                for (int j = i * i; j <= flag.length; j += i) {
                    flag[j] = false;
                }
            }
//            if(flag[i]==false) {
//                list.add(i);
//            }
        }
        for (int i = 0; i < flag.length; i++) {
            if (flag[i] == true) list.add(i);
        }
//            solution(n,flag);

        int T = in.nextInt();

        for (int k = 0; k < T; k++) {  //T번 수행
            int n = in.nextInt();
            int n1 = 0;
            int n2 = 0;
            int gap = 10000;
            for (int i = 0; i <list.size(); i++) {
                if (list.get(i) > n) break; // 한 소수가 정수보다 크면 break
                for (int j = i; j < list.size(); j++) {
                    if (list.get(i) + list.get(j) > n) break; // 소수 합이 정수보다 크면 break
                    if (list.get(i) + list.get(j) == n &&  //소수의 합이 정수이고
                            list.get(j) - list.get(i) < gap) { //gap이 더 작으면
                        n1 = list.get(i);
                        n2 = list.get(j);
                        gap = n2 - n1;
                    }
                }
            }
            System.out.println(n1 + " " + n2);



        }
    }
}

//    public static void solution(int n,boolean[] flag) {
//        //소수구하기
////        int gap = 10000;
//
//        for(boolean k:flag) {
//            k=true;
//        }
//
//        //소수면 false;
//
//        for(int i=2;i*i<=n;i++) {
//            if(flag[i]) {
//                for(int j=i*i;j<=n;j+=i) {
//                    flag[j] = false;
//                }
//            }
////            if(flag[i]==false) {
////                list.add(i);
////            }
//        }
//
//        // 골드바흐 파티션 구하기
//        int n1=0;
//        int n2=0;
//        int min = 10000;
////        for(int i=0;i<list.size();i++) {
////            for(int j=0;j<list.size();j++) {
////                if(list.get(i)+list.get(j)==n) {
////                    int gap = list.get(i)-list.get(j);
////                    int min = 10000;
////                    if(gap<0) {
////                        gap *= (-1);
////                    }
////                    if(gap<min) {
////                        n1 = list.get(i);
////                        n2 = list.get(j);
////                        min = gap;
////                    }
////
////                }
////            }
////        }
//
//        for(int i=2;i<=n/2;i++) {
//            if(flag[i]&&flag[n-i]) {
//                int gap = Math.abs(n-2*i);
//                if(gap<min) {
//                    n1 = i;
//                    n2 = n-i;
//                    min = gap;
//                }
//            }
//        }
//
//        System.out.println(n1+" "+n2);
//
//    }



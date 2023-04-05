package baekjoon;

import java.util.Scanner;

public class No11399 {
    public static void main(String[] args) {
        //선택정렬과 구간합 사용
        //N : 사람 수
        //A[] : 값을 저장할 배열
        //S[] : 합배열
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int[] A = new int[N];
        int[] S = new int[N];

        for(int i=0;i<N;i++) {
            A[i] = in.nextInt();
        }

        for(int i = 1;i<N;i++) { //삽입정렬
            int index = i;
            int value = A[i];
            for(int j=i-1;j>=0;j--) {
                if(A[j] < A[i]) {
                    index = j+1;
                    break;
                }
                if(j == 0) {
                    index = 0;
                }
            }
            for(int j=i;j>index;j--) {
                A[j] = A[j-1];
            }
            A[index] = value;
        }

        S[0] = A[0]; //합배열 생성
        for(int i=1;i<N;i++) {
            S[i] = S[i - 1] + A[i];
        }

        int sum = 0; //합배열 총합
        for(int i=0;i<N;i++) {
            sum += S[i];
        }
        System.out.println(sum);
    }
}

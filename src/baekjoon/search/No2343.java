package baekjoon.search;

import java.util.Scanner;

public class No2343 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] A = new int[N];
        int end = 0;
        int start = 0;
        for(int i=0;i<N;i++) {
            A[i] = sc.nextInt();
            end += A[i];
            if(start < A[i]) {
                start = A[i];
            }
        }

        while(start <= end) {
            int mid = (start+end) / 2;
            int sum = 0;
            int count = 0;

            for(int i=0;i<N;i++) {
                if (sum+A[i] > mid) {
                    count++;
                    sum = 0;
                } sum += A[i];
            }
            if(sum != 0) {
                count++;
            }
            if (count > M) {
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }
        System.out.println(start);
    }
}

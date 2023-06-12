package baekjoon.search;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class No1920 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int N, M; //데이터 개수와 찾아야 할 숫자 개수
        int[] arr, search;

        N = sc.nextInt();
        arr = new int[N];
        for(int i=0;i<N;i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);

        M = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<M;i++) {
            int target = sc.nextInt();

            boolean flag = false;
            int start = 0;
            int end = arr.length - 1;
            while(start <= end) {
                int mid = (start + end) / 2;
                if(arr[mid] > target) {
                    end = mid - 1;
                }else if(arr[mid] < target) {
                    start = mid + 1;
                }else {
                    flag = true;
                    break;
                }
            }
            if(flag) {
                sb.append("1\n");
            }else{
                sb.append("0\n");
            }
        }
        System.out.println(sb);
    }
}

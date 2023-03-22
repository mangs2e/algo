package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class No11659 {
    public static void main(String[] args) throws Exception{
        //배열의 개수 N, 테스트케이스 T
        //합배열 S[i] = S[i-1] + A[i]
        //구간합 (i~j) S[j] = S[i-1]
        Scanner st = new Scanner(System.in);

        int N = st.nextInt();
        int[] arr = new int[N+1];
        int[] S = new int[N+1];
        int T = st.nextInt();

        for (int i=1;i<=N;i++) {
            arr[i] = st.nextInt();
        }

        for (int i=1;i<=N;i++) {
            S[i] = S[i-1] + arr[i];
        }

        for(int k=1;k<=T;k++) {
            int i = st.nextInt();
            int j = st.nextInt();
            int result = S[j] - S[i-1];
            System.out.println(result);
        }

    }
}

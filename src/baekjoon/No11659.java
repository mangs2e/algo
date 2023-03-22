package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No11659 {
    public static void main(String[] args) throws Exception{
        //배열의 개수 N, 테스트케이스 T
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        //합배열 S[i] = S[i-1] + A[i]
        //구간합 (i~j) S[j] = S[i-1]

        int N = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());
        long[] S = new long[N+1];

        st = new StringTokenizer(br.readLine());
        for (int i=1;i<=N;i++) {
            S[i] = S[i-1] + Integer.parseInt(st.nextToken());
            //합배열 생성 - 굳이 배열을 2개 쓸 필요없음!
        }

        for(int k=1;k<=T;k++) {
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());
            System.out.println(S[j] - S[i-1]);
        }

        br.close();

    }
}

package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No11660 {
    public static void main(String[] args) throws Exception{
        // N x N -> 배열의 크기, M -> 테스트 케이스
        // 배열의 크기에 따라 들어갈 값 받아오기
        // for문 1~N번
        // 2차원 합배열 D[i][j] = D[i][j-1] + D[i-1][j] - D[i-1][j-1]+A[i][j]
        // for문 M번 구간 범위 값 받아오기 -> D[X2-Y2] - D[X1-1][Y2] - D[X2][Y1-1] + D[X1-1][Y-1]

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] A = new int[N+1][N+1];

        for(int i=1;i<=N;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=1;j<=N;j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //합배열 생성
        int[][] D = new int[N+1][N+1];
        for(int i=1;i<=N;i++) {
            for(int j=1;j<=N;j++) {
                D[i][j] = D[i-1][j] + D[i][j-1] - D[i-1][j-1] + A[i][j];
            }
        }

        //합배열 제대로 생성됐는지 확인
        for(int i=1;i<=N;i++) {
            for(int j=1;j<=N;j++) {
                System.out.print(D[i][j]+" ");
            }
            System.out.println();
        }

        //구간합 구하기
        for(int i=0;i<M;i++) {
            int result = 0;
            st = new StringTokenizer(br.readLine());
            int a1 = Integer.parseInt(st.nextToken());
            int b1 = Integer.parseInt(st.nextToken());
            int a2 = Integer.parseInt(st.nextToken());
            int b2 = Integer.parseInt(st.nextToken());
            result = D[a2][b2] - D[a1-1][b2] - D[a2][b1-1] + D[a1-1][b1-1];
            System.out.println(result);
        }

        br.close();


    }
}

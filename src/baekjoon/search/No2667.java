package baekjoon.search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//단지번호 붙이기
public class No2667 {
    //상하좌우 탐색 위한 배열
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;


        int N = Integer.parseInt(br.readLine());
        int[][]A = new int[N][N];
        boolean[][] visited = new boolean[N][N]; //방문 여부

        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            String line = st.nextToken();
            for(int j=0;j<N;j++) {
                A[i][j] = Integer.parseInt(line.substring(j, j+1));
            }
        }
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (A[i][j] != 0 && !visited[i][j]) {
                    result.add(dfs(A,visited, i, j));
                }
            }
        }

        Collections.sort(result);
        System.out.println(result.size());
        for (int r : result) {
            System.out.println(r);
        }
    }

    static int dfs(int[][] A, boolean[][] visited, int i, int j) {
        int count = 0;
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[] {i, j});
        visited[i][j] = true;

        while(!stack.isEmpty()) {
            int[] now = stack.pop();
            int x = now[0];
            int y = now[1];

            if (x < 0 || x >= A.length || y < 0 || y >= A[0].length || A[x][y] == 0) {
                continue;
            }
            A[x][y] = 0; // 방문한 집은 0으로 초기화
            count++;

            for(int k=0;k<4;k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];
                if(nx >= 0 && nx < A.length && ny >= 0 && ny < A[0].length && A[nx][ny] != 0 && !visited[nx][ny]) {
                    stack.push(new int[]{nx, ny});
                    visited[nx][ny] = true;
                }
            }
        }
        return count;
    }
}

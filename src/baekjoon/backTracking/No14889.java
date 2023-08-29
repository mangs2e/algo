package baekjoon.backTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No14889 {

    static int ability[][];
    static boolean visit[];
    static int min = Integer.MAX_VALUE;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        ability = new int[N][N];
        visit = new boolean[N];
//        int groupNum = N / 2;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                ability[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        groupAbility(0, 0);
        System.out.println(min);

    }

    private static void groupAbility(int index, int groupNum) {
        if(groupNum == N / 2) {
            abilityDiff();
            return;
        } else {
            for (int i = index; i < N; i++) {
                if (!visit[i]) {
                    visit[i] = true;
                    groupAbility(i + 1, groupNum + 1);
                    visit[i] = false;
                }
            }
        }
    }

    private static void abilityDiff() {
        int groupStart = 0;
        int groupLink = 0;

        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                if(visit[i] && visit[j]) {
                    groupStart += ability[i][j];
                    groupStart += ability[j][i];
                } else if(!visit[i] && !visit[j]) {
                    groupLink += ability[i][j];
                    groupLink += ability[j][i];
                }
            }
        }

        int result = Math.abs(groupLink - groupStart);

        if (result == 0) {
            System.out.println(result);
            System.exit(0);
        }

        min = Math.min(result, min);
    }

}

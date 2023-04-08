package baekjoon;

import java.io.*;

public class No2751 {
    static int[] A; //정렬할 배열
    static int[] tmp; //정렬할 때 사용할 임시배열

    public static void main(String[] args) throws IOException {
        //병합정렬
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N;  //정렬할 수 개수

        N = Integer.parseInt(br.readLine());
        A = new int[N + 1];
        tmp = new int[N + 1];

        for(int i=1;i<=N;i++) {
            A[i] = Integer.parseInt(br.readLine());
        }
        //병합 정렬
        mergeSort(1, N);

        for(int i=1;i<=N;i++) {
            bw.write(A[i]+"\n");
        }
        bw.flush();
        bw.close();
    }

    private static void mergeSort(int start, int end) {
        if(end - start < 1) {
            return;
        }
        int m = start + (end - start) / 2;
        //재귀함수
        mergeSort(start, m);
        mergeSort(m+1, end);

        for(int i=start;i<=end;i++) {
            tmp[i] = A[i];
        }

        int k = start;
        int index1 = start;
        int index2 = m+1;
        //두 그룹을 병합하는 로직
        while (index1 <= m && index2 <= end) {
            if(tmp[index1] > tmp[index2]) {
                A[k] = tmp[index2];
                k++;
                index2++;
            }else{
                A[k] = tmp[index1];
                k++;
                index1++;
            }
        }
        //남아있는 데이터 정리
        while(index1 <= m) {
            A[k] = tmp[index1];
            k++;
            index1++;
        }
        while(index2 <= end) {
            A[k] = tmp[index2];
            k++;
            index2++;
        }
    }
}

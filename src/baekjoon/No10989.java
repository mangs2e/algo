package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class No10989 {
    public static void main(String[] args) throws Exception{
        //기수정렬
        //일의 자릿수를 기준으로 큐에 삽입, 큐에서 순서대로 pop한 결과를 저장
        //십의 자릿수를 기준으로 큐에 삽입하고 정렬, 큐에서 순서대로 pop한 결과를 저장
        //백의 자릿수도 마찬가지 ...
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N; //정렬할 수의 갯수
        int[] A; //정렬할 배열

        N = Integer.parseInt(br.readLine());
        A = new int[N];

        for(int i=0;i<N;i++) {
            A[i] = Integer.parseInt(br.readLine());
        }
        br.close();

        radixSort(A, 5);

        for(int i = 0;i<A.length;i++) {
            bw.write(A[i]+"\n");
        }
        bw.flush();
        bw.close();

    }

    //기수 정렬 함수
    private static void radixSort(int[] A, int max_size) {
        int[] bucket; //현재 자릿수들의 분포를 합 배열 형태로 알려줌
        int[] output = new int[A.length]; //임시 정렬을 위한 배열
        int jarisu = 1; //현재 자릿수를 표현하는 수
        int count = 0;

        while(count != max_size) { //최대 자릿수만큼 반복
            bucket = new int[10];
            for(int i=0;i<A.length;i++) {
                bucket[(A[i]/jarisu)%10]++; //일의 자리부터 시작
            }
            for(int i=1;i<10;i++) { //합배열을 이용해 index계산
                bucket[i] += bucket[i - 1];
            }
            for(int i = A.length-1;i>=0;i--) { //현재 자릿수를 기준으로 정렬
                output[bucket[(A[i]/jarisu)%10]-1] = A[i];
                bucket[(A[i]/jarisu)%10]--;
            }
            for(int i=0;i<A.length;i++){
                A[i] = output[i];
            }
            jarisu = jarisu*10;
            count++;
        }
    }
}

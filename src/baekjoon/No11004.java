package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class No11004 {
    public static void main(String[] args) throws Exception{
        //퀵 정렬 이용하기
        //pivot == K 종료 , pivot > K pivot-1만 정렬 , pivot < K pivot+1만 정렬
        //배열이 리스트보다 메모리양이 더 적음!

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
//        List<Integer> list = new ArrayList<>();

        int N; // 숫자의 갯수
        int K; // K번째 수

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        int[] A = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) {
//            list.add(Integer.parseInt(st.nextToken()));
            A[i] = Integer.parseInt(st.nextToken());
        }

//        quickSort(list, 0, N - 1, K - 1); //list, 시작, 종료, K
        quickSort(A, 0, N - 1, K - 1); //list, 시작, 종료, K
//        System.out.println(list.get(K-1));
        System.out.println(A[K-1]);

    }

//    private static void quickSort(List<Integer> list, int start, int end, int K) {
    private static void quickSort(int[] A, int start, int end, int K) {
        if(start < end) {
//            int pivot = partition(list, start, end); //피벗 정하기
            int pivot = partition(A, start, end); //피벗 정하기
            if(pivot == K) { //K값과 같으면 종료
                return;
            } else if(pivot > K) { //K가 pivot보다 크면 왼쪽 그룹만 정렬
//                quickSort(list,start,end-1,K);
                quickSort(A,start,pivot-1,K);
            } else {
//                quickSort(list, pivot+1, end, K); //K가 pivot보다 작으면 오른쪽 그룹만 정렬
                quickSort(A, pivot+1, end, K); //K가 pivot보다 작으면 오른쪽 그룹만 정렬
            }
        }

    }

//    private static int partition(List<Integer> list, int start, int end) {
    private static int partition(int[] A, int start, int end) {
        if(start+1 == end) {
//            if(list.get(start) > list.get(end)) {
            if(A[start] > A[end]) {
//                Collections.swap(list, start, end);
                swap(A, start, end);
                return end;
            }
        }
        int M = (start + end) / 2;
//        Collections.swap(list, start, M); //중앙값을 제일 처음으로 보내기(정렬을 좀 더 편하게 하기 위해)
        swap(A, start, M); //중앙값을 제일 처음으로 보내기(정렬을 좀 더 편하게 하기 위해)
        int pivot = A[start];
//        int pivot = list.get(start);

        int i = start+1;
        int j = end;

        while(i <= j) {
            while (pivot < A[j] && j > 0) { //피벗보다 작은 수가 나올 때까지 j--
//            while (pivot < list.get(j) && j > 0) { //피벗보다 작은 수가 나올 때까지 j--
                j--;
            }
            while (pivot > A[i] && i < A.length - 1) { //피벗보다 큰 수가 나올 때까지 i++
//            while (pivot > list.get(i) && i < list.size() - 1) { //피벗보다 큰 수가 나올 때까지 i++
                i++;
            }
            if(i <= j) {
//                Collections.swap(list, i++, j--);
                swap(A, i++, j--);
            }
        }
        //i == j면 피벗 값을 양쪽으로 분리한 가운데에 오도록 설정
//        list.set(start, list.get(j));
//        list.set(j, pivot);
        A[start] = A[j];
        A[j] = pivot;
        return j;
    }

    private static void swap(int[] A, int i, int j) {
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }
}

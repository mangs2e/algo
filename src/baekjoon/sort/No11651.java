package baekjoon.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No11651 {
    private static void mergeSort(int[][] arr) {
        int[][] tmp = new int[arr.length][2];
        mergeSort(arr, tmp, 0, arr.length-1);
    }

    private static void mergeSort(int[][] arr, int[][] tmp, int start, int end) {
        if(start<end) {
            int mid = (start+end) / 2;
            mergeSort(arr, tmp, start, mid);
            mergeSort(arr, tmp, mid+1, end);
            merge(arr, tmp, start, mid, end);
        }
    }

    private static void merge(int[][] arr, int[][] tmp, int start, int mid, int end) {
        for(int i=start;i<=end;i++) {
            tmp[i] = arr[i].clone();
        }
        int part1 = start;
        int part2 = mid+1;
        int index = start;

        while(part1<=mid && part2<=end) {
            if(compare(arr[part1], arr[part2]) <= 0) {
                tmp[index] = arr[part1];
                part1++;
            }else{
                tmp[index] = arr[part2];
                part2++;
            }
            index++;
        }
        while(part1<=mid) {
            tmp[index] = arr[part1];
            index++;
            part1++;
        }
        while(part2<=end) {
            tmp[index] = arr[part2];
            index++;
            part2++;
        }
        for (int i = start; i <= end; i++) {
            arr[i] = tmp[i].clone(); // 병합된 배열 복사
        }
    }

    private static int compare(int[] point1, int[]point2) {
        if(point1[0]!=point2[0]) {
            return Integer.compare(point1[0], point2[0]);
        }else{
            return Integer.compare(point1[1], point2[1]);
        }
    }

    private static void printArray(int[][] arr) {
        for(int[] point : arr) {
            System.out.println(point[1] + " "+ point[0]);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][2];
        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][1] = Integer.parseInt(st.nextToken());
            arr[i][0] = Integer.parseInt(st.nextToken());
        }
        mergeSort(arr);
        printArray(arr);

    }
}

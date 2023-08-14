package baekjoon.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No24060 {
    static int[] A;
    static int[] tmp;
    static int count;
    static int k;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        A = new int[N];
        tmp = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        mergeSort(0, N-1);

        if(k > count) {
            System.out.println("-1");
        }
    }

    private static void mergeSort(int start, int end) {
        int mid;
        if (start < end) {
            mid = (start + end) / 2;
            mergeSort(start, mid);
            mergeSort(mid + 1, end);
            merge(start, mid, end);
        }
    }

    private static void merge(int start, int mid, int end) {
        int part1 = start;
        int part2 = mid + 1;
        int index = 0;

        while(part1 <= mid && part2 <= end) {
            if(A[part1] <= A[part2]) {
                tmp[index++] = A[part1++];
            }else{
                tmp[index++] = A[part2++];
            }
        }

        while (part1 <= mid) {
            tmp[index++] = A[part1++];
        }
        while (part2 <= end) {
            tmp[index++] = A[part2++];
        }

        part1 = start;
        index = 0;
        while(part1 <= end) {
            A[part1++] = tmp[index++];
            count++;
            if(count == k) {
                System.out.println(A[part1 - 1]);
                System.exit(0);
            }
        }
    }
}

package baekjoon.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class No18870 {

    private static int[] mergeSort(int[] arr) {
        int[] tmp = new int[arr.length];
        mergeSort(arr, tmp, 0, arr.length-1);

        return arr;
    }

    private static int[] mergeSort(int[] arr, int[] tmp, int start, int end) {
        if(start<end) {
            int mid = (start+end) / 2;
            mergeSort(arr,tmp,start,mid);
            mergeSort(arr, tmp, mid+1, end);
            merge(arr, tmp, start, mid, end);
        }

        return arr;
    }

    private static int[] merge(int[] arr, int[] tmp, int start, int mid, int end) {
        for(int i=start;i<=end;i++) {
            tmp[i] = arr[i];
        }
        int part1 = start;
        int part2 = mid + 1;
        int index = start;
        while(part1 <= mid && part2 <= end) {
            if(tmp[part1] <= tmp[part2]) {
                arr[index] = tmp[part1];
                part1++;
            }else{
                arr[index] = tmp[part2];
                part2++;
            }
            index++;
        }
        for(int i=0;i<=mid-part1;i++) {
            arr[index + i] = tmp[part1 + i];
        }

        return arr;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[] tmp;

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        tmp = arr.clone();
        tmp = mergeSort(tmp);

        Map<Integer, Integer> ranking = new HashMap<>();
        int rank = 0;
        for(int key : tmp) {
            if(!ranking.containsKey(key)) {
                ranking.put(key, rank);
                rank++;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int result : arr) {
            int rankN = ranking.get(result);
            sb.append(rankN).append(" ");
        }

        System.out.println(sb.toString());

    }
}


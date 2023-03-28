package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class No1253 {
    public static void main(String[] args) throws Exception{
        // N개의 값을 배열에 저장해서 정렬, 배열 i의 값 : K
        // N번 반복 {if start+end > K end--, else if start+end < K start++, else if start+end == K count++ break}

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        long[] arr = new long[N];

        //배열에 값 저장
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<arr.length;i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(arr);
//        long[] aux = Arrays.copyOf(arr,arr.length);
//        partition(arr, aux, 0, arr.length-1);
        //음수 정렬을 위한 병합정렬


//        for(int i=0;i<arr.length;i++) {
//            System.out.print(arr[i]+" ");
//        }
//        System.out.println();

        int count = 0;

        //투 포인터를 이용해서 코드 실행
        for(int i=0;i<arr.length;i++) {
            long K = arr[i];  // 합이 되어야할 값
            int start = 0;
            int end = arr.length-1;
            while(end > start) {
                if (arr[start] + arr[end] > K) {
                    end--;
                } else if (arr[start] + arr[end] < K) {
                    start++;
                } else if (arr[start] + arr[end] == K) {
                    // 자기자신이 포함되지 않은 다른 수여야 함
                    if(start == i) start++;
                    else if(end == i) end--;
                    else{
                        count++;
                        break;
                    }
                }
            }
        }
        System.out.println(count);
        br.close();

    }

    //여기서 틀린 부분이 있었기에 한번 더 확인해봐야 할듯함
    public static void merge(long[] arr, long[] aux, int low, int mid, int high)
    {
        int k = low;

        // 왼쪽 서브 어레이에서 음수 요소를 복사
        for (int i = low; i <= mid; i++)
        {
            if (arr[i] < 0) {
                aux[k++] = arr[i];
            }
        }

        // 오른쪽 서브 어레이에서 음수 요소를 복사
        for (int j = mid + 1; j <= high; j++)
        {
            if (arr[j] < 0) {
                aux[k++] = arr[j];
            }
        }

        // 왼쪽 서브 어레이에서 양수 요소를 복사
        for (int i = low; i <= mid; i++)
        {
            if (arr[i] >= 0) {
                aux[k++] = arr[i];
            }
        }

        // 오른쪽 서브 어레이에서 양수 요소를 복사
        for (int j = mid + 1; j <= high; j++)
        {
            if (arr[j] >= 0) {
                aux[k++] = arr[j];
            }
        }

        // 어레이된 순서를 반영하기 위해 원래 어레이로 다시 복사
        for (int i = low; i <= high; i++) {
            arr[i] = aux[i];
        }
    }

    // mergesort와 같은 루틴을 사용하여 양수와 음수를 분리
    public static void partition(long[] arr, long[] aux, int low, int high)
    {
        // 기본 케이스
        if (high <= low) {
            return;
        }

        // 중간점 찾기
        int mid = (low + ((high - low) >> 1));

        partition(arr, aux, low, mid);          // 왼쪽 절반 분할/병합
        partition(arr, aux, mid + 1, high);     // 오른쪽 절반 분할/병합

        merge(arr, aux, low, mid, high);
    }
}

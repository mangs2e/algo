package baekjoon.queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No1927 {
    static int N;
    static int[] minHeap;
    static int heapSize = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        minHeap = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            int num = Integer.parseInt(br.readLine());

            if (num == 0) {
                sb.append(remove()).append("\n");
            } else {
                heapSize++;
                insert(num);
            }
        }
        System.out.println(sb);
    }

    private static void insert(int num) {
        minHeap[heapSize] = num;

        //부모 노드와 자식 노드를 비교해서 더 작은 값을 부모 노드로 지정
        for (int j = heapSize; j >= 1; j /= 2) {
            if (minHeap[j / 2] > minHeap[j]) {
                int temp = minHeap[j / 2];
                minHeap[j / 2] = minHeap[j];
                minHeap[j] = temp;
            } else {
                break;
            }
        }
    }

    private static int remove() {
        //heap 사이즈가 0일 때 0반환
        if (heapSize == 0) {
            return 0;
        }
        //root 값을 빼고 마지막 노드의 값을 root로 지정
        int root = minHeap[1];
        minHeap[1] = minHeap[heapSize];
        minHeap[heapSize--] = 0;

        //root 노드와 자식 노드를 비교
        int current = 1;
        //heap 사이즈를 이용해서 자식 노드를 지정! 0으로 바꿔놓은 값을 자식노드라고 오해해서 값을 비교하는 일 없도록
        while (current * 2 <= heapSize) {
            int child;
            if (current * 2 + 1 > heapSize || minHeap[current * 2] < minHeap[current * 2 + 1]) {
                child = current * 2;
            } else {
                child = current * 2 + 1;
            }

            //root 노드가 더 작으면 유지, 자식 노드가 더 크면 root와 자식 노드 값을 변경
            if (minHeap[current] <= minHeap[child]) {
                break;
            }

            int temp = minHeap[current];
            minHeap[current] = minHeap[child];
            minHeap[child] = temp;

            current = child;
        }

        return root;
    }
}

package baekjoon.queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No11279 {
    static int[] maxHeap;
    static int heapSize = -1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        maxHeap = new int[N];

        for (int i = 0; i < N; i++) {
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
        maxHeap[heapSize] = num;

        for (int j = heapSize; j >= 1; j /= 2) {
            if (maxHeap[j / 2] < maxHeap[j]) {
                int temp = maxHeap[j / 2];
                maxHeap[j / 2] = maxHeap[j];
                maxHeap[j] = temp;
            } else {
                break;
            }
        }
    }

    private static int remove() {
        if (heapSize == -1) {
            return 0;
        }

        int root = maxHeap[0];
        maxHeap[0] = maxHeap[heapSize];
        maxHeap[heapSize--] = 0;

        int current = 0;
        while (current * 2 <= heapSize) {
            int child;
            if (current * 2 + 1 > heapSize || maxHeap[current * 2] > maxHeap[current * 2 + 1]) {
                child = current * 2;
            } else {
                child = current * 2 + 1;
            }
            if (maxHeap[current] >= maxHeap[child]) {
                break;
            }

            int temp = maxHeap[current];
            maxHeap[current] = maxHeap[child];
            maxHeap[child] = temp;

            current = child;
        }

        return root;
    }
}

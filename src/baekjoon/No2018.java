package baekjoon;

import java.util.Scanner;

public class No2018 {
    public static void main(String[] args) {
        //N : 자연수
        //start, end : 포인터 -> if sum == N end ++; sum += end / if sum > N start++; sum -= start / if sum < N sum = start+end end++;
        //sum, count: 1

        Scanner in = new Scanner(System.in);
        long N = in.nextLong();
        long start = 1;
        long end = 1;
        long sum = 1;
        int count = 1; // 자기자신은 무조건 포함하므로

        while(start != N) {
            if(sum == N) {
                end++;
                sum += end;
                count++;
            } else if (sum > N) {
                sum -= start;
                start++;
            } else if (sum < N) {
                end++;
                sum += end;
            }
        }
        System.out.println(count);
    }
}

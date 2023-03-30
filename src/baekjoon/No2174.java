package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class No2174 {
    public static void main(String[] args) throws Exception{
        //큐 알고리즘
        //큐에 넣을 N값 받아서 add
        //while(큐에 값이 하나일때까지) 맨위 poll, 다음 poll -> add, poll, poll -> add
        //마지막 남은 값 출력

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Queue<Integer> que = new LinkedList<>();

        int N = Integer.parseInt(br.readLine());

        for(int i=1;i<=N;i++) {
            que.add(i);
        }

        while(que.size()!=1) {
            que.poll();
            que.add(que.poll());
        }
        System.out.println(que.poll());

    }
}

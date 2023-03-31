package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class No11286 {
    public static void main(String[] args) throws Exception{
        //N: 연산의 개수(큐 개수) / x: 큐에 들어갈 값들
        //우선순위 큐 안에 절대값 기준 정렬, 같은 값이면 음수 우선 정렬
        //x == 0 -> 큐에서 절대값이 가장 작은것, 같은 값이면 음수 출력
        //x != 0 -> x를 큐에 저장

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //우선순위 큐 생성(절대값 기준 정렬 생성)
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>((o1, o2) -> {
            int firstN = Math.abs(o1);
            int sencondN = Math.abs(o2);
            if(firstN == sencondN) {
                return o1 > o2 ? 1 : -1; //절대값이 같으면 음수 우선 정렬
            }else {
                return firstN > sencondN? 1 : -1; //절대값을 기준으로 정렬
                //return firstN - secondN;
            }
        });
        int x;

        int N = Integer.parseInt(br.readLine());
        for(int i=0;i<N;i++) {
            x = Integer.parseInt(br.readLine());
            if(x != 0) {
                queue.add(x);
            }else{
                if(queue.isEmpty()) {
                    System.out.println("0");
                } else {
                    int result = queue.poll();
                    System.out.println(result);
                }
            }
        }
    }

}

package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class No1874 {
    public static void main(String[] args) throws Exception{
        // 스택 자료구조
        // int n : 자연수 갯수
        // int[] arr : 뽑고자하는 수 입력 받아서 저장
        // n만큼 반복해서 if(자연수 <= stack) while(자연수!=stack) push() (pop())
        // else if(자연수 > stack) pop() if(pop != stack) NO else

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer bf = new StringBuffer();
        StringTokenizer st;
        int n;
        int[] arr;
        Stack<Integer> stack = new Stack<>();

        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        //입력받은 값 배열에 저장
        for(int i=0;i<n;i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int num = 1; // 자연수 1로 설정
        boolean flag = false; // 마지막에 NO를 출력하면 + - 를 출력하지 않기 위해서 설정

        for(int i=0;i<n;i++) {
            if(num <= arr[i]) {
                while(num <= arr[i]) {
                    stack.push(num++);
                    bf.append("+\n");   // 버퍼를 이용해서 메모리를 줄이고 마지막에 한번에 처리하도록!
                }
                stack.pop();
                bf.append("-\n");
            }else if(num > arr[i]) {
                // 뽑아낸 pop이 배열의 값과 같지 않다면 NO를 출력하고 break;
                // 같다면 마찬가지로 - 저장
                int pop = stack.pop();
                if (pop != arr[i]) {
                    System.out.println("NO");
                    flag = true;
                    break;
                }else{
                    bf.append("-\n");
                }
            }
        }
        if(!flag) {
        System.out.println(bf.toString());}
        br.close();
    }
}

package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class No17298 {
    public static void main(String[] args) throws Exception{
        //스택 이용!
        //N : 수열의 크기, arr[] 값 비교할 배열
        //스택을 초기화하고 스택에는 인덱스를 넣음
        //스택이 비어있고, 스택 top과 >= arr[]이면 push
        //반대면 pop하고 오큰수를 현재 수열로 저장
        //스택에 남아있는 값은 오큰수가 없으므로 -1 저장

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw;
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N]; //수열 배열
        int[] ans = new int[N]; //정답 배열

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Stack<Integer> stack = new Stack<>();

        stack.push(0); // 처음 스택은 항상 비어있으므로 최초 값 push
        for(int i=1;i<N;i++) {
            //오큰수일 때 stack.pop한 수가 arr[i]와 같도록
            while(!stack.isEmpty() && arr[stack.peek()]<arr[i]) {
                ans[stack.pop()] = arr[i];
            }
            stack.push(i);
            //오큰수가 아니면 push
        }
        while(!stack.isEmpty()) {
            //스택이 비어있지 않다면 안에 있는 값은 오큰수가 없는 것
            ans[stack.pop()] = -1;
        }

        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(int i=0;i<N;i++) {
            bw.write(ans[i]+" ");
        }
        bw.write("\n");
        bw.flush();
        br.close();

    }
}

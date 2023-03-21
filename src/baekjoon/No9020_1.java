package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class No9020_1 {

    public static void main(String[] args) throws Exception {
        //골드바흐의 추측 : 2보다 큰 모든 짝수는 두 소수의 합으로 이루어져있다
        //소수를 먼저 구하기 -> 에르토스테네스의 체 : 1은 제외, 제일 작은 2를 소수로 채택 -> 2의 배수 모드 지우기,
        // 3을 소수 채택 -> 3의 배수 모두 지우기

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        List<Integer> list = new ArrayList<>();
        boolean[] flag = new boolean[10001];

//        for (int i = 0; i < flag.length; i++) {
//            flag[i] = true;
//        }
//        System.out.println(flag[4]);
        //소수면 false;
        flag[0]=flag[1]=true;
        for(int i=2; i*i<flag.length; i++){
            for(int j= i*i; j<flag.length; j+=i){ // i*i 이전값은 이미 배제된다.
                if(flag[j]==true) continue;
                else flag[j] = true;
            }
        }
        //소수만 담긴 새로운 리스트를 만든다
        for(int i=0; i<flag.length; i++){
            if(flag[i]==false) list.add(i);
        }

//        for (int i = 0; i < list.size(); i++) {
//            System.out.println(list.get(i));
//        }
//        System.out.println(list.size());

        int T = Integer.parseInt(in.readLine());

        for (int m = 0; m < T; m++) {
            st = new StringTokenizer(in.readLine());
            int n = Integer.parseInt(st.nextToken());
            int n1 = 0;
            int n2 = 0;
            int min = 10001;
            int gap = 0;
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i) > n) break;
                for (int j = i; j < list.size(); j++) {
                    if (list.get(i) + list.get(j) > n) break;
                    if (list.get(i) + list.get(j) == n) {
                        n1 = list.get(i);
                        n2 = list.get(j);
                        gap = n2 - n1;
                        if(gap<0) {
                        gap *= (-1);
                    }
                    if(gap<min) {
                        n1 = list.get(i);
                        n2 = list.get(j);
                        min = gap;
                    }
                    }
                }
            }
//            System.out.println(n1 + " " + n2);
            bw.write(n1+" "+n2+"\n");
            bw.flush();
        }
        in.close();
        bw.close();

    }
}



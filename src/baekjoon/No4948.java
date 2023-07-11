package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No4948 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while(true) {
            int num = Integer.parseInt(br.readLine());
            if(num==0) {
                break;
            }
            int count = 0;
            for(int i=num+1;i<=2*num;i++) {
                boolean isPrime = isPrime(i);
                if(isPrime) count++;
            }
            sb.append(count).append("\n");
        }

        System.out.println(sb.toString());
    }

    private static boolean isPrime(int num) {
        if (num < 2) {
            return false;
        }
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) return false;
        }return true;
    }
}

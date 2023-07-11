package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No1929 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuffer sb = new StringBuffer();

        long startN = Integer.parseInt(st.nextToken());
        long endN = Integer.parseInt(st.nextToken());

        for(long i=startN;i<=endN;i++) {
            boolean isPrime = isPrime(i);
            if(isPrime) sb.append(i).append("\n");
        }

        System.out.println(sb.toString());
    }

    private static boolean isPrime(long num) {
        if(num<2) return false;
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
}

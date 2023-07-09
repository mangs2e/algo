package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No2485 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        long[] interval = new long[T-1]; //가로수 간격
        long gcd; //최대공약수

        long preValue = Integer.parseInt(br.readLine());
        long sum = preValue;
        long last = 0;

        for(int i=0;i<interval.length;i++) {
            long currValue = Integer.parseInt(br.readLine());
            interval[i] = currValue - preValue;
            preValue = currValue;
            last = currValue;
        }

        gcd = interval[0];
        for(int i=1;i<interval.length;i++) {
            if(gcd!=interval[i]) {
                gcd = getGcd(gcd, interval[i]);
            }
        }

        int count = 1;
        while(true) {
            sum += gcd;
            count++;
            if(sum == last) break;
        }

        System.out.println(count - T);

    }

    private static long getGcd(long x, long y) {
        
        while (y != 0) {
            long temp = x % y;
            x = y;
            y = temp;
        }
        return x;
    }
}

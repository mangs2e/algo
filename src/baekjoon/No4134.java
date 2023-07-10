package baekjoon;

import java.math.BigInteger;
import java.util.Scanner;

public class No4134 {
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int T = sc.nextInt();
        for(int i=0;i<T;i++) {
            long num = sc.nextLong();
            BigInteger bigNum = new BigInteger(String.valueOf(num));
            sb.append(isPrime(bigNum)).append("\n");
        }

        System.out.println(sb.toString());
    }

    private static BigInteger isPrime(BigInteger num) {
        if(num.isProbablePrime(10)) { //지금 받은 매개변수가 소수면 num 리턴
            return num;
        }else{
            return num.nextProbablePrime(); //아니라면 다음 소수 리턴
        }
    }
}

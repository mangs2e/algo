package Algo_Ex.search;

public class No69_Sqrt {
    public static void main(String[] args) {
        //Math 함수를 쓰지 않고 Sqrt 값 구하는 문제
        System.out.println(mySqrt(2147483647));
    }

    public static int mySqrt(int x) {
        if (x == 0 || x == 1) {
            return x;
        }
        int start = 1;
        int end = x;
        int mid = -1;

        while (start <= end) {
            mid = start + (start + end) / 2;
            if (mid * mid == x) {
                return mid;
            }
            if ((long) mid * mid > (long) x) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return Math.round(end);
    }
}

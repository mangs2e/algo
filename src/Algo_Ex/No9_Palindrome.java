package Algo_Ex;

public class No9_Palindrome {
    public static void main(String[] args) {
        System.out.println(isPalindrome(10));
    }

    //내가 만든 코드!
    public static boolean isPalindrome(int x) {
        String str = String.valueOf(x);
        int size = str.length();
        char[] ch = str.toCharArray();

        for (int i = 0; i < size / 2; i++) {
            if (ch[i] != ch[size - 1 - i]) {
                return false;
            }
        }
        return true;
    }

    //Approach 1: Reversing the Entire Number
    public boolean isPalindrome1(int x) {
        //음수일 경우는 무조건 false일 수밖에 없음
        if (x < 0) {
            return false;
        }

        //입력받은 x의 값을 반대로 돌리는 작업! 123 -> 321
        long reversed = 0;
        long temp = x;

        while (temp != 0) {
            int digit = (int) temp % 10;
            reversed = reversed * 10 + digit;
            temp /= 10;
        }

        return (x == reversed);
    }

    //Approach 2: Reversing Half of the Number
    public boolean isPalindrome2(int x) {
        if (x < 0) {
            return false;
        }

        //글자수대로 전체 탐색하지 않고 절반만 탐색
        //짝수 2442의 경우 절반으로 쪼개서 정상 : 24 == 역순 : 24므로 true
        //홀수 121의 경우 12 | 1 -> 12 / 10인 1 == 1이므로 true
        int reversed = 0;
        int original = x;

        while (original > reversed) {
            reversed = reversed * 10 + original % 10;
            original /= 10;
        }

        return (original == reversed) || (original == reversed / 10);
    }
}

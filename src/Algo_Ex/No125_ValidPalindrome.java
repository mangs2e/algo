package Algo_Ex;

public class No125_ValidPalindrome {
    public static void main(String[] args) {
        //입력받은 문자열에서 특수기호 띄어쓰기를 제외한 후 팰린드롬 문자열인지 확인
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(isPalindrome2(""));
    }

    //내가 푼 코드 - String, StringBuffer 메소드 사용
    public static boolean isPalindrome(String s) {
        if (s.equals("")) {
            return true;
        }
        String str = s.toLowerCase().replaceAll("[^0-9a-z]", "");

        StringBuffer sb = new StringBuffer(str);
        return str.equals(sb.reverse().toString());
    }

    //Character 객체 메소드 사용해서 풀이
    public static boolean isPalindrome2(String s) {
        int start = 0;
        int last = s.length() - 1;
        while (start <= last) {
            char currFirst = s.charAt(start);
            char currLast = s.charAt(last);

            if(!Character.isLetterOrDigit(currFirst)) {
                start++;
            } else if (!Character.isLetterOrDigit(currLast)) {
                last--;
            } else {
                if(Character.toLowerCase(currFirst) != Character.toLowerCase(currLast)) {
                    return false;
                }
                start++;
                last--;
            }
        }
        return true;
    }
}

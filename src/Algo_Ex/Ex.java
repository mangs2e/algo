package Algo_Ex;

import java.util.HashMap;
import java.util.Map;

public class Ex {
    public static void main(String[] args) {
        String ransomNote = "bg";
        String magazine = "bbbjagbddfgdiaigdadhcfcj";

        System.out.println(canConstruct(ransomNote, magazine));
        System.out.println(canConstructHashMap(ransomNote, magazine));
    }

    //첫번째 방법!
    public static boolean canConstruct(String ransomNote, String magazine) {

        for (int i = 0; i < ransomNote.length(); i++) {
            char ch = ransomNote.charAt(i);

            int matchingIdx = magazine.indexOf(ch);

            if (matchingIdx == -1) {
                return false;
            }

            magazine = magazine.substring(0, matchingIdx) + magazine.substring(matchingIdx + 1); //일치하는 알파벳 삭제!
        }
        return true;
    }

    //두번째 방법!
    public static boolean canConstructHashMap(String ransomNote, String magazine) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < magazine.length(); i++) {
            char ch = magazine.charAt(i);

            int currentCount = map.getOrDefault(ch, 0);
            map.put(ch, currentCount + 1);
        }

        for (int i = 0; i < ransomNote.length(); i++) {
            char ch = ransomNote.charAt(i);

            int currentCount = map.getOrDefault(ch, 0);
            if (currentCount == 0) {
                return false;
            }

            map.put(ch, currentCount - 1);
        }

        return true;
    }
}

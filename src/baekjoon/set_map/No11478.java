package baekjoon.set_map;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class No11478 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Set<String> alphabet = new HashSet<>();

        String word = sc.next();

        for(int i=0;i<word.length();i++) {
            for(int j=i+1;j<=word.length();j++) {
                alphabet.add(word.substring(i,j));
            }
        }

        System.out.println(alphabet.size());

//        for (String result:alphabet
//             ) {
//            System.out.print(result+" ");
//        }


    }
}

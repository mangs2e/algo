package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class No18110 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> decision = new ArrayList<>();

        int peopleNum = Integer.parseInt(br.readLine());

        for (int i = 0; i < peopleNum; i++) {
            decision.add(Integer.parseInt(br.readLine()));
        }

        if(peopleNum < 1) {
            System.out.println(0);
            System.exit(0);
        }

        Collections.sort(decision);

        int pointAve = (int) Math.round((peopleNum * 0.15));
        double sum = 0;
        double count = 0;

        for (int i = pointAve; i < decision.size() - pointAve; i++) {
            sum += decision.get(i);
            count++;
        }

        int difficulty = (int) Math.round((sum / count));
        System.out.println(difficulty);
    }
}

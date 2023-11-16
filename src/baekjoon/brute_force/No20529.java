package baekjoon.brute_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No20529 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        while (T --> 0) {
            int N = Integer.parseInt(br.readLine());

            int max = N > 32 ? 33 : N;

            StringTokenizer st = new StringTokenizer(br.readLine());

            String[] people = new String[max];

            for (int i = 0; i < max; i++) {
                people[i] = st.nextToken();
            }

            int minDistance = 12;
            for (int i = 0; i < max; i++) {
                for (int j = i + 1; j < max; j++) {
                    for (int k = j + 1; k < max; k++) {
                        minDistance = Math.min(brute(people[i], people[j], people[k]), minDistance);
                        if (minDistance == 0) {
                            break;
                        }
                    }
                }
            }

            System.out.println(minDistance);
        }
    }

    private static int brute(String person1, String person2, String person3) {
        int distance = 0;
        for (int i = 0; i < 4; i++) {
            distance += (person1.charAt(i) != person2.charAt(i) ? 1 : 0);
            distance += (person3.charAt(i) != person2.charAt(i) ? 1 : 0);
            distance += (person1.charAt(i) != person3.charAt(i) ? 1 : 0);
        }
        return distance;
    }
}

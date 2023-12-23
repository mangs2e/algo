package Algo_Ex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class No1496_PathCrossing {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String path = br.readLine();
        System.out.println(isPathCrossing(path));
    }
    public static boolean isPathCrossing(String path) {
        Map<Character, int[]> move = new HashMap<>();

        move.put('N', new int[]{0, 1});
        move.put('S', new int[]{0, -1});
        move.put('E', new int[]{1, 0});
        move.put('W', new int[]{-1, 0});

        Set<int[]> visited = new HashSet<>();
        visited.add(new int[]{0, 0});


        int x = 0; int y = 0;
        for (int i = 0; i < path.length(); i++) {
            char ch = path.charAt(i);
            int[] point = move.get(ch);
            x += point[0];
            y += point[1];

            for (int[] arr : visited) {
                if (Arrays.equals(arr, new int[]{x, y})) {
                    return true;
                }
            }
            visited.add(new int[]{x, y});
        }
        return false;
    }
}

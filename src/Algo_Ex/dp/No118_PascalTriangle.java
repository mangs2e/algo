package Algo_Ex.dp;

import java.util.ArrayList;
import java.util.List;

public class No118_PascalTriangle {
    public static void main(String[] args) {
        //List<List<>> 타입의 파스칼 삼각형 구현
        StringBuilder sb = new StringBuilder();
        List<List<Integer>> result = generate(1);
        List<List<Integer>> result2 = generateDP(5);
        for(List list : result) {
            sb.append("[");
            for(Object k : list) {
                sb.append(k).append(",");
            }
            sb.append("]");
        }
        System.out.println(sb);
    }

    //내가 짠 코드
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> pascal = new ArrayList<>();

        for (int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();
            row.add(1);
            if(i == 0) {
                pascal.add(row);
                continue;
            }
            for (int j = 1; j < i; j++) {
                row.add(pascal.get(i - 1).get(j - 1) + pascal.get(i - 1).get(j));
            }
            row.add(1);
            pascal.add(row);
        }
        return pascal;
    }

    //다이나믹 프로그래밍 사용
    public static List<List<Integer>> generateDP(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        if (numRows == 0) {
            return result;
        }

        if (numRows == 1) {
            List<Integer> firstRow = new ArrayList<>();
            firstRow.add(1);
            result.add(firstRow);
            return result;
        }

        result = generateDP(numRows - 1);
        List<Integer> prevRow = result.get(numRows - 2);
        List<Integer> currentRow = new ArrayList<>();
        currentRow.add(1);

        for (int i = 1; i < numRows - 1; i++) {
            currentRow.add(prevRow.get(i - 1) + prevRow.get(i));
        }

        currentRow.add(1);
        result.add(currentRow);

        return result;
    }
}

package Algo_Ex.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class No119_PascalTriangleII {
    public static void main(String[] args) {
        //파스칼 삼각형 중 특정 열 출력하는 문제
        List<Integer> result = getRow2(4);
        for (int k : result) {
            System.out.print(k + " ");
        }
    }

    //내가 짠 코드
    public static List<Integer> getRow(int rowIndex) {
        List<Integer> result = new ArrayList<>();
        if (rowIndex == 0) {
            result.add(1);
            return result;
        }

        int[][] pascal = new int[rowIndex + 1][rowIndex + 1];

        for(int i = 1; i <= rowIndex; i++) {
            pascal[i][0] = 1;
            pascal[i][i] = 1;
            for (int j = 1; j < i; j++) {
                pascal[i][j] = pascal[i - 1][j - 1] + pascal[i - 1][j];
            }
        }

        for (int k : pascal[rowIndex]) {
            result.add(k);
        }

        return result;
    }

    //일차원 배열로 간단하게 정리
    public static List<Integer> getRow2(int rowIndex) {
        Integer[] arr = new Integer[rowIndex + 1];
        Arrays.fill(arr, 0);
        arr[0] = 1;

        for (int i = 1; i <= rowIndex; i++) {
            for (int j = i; j > 0; j--) {
                arr[j] = arr[j - 1] + arr[j];
            }
        }

        return Arrays.asList(arr);
    }
}

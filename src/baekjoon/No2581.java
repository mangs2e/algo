package baekjoon;

import java.util.*;

public class No2581 {

    public static void main(String[] args) {

        // 입력받은 범위만큼 값을 배열에 저장
        // 배열에 있는 값들을 동일하게 for문 돌려서 소수 구하고
        // list에 저장.
        // forEach로 안에 값들 더하고 Collection.min 사용

        Scanner in = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();

        int start = in.nextInt();
        int end = in.nextInt();
        int[] arr = new int[end-start+1];
        boolean flag = false;
        int x;

        for(int i=0;i<arr.length;i++) {
            arr[i]=start++;
        }
        for(int k=0;k<arr.length;k++) {
            x = arr[k];
            flag = false;
            flag = isFlag(list, flag, x);
        }

        if(list.size() ==0) {
            System.out.println("-1");
        } else {
            int sum = 0;
            for (Integer li:list
            ) {
                sum += li;
            }
            System.out.println(sum);
            System.out.println(Collections.min(list));
        }
    }

    public static boolean isFlag(List<Integer> list, boolean flag, int x) {
        for (int j=1; j<x; j++) {
            if (j != 1 && (x % j == 0)) {
                flag = true;
                break;
            }
        }
        if (!flag && x != 1) {
            list.add(x);
        }
        return flag;
    }
}

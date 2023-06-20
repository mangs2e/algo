package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No19532 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[6];

        for(int i=0;i<arr.length;i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int x, y;

        if(arr[0] == arr[3]) {
            y = (arr[2] - arr[5]) / (arr[1] - arr[4]);
            x = ((arr[2] * arr[4]) - (arr[1] * arr[5])) / ((arr[0] * arr[4]) - (arr[1] * arr[3]));
        }
        else if(arr[1] == arr[4]) {
            y = ((arr[2] * arr[3]) - (arr[0] * arr[5])) / ((arr[1] * arr[3]) - (arr[0] * arr[4]));
            x = (arr[2] - arr[5]) / (arr[0] - arr[3]);
        }
        else{
            y = ((arr[2] * arr[3]) - (arr[0] * arr[5])) / ((arr[1] * arr[3]) - (arr[0] * arr[4]));
            x = ((arr[2] * arr[4]) - (arr[1] * arr[5])) / ((arr[0] * arr[4]) - (arr[1] * arr[3]));
        }

        System.out.println(x+" "+y);
    }
}

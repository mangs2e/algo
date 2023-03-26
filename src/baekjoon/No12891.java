package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class No12891 {
    static long[] check;
    static int[] array;
    static int checkSecret;

    public static void main(String[] args) throws Exception{

        //S : 값을 받아와서 저장할 배열
        //array : 비밀번호를 체크할 배열
        //check : 현재 상태 배열 - S배열에 포인터를 지정해서 check와 대조(부분 문자열)
        //갯수를 비교하고 조합 확인 start++ end++ S배열에는 start였던 값 삭제, end배열 값 추가해서 비교

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        char[] S;
        int a;
        int b;

        st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken()); // 문자열 길이
        b = Integer.parseInt(st.nextToken()); // 부분 문자열 길이
        S = new char[a];
        check = new long[b];
        array = new int[4]; //checkarr
        checkSecret = 0; //몇개의 문자와 관련된 개수를 충족했는디 판단하는 변수

//        st = new StringTokenizer(br.readLine());
        S = br.readLine().toCharArray();
//        for(Character k:S) {
//            System.out.print(k+" ");
//        }

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<array.length;i++) {
            array[i] = Integer.parseInt(st.nextToken());
            if(array[i]==0) {
                checkSecret++;
            }
        }

        int start = 0;
        int end = b-1;

        check = new long[4]; //myarr
        //초기 세팅
        for(int i=0;i<b;i++) {
                Add(S[i]);
        }
        int result = 0;
        if(checkSecret==4) {
            result++;
        }
        //슬라이딩
        for(int i=b;i<a;i++) {
            int j = i-b;
            Add(S[i]);
            Remove(S[j]);
            if(checkSecret == 4) {
                result++;
            }
        }
        System.out.println(result);
        br.close();



    }
    public static void Add(char c){
        switch(c) {
            case 'A':
                check[0]++;
                if(check[0]==array[0]) checkSecret++;
                break;
            case 'C':
                check[1]++;
                if(check[1]==array[1]) checkSecret++;
                break;
            case 'G':
                check[2]++;
                if(check[2]==array[2]) checkSecret++;
                break;
            case 'T':
                check[3]++;
                if(check[3]==array[3]) checkSecret++;
                break;
        }
    }
    public static void Remove(char c) {//제거되는 문자
        switch(c) {
            case 'A':
                if(check[0]==array[0]) checkSecret--;
                check[0]--;
                break;
            case 'C':
                if(check[1]==array[1]) checkSecret--;
                check[1]--;
                break;
            case 'G':
                if(check[2]==array[2]) checkSecret--;
                check[2]--;
                break;
            case 'T':
                if(check[3]==array[3]) checkSecret--;
                check[3]--;
                break;
        }
    }
}

package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class No1377 {
    public static void main(String[] args) throws Exception {
        //안쪽 for문이 몇 번 수행됐는지 구하는 문제
        //정렬을 sort로 완료한 이후에 처음 인덱스 값과 정렬된 인덱스 값의 차이를 구해서
        //가장 큰수 + 1(swap을 한번도 수행하지 않은 루프) 을 한 수가 바로 안쪽 for문을 수행한 횟수 ()
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        mData[] A = new mData[N];

        //입력받은 배열의 value값과 그에 따른 index값 저장
        for(int i=0;i<N;i++) {
            A[i] = new mData(Integer.parseInt(br.readLine()),i);
        }
        //정렬 수행
        Arrays.sort(A);

        //mData에 저장해놓은 인덱스 값을 가지고와서 하나하나 차이 구하고 최댓값 설정
        int max = 0;
        for(int i=0;i<N;i++) {
            if(max < A[i].index - i) {
                max = A[i].index - i;
            }
        }
        System.out.println(max + 1);

        br.close();
    }

}
class mData implements Comparable<mData> {
    int value;
    int index;

    public mData(int value,int index) {
        super();
        this.value = value;
        this.index = index;
    }

    @Override
    public int compareTo(mData o) { //오름차순 정렬
        return this.value - o.value;
    }
}

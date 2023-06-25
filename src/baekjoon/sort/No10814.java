package baekjoon.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class No10814 {
    private static void mergeSort(ArrayList<String> memberList) {
        List<String> tmp = new ArrayList<>();
        mergeSort(memberList, tmp, 0, memberList.size()-1);

    }

    private static void mergeSort(ArrayList<String> memberList, List<String> tmp, int start, int end) {
        if(start<end) {
            int mid = (start+end) / 2;
            mergeSort(memberList, tmp, start, mid);
            mergeSort(memberList, tmp, mid+1, end);
            merge(memberList, tmp, start, mid, end);
        }
    }

    private static void merge(ArrayList<String> memberList, List<String> tmp, int start, int mid, int end) {
        for(int i=start;i<=end;i++) {
            tmp.add(memberList.get(i));
        }
        int part1 = start;
        int part2 = mid+1;
        int index = start;

        while(part1<=mid&&part2<=end) {
            String[] ageArr1 = tmp.get(part1-start).split(" ");
            String[] ageArr2 = tmp.get(part2-start).split(" ");
            int age1 = Integer.parseInt(ageArr1[0]);
            int age2 = Integer.parseInt(ageArr2[0]);
            if(age1<=age2) {
                memberList.set(index, tmp.get(part1-start));
                part1++;
            }else{
                memberList.set(index, tmp.get(part2-start));
                part2++;
            }
            index++;
        }
        for(int i=part1;i<=mid;i++) {
            memberList.set(index,tmp.get(i-start));
        }
        tmp.clear();
    }

    private static void printArray(ArrayList<String> memberList) {
        memberList.forEach(System.out::println);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        List<String> memberList = new ArrayList<>();
        int N = Integer.parseInt(br.readLine());
        for(int i=0;i<N;i++) {
            memberList.add(br.readLine());
        }

        mergeSort((ArrayList<String>) memberList);
        printArray((ArrayList<String>) memberList);
    }
}

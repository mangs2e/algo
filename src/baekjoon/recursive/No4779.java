package baekjoon.recursive;

import java.io.*;

public class No4779 {
    static char[] chars;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str;
        int N;

        while ((str = br.readLine()) != null) {
            N = Integer.parseInt(str);
            int num = (int) Math.pow(3, N);
            chars = new char[num];

            for (int i = 0; i < chars.length; i++) {
                chars[i] = '-';
            }

            canto(0, num);

            for (int i = 0; i < num; i++) {
                bw.write(chars[i]);
            }
            bw.write("\n");
            bw.flush();
        }
    }

    private static void canto(int start, int length) {
        if(length < 3) return ;

        for (int i = start + length / 3; i < start + length / 3 * 2; i++) {
            chars[i] = ' ';
        }

        canto(start, length / 3);
        canto(start + length / 3 * 2, length / 3);
    }
}

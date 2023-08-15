package baekjoon.recursive;

import java.io.*;

public class No2447 {
    static char[][] chars;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());
        chars = new char[num+1][num+1];

        star(1,1, num, false);

        for (int i = 1; i < chars.length; i++) {
            for (int j = 1; j < chars.length; j++) {
                bw.write(chars[i][j]);
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();
    }

    private static void star(int x, int y, int length, boolean blank) {
        if(blank) {
            for (int i = x; i < x + length; i++) {
                for (int j = y; j < y + length; j++) {
                    chars[i][j] = ' ';
                }
            }
            return;
        }

        if (length == 1) {
            chars[x][y] = '*';
            return;
        }

        int size = length / 3;
        int count = 0;
        for (int i = x; i < x + length; i+=size) {
            for (int j = y; j < y + length; j+=size) {
                count++;
                if(count == 5) {
                    star(i, j, size, true);
                }
                else {
                    star(i, j, size, false);
                }
            }
        }
    }
}

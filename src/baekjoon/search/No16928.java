package baekjoon.search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.Queue;

public class No16928 {
    public static Map<Integer, Integer> ladder = new HashMap<>();
    public static Map<Integer, Integer> snake = new HashMap<>();
    public static int[] board = new int[101];
    public static int[] visited = new int[101];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            ladder.put(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            snake.put(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        for (int i = 0; i < 100; i++) {
            board[i + 1] = i;
        }

        bfs(1);
        System.out.println(board[100]);
    }

    private static void bfs(int board_num) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(board_num);

        while (!queue.isEmpty()) {
            int num = queue.poll();

            if (visited[num] == 0) {
                visited[num] = 1;

                for (int i = 1; i <= 6; i++) {
                    int cur_board_num = num + i;
                    if (cur_board_num > 100) {
                        break;
                    }
                    if (ladder.containsKey(cur_board_num)) {
                        queue.offer(ladder.get(cur_board_num));
                        board[ladder.get(cur_board_num)] = Math.min(board[ladder.get(cur_board_num)], board[num] + 1);
                    } else if (snake.containsKey(cur_board_num)) {
                        queue.offer(snake.get(cur_board_num));
                        board[snake.get(cur_board_num)] = Math.min(board[snake.get(cur_board_num)], board[num] + 1);
                    } else {
                        queue.offer(cur_board_num);
                        board[cur_board_num] = Math.min(board[cur_board_num], board[num] + 1);
                    }
                }
            }
        }
    }
}

package sw.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class sw4615 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int T, N, M;
    static int[][] board;

    static int c, r, color;

    // up, down, left, right, up-left, up-right, down-left, down-right
    static int[] dc = { 1, -1, 0, 0, 1, 1, -1, -1 };
    static int[] dr = { 0, 0, -1, 1, -1, 1, -1, 1 };

    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            init();
            othello();

            int black = 0;
            int white = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (board[i][j] == 1) {
                        black++;
                    } else if (board[i][j] == 2) {
                        white++;
                    }
                }
            }
            System.out.println("#" + tc + " " + black + " " + white);
        }
    }

    static void init() {
        board = new int[N][N];

        board[N / 2][N / 2] = 2;
        board[N / 2 - 1][N / 2] = 1;
        board[N / 2][N / 2 - 1] = 1;
        board[N / 2 - 1][N / 2 - 1] = 2;
    }

    static void othello() throws IOException {
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            c = Integer.parseInt(st.nextToken()) - 1;
            r = Integer.parseInt(st.nextToken()) - 1;
            color = Integer.parseInt(st.nextToken());
            board[c][r] = color;

            for (int j = 0; j < 8; j++) {
                reverse(dc[j], dr[j]);
            }
        }
    }

    static void reverse(int dir_dc, int dir_dr) {
        ArrayList<int[]> stonesToFlip = new ArrayList<>();
        int nc = c + dir_dc;
        int nr = r + dir_dr;

        while (valid(nc, nr) && board[nc][nr] != 0 && board[nc][nr] != color) {
            stonesToFlip.add(new int[] { nc, nr });
            nc += dir_dc;
            nr += dir_dr;

        }

        if (valid(nc, nr) && board[nc][nr] == color) {
            if (!stonesToFlip.isEmpty()) {
                for (int[] pos : stonesToFlip) {
                    board[pos[0]][pos[1]] = color;
                }
            }
        }

    }

    static boolean valid(int nc, int nr) {
        return nc >= 0 && nc < N && nr >= 0 && nr < N;
    }
}
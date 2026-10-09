package sw.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class sw2806 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int T;
    static boolean[][] chess;
    static int count = 0;
    static int N;
    static int[] dx = {1, 1, -1, -1};
    static int[] dy = {1, -1, -1, 1};


    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine());
            count = 0;
            chess = new boolean[N][N];

            BTC(0, 0);

            System.out.println("#" + tc + " " + count);
        }
    }

    static void BTC(int start, int depth) {
        if (depth == N) {
            count++;
            return;
        }

        for (int i = 0; i < N; i++) {
            if (noQueen(start, i)) {
                chess[start][i] = true;
                BTC(start + 1, depth + 1);
                chess[start][i] = false;
            }
        }
    }

    static boolean noQueen(int x, int y) {
        for (int i = 0; i < N; i++) { // Check row and column
            if (chess[x][i] || chess[i][y]) {
                return false;
            }
        }

        for (int i = 1; i < N; i++) { // Start from 1 and move diagonally
            for (int j = 0; j < 4; j++) {
                int nextX = x + i * dx[j];
                int nextY = y + i * dy[j];
                if (valid(nextX, nextY) && chess[nextX][nextY]) {
                    return false;
                }
            }
        }
        return true;
    }

    static boolean valid(int x, int y) {
        return x >= 0 && y >= 0 && x < N && y < N;
    }
}

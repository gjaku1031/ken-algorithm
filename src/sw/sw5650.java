package sw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.lang.StringBuilder;

public class sw5650 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int T, N;

    // Direction: 0=up, 1=down, 2=left, 3=right
    static final int[] dr = {-1, 1, 0, 0};
    static final int[] dc = {0, 0, -1, 1};

    // Block (1-5) reflection table [block][direction] -> newDirection
    // Index 0 is unused
    static final int[][] REFLECT = {
            {0, 0, 0, 0},       // dummy
            {1, 3, 0, 2},       // block 1
            {3, 0, 1, 2},       // block 2
            {2, 0, 3, 1},       // block 3
            {1, 2, 3, 0},       // block 4
            {1, 0, 3, 2}        // block 5 (full reflection)
    };

    static int[][] board;   // (N+2) x (N+2), border is all 5
    static int[][] whR;     // Wormhole destination r
    static int[][] whC;     // Wormhole destination c

    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine().trim());
        StringBuilder sb = new StringBuilder(64 * T);

        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine().trim());

            // Initialize board and wormhole mapping
            board = new int[N + 2][N + 2];
            whR = new int[N + 2][N + 2];
            whC = new int[N + 2][N + 2];

            // Set border to block 5 (removes bounds checks)
            for (int i = 0; i < N + 2; i++) {
                board[0][i] = 5;
                board[N + 1][i] = 5;
                board[i][0] = 5;
                board[i][N + 1] = 5;
            }

            // Stores wormhole coordinates (two per pair)
            int[] w1r = new int[11], w1c = new int[11];
            int[] w2r = new int[11], w2c = new int[11];
            for (int i = 6; i <= 10; i++) {
                w1r[i] = w1c[i] = w2r[i] = w2c[i] = -1;
            }

            // Fill input board into the 1..N range
            for (int r = 1; r <= N; r++) {
                st = new StringTokenizer(br.readLine());
                for (int c = 1; c <= N; c++) {
                    int val = Integer.parseInt(st.nextToken());
                    board[r][c] = val;

                    if (val >= 6 && val <= 10) {
                        if (w1r[val] == -1) {
                            w1r[val] = r; w1c[val] = c;
                        } else {
                            w2r[val] = r; w2c[val] = c;
                        }
                    }
                }
            }

            // Build wormhole mapping: each wormhole cell jumps directly to its pair
            for (int v = 6; v <= 10; v++) {
                if (w1r[v] != -1 && w2r[v] != -1) {
                    int r1 = w1r[v], c1 = w1c[v];
                    int r2 = w2r[v], c2 = w2c[v];
                    whR[r1][c1] = r2; whC[r1][c1] = c2;
                    whR[r2][c2] = r1; whC[r2][c2] = c1;
                }
            }

            int answer = 0;

            // Simulate in 4 directions from every empty cell (0)
            for (int r = 1; r <= N; r++) {
                for (int c = 1; c <= N; c++) {
                    if (board[r][c] != 0) continue;
                    for (int d = 0; d < 4; d++) {
                        int score = simulate(r, c, d);
                        if (score > answer) answer = score;
                    }
                }
            }

            sb.append('#').append(tc).append(' ').append(answer).append('\n');
        }

        System.out.print(sb);
    }

    static int simulate(int sr, int sc, int sd) {
        int r = sr;
        int c = sc;
        int d = sd;
        int score = 0;

        while (true) {
            // Move forward one cell
            r += dr[d];
            c += dc[d];

            int cell = board[r][c];

            // Stop when returning to start or reaching a black hole (-1)
            if ((r == sr && c == sc) || cell == -1) {
                return score;
            }

            if (cell == 0) {
                // Empty cell: keep going
                continue;
            }

            if (1 <= cell && cell <= 5) {
                // Block reflection
                score++;
                d = REFLECT[cell][d];
                // Stay on the block cell; only the direction changes
                // Move in the new direction on the next iteration
            } else {
                // Wormhole (6-10): jump immediately to its pair
                int nr = whR[r][c];
                int nc = whC[r][c];
                r = nr;
                c = nc;
                // Keep direction
            }
        }
    }
}

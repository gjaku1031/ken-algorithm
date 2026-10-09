package sw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class sw2112 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int T;
    static int D, W, K;
    static int[][] film;

    static int best; // Minimum number of chemical injections

    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            D = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            film = new int[D + 1][W + 1];

            for (int i = 1; i <= D; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 1; j <= W; j++) {
                    film[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            if (isPass()) {
                best = 0;
            } else {
                best = K;
                dfs(1, 0);
            }
            System.out.println("#" + tc + " " + best);
        }
    }

    static void dfs(int row, int used) {
        if (used >= best) return;
        if (row > D) {
            if (isPass()) {
                best = Math.min(best, used);

            }
            return;
        }
        // 1) Leave row r as is
        dfs(row + 1, used);

        // Back up current row (for restoring values)
        int[] backup = film[row].clone();

        // 2) Set all of row r to 0
        for (int j = 1; j <= W; j++) film[row][j] = 0;
        dfs(row + 1, used + 1);
        // Restore
        for (int j = 1; j <= W; j++) film[row][j] = backup[j];

        // 3) Set all of row r to 1
        for (int j = 1; j <= W; j++) film[row][j] = 1;
        dfs(row + 1, used + 1);
        // Restore
        for (int j = 1; j <= W; j++) film[row][j] = backup[j];
    }

    static boolean isPass() {
        for (int w = 1; w <= W; w++) {
            if (!check(w)) return false;
        }
        return true;
    }

    static boolean check(int w) {
        if (K == 1) return true;
        int run = 1;
        int past = film[1][w];
        for (int i = 2; i <= D; i++) {
            if (film[i][w] == past) {
                run++;
            } else {
                run = 1;
                past = film[i][w];
            }
            if (run >= K) return true;
        }
        return false;
    }
}
/*
10
6 8 3
0 0 1 0 1 0 0 1
0 1 0 0 0 1 1 1
0 1 1 1 0 0 0 0
1 1 1 1 0 0 0 1
0 1 1 0 1 0 0 1
1 0 1 0 1 1 0 1
 */
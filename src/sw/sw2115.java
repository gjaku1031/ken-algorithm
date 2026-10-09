package sw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class sw2115 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int T;
    static int N, M, C;
    static int[][] map;
    static int[][] profit; // Max profit obtainable from the segment starting at (r,c)

    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());

            map = new int[N][N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            // Precompute max profit of the M-cell segment from each start point
            profit = new int[N][N];
            for (int r = 0; r < N; r++) {
                for (int c = 0; c <= N - M; c++) {
                    profit[r][c] = calcProfit(r, c);
                }
            }

            // Max sum of the two segments chosen by the two workers (non-overlapping)
            int answer = 0;
            for (int r1 = 0; r1 < N; r1++) {
                for (int c1 = 0; c1 <= N - M; c1++) {
                    int p1 = profit[r1][c1];
                    // In the same row, search c2 from c1+M to avoid overlap
                    for (int r2 = r1; r2 < N; r2++) {
                        if (r2 == r1) {
                            for (int c2 = c1 + M; c2 <= N - M; c2++) {
                                answer = Math.max(answer, p1 + profit[r2][c2]);
                            }
                        } else {
                            for (int c2 = 0; c2 <= N - M; c2++) {
                                answer = Math.max(answer, p1 + profit[r2][c2]);
                            }
                        }
                    }
                }
            }

            System.out.println("#" + tc + " " + answer);
        }
    }

    // Max profit from choosing a subset of the M horizontal cells from (r,c) without exceeding capacity C
    static int calcProfit(int r, int c) {
        int[] arr = new int[M];
        for (int i = 0; i < M; i++) arr[i] = map[r][c + i];

        int best = 0;
        int maxMask = 1 << M;
        for (int mask = 1; mask < maxMask; mask++) {
            int sum = 0;
            int sq = 0;
            for (int i = 0; i < M; i++) {
                if ((mask & (1 << i)) != 0) {
                    sum += arr[i];
                    if (sum > C) { // Over capacity, no need to continue
                        sq = -1; // Mark as invalid
                        break;
                    }
                    sq += arr[i] * arr[i];
                }
            }
            if (sq >= 0) best = Math.max(best, sq);
        }
        return best;
    }
}

package baek.silver.S1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj9465 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int T, n;
    static int[][] sticker;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < T; tc++) {
            n = Integer.parseInt(br.readLine());
            sticker = new int[2][n + 1];
            dp = new int[2][n + 1];

            // read sticker values
            for (int i = 0; i < 2; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 1; j <= n; j++) {
                    sticker[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            dp[0][1] = sticker[0][1];
            dp[1][1] = sticker[1][1];

            for (int i = 2; i <= n; i++) {
                dp[0][i] = Math.max(dp[1][i - 1], dp[1][i - 2]) + sticker[0][i];

                dp[1][i] = Math.max(dp[0][i - 1], dp[0][i - 2]) + sticker[1][i];

            }
            System.out.println((int) Math.max(dp[0][n], dp[1][n]));

        }
    }
}

package sw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class sw1952 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int T;

    static int[] cost, plan;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            // Input
            cost = new int[4];
            plan = new int[12];
            dp = new int[13];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 4; i++) {
                cost[i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 12; i++) {
                plan[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 1; i <= 12; i++) {
                dp[i] = dp[i - 1] + Math.min(cost[0] * plan[i - 1], cost[1]);

                if (i >= 3) {
                    dp[i] = Math.min(dp[i], dp[i - 3] + cost[2]);
                }
            }

            int result = Math.min(dp[12], cost[3]);
            System.out.println("#" + tc + " " + result);
        }
    }
}
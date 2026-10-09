package sw.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class sw5215 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int T;

    public static void main(String[] args) throws NumberFormatException, IOException {
        T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {

            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int L = Integer.parseInt(st.nextToken());

            int[][] ingredients = new int[N][2];
            int[] dp = new int[L + 1]; // dp[k] = max taste score with total calories <= k

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                int score = Integer.parseInt(st.nextToken());
                int calorie = Integer.parseInt(st.nextToken());

                ingredients[i][0] = score;
                ingredients[i][1] = calorie;
            }

            for (int i = 0; i < N; i++) {
                int score = ingredients[i][0];
                int calorie = ingredients[i][1];

                for (int k = L; k >= calorie; k--) {
                    dp[k] = Math.max(dp[k], dp[k - calorie] + score);
                }
            }

            int maxScore = 0;
            for (int k = 0; k <= L; k++) {
                maxScore = Math.max(maxScore, dp[k]);
            }

            System.out.println("#" + tc + " " + maxScore);
        }
    }
}

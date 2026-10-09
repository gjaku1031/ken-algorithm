package baek.gold.G5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj9251 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static String str1;
    static String str2;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        str1 = br.readLine();
        str2 = br.readLine();
        int length1 = str1.length();
        int length2 = str2.length();
        dp = new int[length1 + 1][length2 + 1];

        // Initialization
        for (int i = 0; i <= length1; i++) {
            dp[i][0] = 0;
        }

        for (int i = 0; i <= length2; i++) {
            dp[0][i] = 0;
        }

        // Recurrence
        for (int i = 1; i <= length1; i++) {
            for (int j = 1; j <= length2; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        System.out.println(dp[length1][length2]);

    }
}

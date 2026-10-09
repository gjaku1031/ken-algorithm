package baek.gold.G5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj17070 {
    static int n;
    static long[][][] dp;
    static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        map = new int[n+1][n+1];
        dp = new long[n+1][n+1][3]; //0: horizontal, 1: vertical, 2: diagonal

        StringTokenizer st;
        for(int i=1;i<=n;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=1;j<=n;j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp[1][2][0] = 1;
        for(int i=1;i<=n;i++) {
            for(int j=1;j<=n;j++) {
                if(map[i][j]!=1) {
                    dp[i][j][0] += dp[i][j-1][0] + dp[i][j-1][2];
                    dp[i][j][1] += dp[i-1][j][1] + dp[i-1][j][2];
                    if(map[i-1][j]!=1 && map[i][j-1]!=1) {
                        dp[i][j][2] += dp[i-1][j-1][0] + dp[i-1][j-1][1] + dp[i-1][j-1][2];
                    }
                }
            }
        }
        System.out.println(dp[n][n][0] + dp[n][n][1] + dp[n][n][2]);
    }
}

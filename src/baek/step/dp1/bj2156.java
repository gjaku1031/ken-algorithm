package baek.step.dp1;

import static java.lang.Math.max;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj2156 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static int[] grape;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());

        grape = new int[N + 1]; 
        dp = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            grape[i] = Integer.parseInt(br.readLine());
        }

        if (N == 1) {
            System.out.println(grape[1]);
            return;
        }
        dp[1] = grape[1];
        dp[2] = grape[1] + grape[2];
        if (N == 2) {
            System.out.println(dp[2]);
            return;
        }

        //drink the i-th wine vs. not
        for (int i = 3; i <= N; i++) {
            dp[i] = max(dp[i - 1], max(dp[i - 2] + grape[i], dp[i - 3] + grape[i - 1] + grape[i]));
        }

        System.out.println(dp[N]);
    }
}
package baek.step.backTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj15651 {
    static StringBuilder sb = new StringBuilder();
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);


        BTC(1, 0, new int[M]);
        System.out.print(sb);
    }

    static void BTC(int start, int depth, int[] result) {
        if (depth == M) { // When all M have been chosen
            for (int num : result) {
                sb.append(num).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 1; i <= N; i++) {
            result[depth] = i;
            BTC(i + 1, depth + 1, result);
        }
    }
}
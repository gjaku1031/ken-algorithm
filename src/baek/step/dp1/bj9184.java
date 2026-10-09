package baek.step.dp1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj9184 {

    static int[][][] w = new int[21][21][21];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // Bottom-up
        for (int i = 0; i < 21; i++) {
            for (int j = 0; j < 21; j++) {
                for (int k = 0; k < 21; k++) {

                    if (i == 0 || j == 0 || k == 0) {
                        w[i][j][k] = 1;
                    } else if (i < j && j < k) {
                        w[i][j][k] = w[i][j][k - 1] + w[i][j - 1][k - 1] - w[i][j - 1][k];
                    } else {
                        w[i][j][k] = w[i - 1][j][k] + w[i - 1][j - 1][k] + w[i - 1][j][k - 1] - w[i - 1][j - 1][k - 1];
                    }
                }
            }
        }

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            // Termination condition
            if (a == -1 && b == -1 && c == -1) {
                break;
            }

            int result;
            // Determine result based on input values
            if (a <= 0 || b <= 0 || c <= 0) {
                result = 1;
            } else if (a > 20 || b > 20 || c > 20) {
                result = w[20][20][20];
            } else {
                result = w[a][b][c];
            }

            sb.append("w(").append(a)
                    .append(", ").append(b)
                    .append(", ").append(c)
                    .append(") = ")
                    .append(result)
                    .append("\n");
        }

        System.out.print(sb);
    }
}
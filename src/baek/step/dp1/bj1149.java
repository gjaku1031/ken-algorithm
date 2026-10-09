package baek.step.dp1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj1149 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[][] cost;
    static int N;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        cost = new int[N][3];

        // Input
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            // cost[house index][0:R, 1:G, 2:B]
            for (int j = 0; j < 3; j++) {
                cost[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // Initial values
        int prevR = cost[0][0];
        int prevG = cost[0][1];
        int prevB = cost[0][2];

        for (int i = 1; i < N; i++) {
            int currentR = cost[i][0] + Math.min(prevG, prevB);
            int currentG = cost[i][1] + Math.min(prevR, prevB);
            int currentB = cost[i][2] + Math.min(prevR, prevG);

            prevR = currentR;
            prevG = currentG;
            prevB = currentB;
        }

        int result = Math.min(prevR, Math.min(prevG, prevB));
        System.out.println(result);
    }
}
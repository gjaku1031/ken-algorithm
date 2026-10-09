package sw.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class sw2805 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int T;

    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            int N = Integer.parseInt(br.readLine());
            int[][] farm = new int[N][N];
            for (int i = 0; i < N; i++) {
                String str = br.readLine();
                for (int j = 0; j < N; j++) {
                    farm[i][j] = str.charAt(j) - '0';
                }
            }

            int sum = getSum(N, farm);
            System.out.println("#" + tc + " " + sum); // Print result
        }
    }

    private static int getSum(int N, int[][] farm) {
        int sum = 0;
        int mid = N / 2;

        for (int i = 0; i < N; i++) {
            int startCol, endCol;
            if (i <= mid) {
                // Upper half of the diamond: range widens farther from the center
                startCol = mid - i;
                endCol = mid + i;
            } else {
                // Lower half of the diamond: range narrows farther from the center
                int distFromBottomEdge = (N - 1) - i; // Distance from the bottom edge
                startCol = mid - distFromBottomEdge;
                endCol = mid + distFromBottomEdge;
            }

            // Harvest crops within the diamond range of this row
            for (int j = startCol; j <= endCol; j++) {
                sum += farm[i][j];
            }
        }
        return sum;
    }
}
package sw.D6;

import java.util.*;

public class sw1263 {
    static final int INF = 1_000_000_000;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int T = sc.nextInt();
        for (int tc = 1; tc <= T; tc++) {
            int N = sc.nextInt();
            int[][] dist = new int[N][N];

            // Read adjacency matrix
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    int a = sc.nextInt();
                    if (i == j) dist[i][j] = 0;
                    else dist[i][j] = (a == 1) ? 1 : INF;
                }
            }

            for (int k = 0; k < N; k++) {
                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < N; j++) {
                        if (i == j) continue;
                        if (dist[i][k] == INF || dist[k][j] == INF) continue;
                        int via = dist[i][k] + dist[k][j];
                        if (via < dist[i][j]) dist[i][j] = via;
                    }
                }
            }

            long answer = Long.MAX_VALUE;
            for (int i = 0; i < N; i++) {
                long sum = 0;
                for (int j = 0; j < N; j++) sum += dist[i][j];
                answer = Math.min(answer, sum);
            }

            sb.append('#').append(tc).append(' ').append(answer).append('\n');
        }

        System.out.print(sb);
    }
}
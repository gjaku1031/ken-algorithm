package sw.D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class sw7733 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int T;

    static int N, day;
    static int[][] map;
    static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // Up/down/left/right
    static boolean[][] visited;
    static StringBuilder sb = new StringBuilder();

    static int result;


    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            // Input
            N = Integer.parseInt(br.readLine());
            map = new int[N][N];
            int max = 0;
            result = 0;

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    max = Math.max(max, map[i][j]); // Only iterate up to the max, not all 100 days
                }
            }
            for (day = 0; day <= max; day++) {
                visited = new boolean[N][N];
                int count = 0;
                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < N; j++) {
                        if (!visited[i][j] && map[i][j] > day) {
                            dfs(i, j);
                            count++;
                        }
                    }
                }
                result = Math.max(result, count);
            }
            sb.append("#" + tc + " " + result).append("\n");
        }
        System.out.println(sb);
    }

    static void dfs(int r, int c) {
        visited[r][c] = true;
        for (int d = 0; d < 4; d++) {
            int nr = r + dir[d][0];
            int nc = c + dir[d][1];
            if (0 <= nr && nr < N && 0 <= nc && nc < N) {
                if (!visited[nr][nc] && map[nr][nc] > day) {
                    dfs(nr, nc);
                }
            }
        }
    }
}
package baek.gold.G5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj10026 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int N;
    static int[][] map;
    static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // up, down, left, right
    static boolean[][] visited;
    static boolean[][] visited_ab;

    static int normal = 0;
    static int abnormal = 0;


    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        visited = new boolean[N][N];
        visited_ab = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                char ch = line.charAt(j);
                if (ch == 'R') {
                    map[i][j] = 1;
                } else if (ch == 'G') {
                    map[i][j] = 3;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    normal++;
                    dfs(i, j);
                }
                if (!visited_ab[i][j]) {
                    abnormal++;
                    dfs_ab(i, j);
                }
            }
        }
        System.out.println(normal + " " + abnormal);
    }

    static void dfs(int r, int c) {
        int current = map[r][c];
        for (int d = 0; d < 4; d++) {
            int nr = r + dir[d][0];
            int nc = c + dir[d][1];
            if (!valid(nr, nc)) continue;
            if (map[nr][nc] != current) continue;
            if (visited[nr][nc]) continue;
            visited[nr][nc] = true;
            dfs(nr, nc);
        }
    }

    static void dfs_ab(int r, int c) {
        int current = map[r][c];
        for (int d = 0; d < 4; d++) {
            int nr = r + dir[d][0];
            int nc = c + dir[d][1];
            if (!valid(nr, nc)) continue;
            if (visited_ab[nr][nc]) continue;
            if (map[nr][nc] % 2 != current % 2) continue;
            visited_ab[nr][nc] = true;
            dfs_ab(nr, nc);
        }
    }

    static boolean valid(int r, int c) {
        return 0 <= r && r < N && 0 <= c && c < N;
    }
}
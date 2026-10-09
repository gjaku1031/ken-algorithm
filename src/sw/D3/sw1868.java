package sw.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class sw1868 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int T;

    static int N;
    static int[][] map;
    static boolean[][] visited;
    static int result;

    static int[] dc = { 1, -1, 0, 0, 1, 1, -1, -1 };
    static int[] dr = { 0, 0, -1, 1, -1, 1, -1, 1 };

    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine());
            result = 0;
            map = new int[N][N];
            visited = new boolean[N][N];

            for (int i = 0; i < N; i++) {
                String line = br.readLine();
                for (int j = 0; j < N; j++) {
                    map[i][j] = line.charAt(j) == '*' ? -2 : -1;
                }
            }

            // First pass -> compute numbers around mines.
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (map[i][j] == -1) {
                        int count = 0;
                        for (int k = 0; k < 8; k++) {
                            int ni = i + dc[k];
                            int nj = j + dr[k];
                            if (valid(ni, nj) && map[ni][nj] == -2) {
                                count++;
                            }
                        }

                        if (count > 0) {
                            map[i][j] = count;
                        }
                    }
                }
            }

            // Second pass 0 -> click cells that are 0 (map[i][j] == -1)
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (map[i][j] == -1 && !visited[i][j]) {
                        result++;
                        DFS(i, j);
                    }
                }
            }

            // Third pass -> handle the rest
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (map[i][j] > 0 && !visited[i][j]) {
                        result++;
                    }
                }
            }
            System.out.println("#" + tc + " " + result);
        }
    }

    static void DFS(int c, int r) {
        visited[c][r] = true;

        for (int i = 0; i < 8; i++) {
            int nc = c + dc[i];
            int nr = r + dr[i];

            if (valid(nc, nr) && !visited[nc][nr] && map[nc][nr] != -2) {
                if (map[nc][nr] == -1) {
                    DFS(nc, nr);
                } else {
                    visited[nc][nr] = true;
                }
            }
        }
    }

    static boolean valid(int c, int r) {
        return 0 <= c && c < N && 0 <= r && r < N;
    }
}
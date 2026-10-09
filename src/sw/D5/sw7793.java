package sw.D5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class sw7793 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int T;

    static int N, M;
    static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // Up/down/left/right

    static int sr, sc, er, ec;
    static int[][] map;
    static int result;
    static boolean success;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            // Input
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            result = 0;
            map = new int[N][M];
            visited = new boolean[N][M];
            success = false;

            for (int i = 0; i < N; i++) {
                String line = br.readLine();
                for (int j = 0; j < M; j++) {
                    char now = line.charAt(j);
                    if (now == 'D') {
                        er = i;
                        ec = j;
                    } else if (now == 'S') {
                        sr = i;
                        sc = j;
                    }
                    map[i][j] = now;
                }
            }

            bfs();
            if (success) {
                System.out.println("#" + tc + " " + result);
            } else {
                System.out.println("#" + tc + " " + "GAME OVER");
            }

        }
    }

    static void bfs() {

        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{sr, sc});
        visited[sr][sc] = true;

        while (!queue.isEmpty()) {
            // Spread the devil's grip
            List<int[]> devils = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (map[i][j] == '*') {
                        devils.add(new int[]{i, j});
                    }
                }
            }

            for (int[] devil : devils) {
                for (int d = 0; d < 4; d++) {
                    int nr = devil[0] + dir[d][0];
                    int nc = devil[1] + dir[d][1];
                    if (valid(nr, nc) && map[nr][nc] == '.') {
                        map[nr][nc] = '*';
                    }
                }
            }
            // Process nodes at the same depth
            result++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] now = queue.poll();
                int r = now[0];
                int c = now[1];
                for (int d = 0; d < 4; d++) {
                    int nr = r + dir[d][0];
                    int nc = c + dir[d][1];

                    if (nr == er && nc == ec) {
                        success = true;
                        return;
                    }
                    if (valid(nr, nc) && map[nr][nc] == '.' && !visited[nr][nc]) {
                        queue.add(new int[]{nr, nc});
                        visited[nr][nc] = true;
                    }
                }
            }
        }
    }
    static boolean valid(int r, int c) {
        return 0 <= r && r < N && 0 <= c && c < M;
    }
}
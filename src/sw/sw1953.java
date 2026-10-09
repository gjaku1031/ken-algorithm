package sw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class sw1953 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int T;

    static int N, M;
    static int R, C, L;
    static int[][] map;
    static boolean[][] visited;

    static int[][][] dir = {
            {}, // 0
            { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } }, // 1. up down left right
            { { -1, 0 }, { 1, 0 } }, // 2. up down
            { { 0, -1 }, { 0, 1 } }, // 3. left right
            { { -1, 0 }, { 0, 1 } }, // 4. up right
            { { 1, 0 }, { 0, 1 } }, // 5. down right
            { { 1, 0 }, { 0, -1 } }, // 6. down left
            { { -1, 0 }, { 0, -1 } } // 7. up left
    };

    static int result;

    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            L = Integer.parseInt(st.nextToken());

            map = new int[N][M];
            visited = new boolean[N][M];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < M; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            result = 1;
            bfs();
            System.out.println("#" + tc + " " + result);
        }
    }

    static void bfs() {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[] { R, C });
        visited[R][C] = true;

        for (int time = 1; time < L; time++) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] now = queue.poll();
                int curR = now[0];
                int curC = now[1];

                int[][] curDir = dir[map[curR][curC]];
                for (int d = 0; d < curDir.length; d++) {
                    int nr = curR + curDir[d][0];
                    int nc = curC + curDir[d][1];

                    if (valid(nr, nc) && !visited[nr][nc] && map[nr][nc] != 0
                            && isOpen(map[nr][nc], -curDir[d][0], -curDir[d][1])) {
                        visited[nr][nc] = true;
                        result++;
                        queue.add(new int[] { nr, nc });
                    }
                }
            }
        }
    }

    static boolean valid(int r, int c) {
        return 0 <= r && r < N && 0 <= c && c < M;
    }

    static boolean isOpen(int type, int dr, int dc) {
        int[][] opens = dir[type];
        for (int i = 0; i < opens.length; i++) {
            if (opens[i][0] == dr && opens[i][1] == dc) {
                return true;
            }
        }
        return false;
    }
}
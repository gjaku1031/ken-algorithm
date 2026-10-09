package baek.gold.G3;

import  java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj17135 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, M, D;

    static int[][] map;
    static int[][] mapCopy;
    static int[][] dir = {{0, -1}, {-1, 0}, {0, 1}};

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        map = new int[N + 1][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = 0;

        for (int i = 0; i < M - 2; i++) {
            for (int j = i + 1; j < M - 1; j++) {
                for (int k = j + 1; k < M; k++) {
                    answer = Math.max(answer, simulate(i, j, k));
                }
            }
        }
        System.out.println(answer);
    }

    // full simulation for combination (c1,c2,c3): returns the number of kills
    static int simulate(int c1, int c2, int c3) {
        mapCopy = new int[N][M];
        for (int r = 0; r < N; r++) {
            System.arraycopy(map[r], 0, mapCopy[r], 0, M);
        }

        int kills = 0;
        int base = N - 1;

        for (int turn = 0; turn < N; turn++) {
            int[][] picks = new int[3][];
            picks[0] = findTarget(base, c1, D);
            picks[1] = findTarget(base, c2, D);
            picks[2] = findTarget(base, c3, D);

            boolean[][] hit = new boolean[N][M];
            for (int t = 0; t < 3; t++) {
                int[] p = picks[t];
                if (p == null) continue;
                int pr = p[0], pc = p[1];
                if (!hit[pr][pc] && mapCopy[pr][pc] == 1) {
                    hit[pr][pc] = true;
                    mapCopy[pr][pc] = 0;
                    kills++;
                }
            }
            base--;
            if (base < 0) break;
            if (!hasEnemy(base)) break;
        }

        return kills;
    }

    static int[] findTarget(int base, int c, int d) {
        if (base < 0) return null;
        if (c < 0 || c >= M) return null;

        boolean[][] visited = new boolean[N][M];
        Queue<int[]> que = new LinkedList<>();

        que.add(new int[]{base, c, 1});
        visited[base][c] = true;

        while (!que.isEmpty()) {
            int[] cur = que.poll();
            int curR = cur[0], curC = cur[1], curD = cur[2];

            if (mapCopy[curR][curC] == 1) return new int[]{curR, curC};

            if (curD == d) continue;

            for (int k = 0; k < 3; k++) {
                int nr = curR + dir[k][0];
                int nc = curC + dir[k][1];
                if (valid(nr, nc, base) && !visited[nr][nc]) {
                    visited[nr][nc] = true;
                    que.add(new int[]{nr, nc, curD + 1});
                }
            }
        }
        return null;
    }

    static boolean valid(int r, int c, int base) {
        return 0 <= r && r <= base && 0 <= c && c < M;
    }

    static boolean hasEnemy(int base) {
        for (int r = 0; r <= base; r++) {
            for (int c = 0; c < M; c++) {
                if (mapCopy[r][c] == 1) return true;
            }
        }
        return false;
    }
}

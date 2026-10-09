package baek.gold.G4;

// the code can be written together


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class bj14502 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N, M;
    static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    static int[][] map;
    static int[][] copyMap;

    static List<int[]> wallCandi = new ArrayList<>();
    static int[] wall = new int[3];

    static int result = 0;

    static List<int[]> virus = new ArrayList<>();
    static Queue<int[]> queue;

    static int sum;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        sum = -3;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 0) {
                    wallCandi.add(new int[]{i, j});
                    sum++;
                }
                if (map[i][j] == 2) {
                    virus.add(new int[]{i, j});
                }
            }
        }
        bt(0, 0);
        System.out.println(result);
    }
    static int cur;
    static void bt(int u, int dep) {
        if (dep == 3) {
            copyMap = Arrays.stream(map)
                    .map(int[]::clone)
                    .toArray(int[][]::new);
            for (int i = 0; i < 3; i++) {
                int r = wallCandi.get(wall[i])[0];
                int c = wallCandi.get(wall[i])[1];
                copyMap[r][c] = 1;
            }
            cur = sum;
            bfs();

            result = Math.max(result, cur);
            return;
        }

        for (int i = u; i < wallCandi.size(); i++) {
            wall[dep] = i;
            bt(i + 1, dep + 1);
        }
    }

    static void bfs() {
        queue = new ArrayDeque<>();
        queue.addAll(virus);
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int curR = now[0];
            int curC = now[1];
            for (int d = 0; d < 4; d++) {
                int nr = curR + dir[d][0];
                int nc = curC + dir[d][1];

                if (valid(nr, nc) && copyMap[nr][nc] == 0) {
                    cur--;
                    queue.add(new int[]{nr, nc});
                    copyMap[nr][nc] = 2;
                }
            }
        }
    }

    static boolean valid(int r, int c) {
        return 0 <= r && r < N && 0 <= c && c < M;
    }
}
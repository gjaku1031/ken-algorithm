package baek.gold.G4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class bj3055 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int R, C;
    static char[][] map;
    static boolean[][] visited;
    static int count = 0;

    static int[] start;
    static int[] end;
    static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    static List<int[]> flood;
    static String result = "KAKTUS";

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        flood = new LinkedList<>();
        for (int i = 0; i < R; i++) {
            String line = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = line.charAt(j);
                if (map[i][j] == 'S') start = new int[]{i, j};
                else if (map[i][j] == 'D') end = new int[]{i, j};
                else if (map[i][j] == '*') flood.add(new int[]{i, j});
            }
        }
        bfs();
        System.out.println(result);
    }

    static void bfs() {
        Queue<int[]> queue = new ArrayDeque<>();
        visited = new boolean[R][C];
        queue.add(start);
        while (!queue.isEmpty()) {
            count++;

            // flood spreads
            int size = flood.size();

            for (int s = 0; s < size; s++) {
                int[] crr = flood.get(0);
                flood.remove(0);
                for (int d = 0; d < 4; d++) {
                    int nr = crr[0] + dir[d][0];
                    int nc = crr[1] + dir[d][1];
                    if (valid(nr, nc) && map[nr][nc] == '.') {
                        map[nr][nc] = '*';
                        flood.add(new int[]{nr, nc});
                    }
                }
            }

            size = queue.size();
            for (int s = 0; s < size; s++) {
                int[] now = queue.poll();
                for (int d = 0; d < 4; d++) {
                    int nr = now[0] + dir[d][0];
                    int nc = now[1] + dir[d][1];

                    if (nr == end[0] && nc == end[1]) {
                        result = Integer.toString(count);
                        return;
                    }

                    if (valid(nr, nc) && !visited[nr][nc] && map[nr][nc] == '.') {
                        visited[nr][nc] = true;
                        queue.add(new int[]{nr, nc});
                    }
                }
            }
        }
    }

    static boolean valid(int r, int c) {
        return 0 <= r && r < R && 0 <= c && c < C;
    }
}
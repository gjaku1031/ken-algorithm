package sw.D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class sw1227 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int T;

    static int[][] map;
    static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // Up/down/left/right
    static boolean[][] visited;

    static int startR, startC, endR, endC;

    public static void main(String[] args) throws IOException {

        for (int tc = 1; tc <= 10; tc++) {
            startR = startC = endR = endC = 0;
            T = Integer.parseInt(br.readLine());
            visited = new boolean[100][100];
            map = new int[100][100];
            for (int i = 0; i < 100; i++) {
                String line = br.readLine();
                for (int j = 0; j < 100; j++) {
                    int now = line.charAt(j) - '0';
                    map[i][j] = now;
                    if (now == 2) {
                        startR = i;
                        startC = j;
                    }
                    if (now == 3) {
                        endR = i;
                        endC = j;
                    }
                }
            }
            System.out.println("#" + tc + " " + maze(startR, startC));
        }
    }

    static int maze(int startR, int startC) {
        Queue<Integer> que = new ArrayDeque<>();
        que.add(startR);
        que.add(startC);
        visited[startR][startC] = true;

        while (!que.isEmpty()) {
            int curR = que.poll();
            int curC = que.poll();


            for (int d = 0; d < 4; d++) {
                int nr = curR + dir[d][0];
                int nc = curC + dir[d][1];

                if (nr == endR && nc == endC) {
                    return 1;
                }
                if (valid(nr, nc) && !visited[nr][nc] && map[nr][nc] == 0) {
                    visited[nr][nc] = true;
                    que.add(nr);
                    que.add(nc);
                }
            }
        }
        return 0;
    }

    static boolean valid(int r, int c) {
        return 0 <= r && r < 100 && 0 <= c && c < 100;
    }
}
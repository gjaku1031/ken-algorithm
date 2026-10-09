package sw.D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class sw1861 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int T;

    static int N;
    static int[][] rooms;

    static int max;
    static int currentMax;
    static int result_room;

    //up down left right
    static int[] dc = {-1, 1, 0, 0};
    static int[] dr = {0, 0, -1, 1};
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine());
            rooms = new int[N][N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    rooms[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            max = -1;
            result_room = 0;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    visited = new boolean[N][N];
                    visited[i][j] = true;
                    currentMax = 1;
                    DFS(i, j, 1);
                    if (max < currentMax) {
                        max = currentMax;
                        result_room = rooms[i][j];
                    } else if (max == currentMax) {
                        result_room = Math.min(result_room, rooms[i][j]);
                    }
                }
            }

            System.out.println("#" + tc + " " + result_room + " " + max);
        }
    }

    static void DFS(int c, int r, int level) {
        for (int i = 0; i < 4; i++) {
            int nc = c + dc[i];
            int nr = r + dr[i];

            if (valid(nc, nr) && !visited[nc][nr] && rooms[nc][nr] - rooms[c][r] == 1) {
                visited[nc][nr] = true;
                currentMax = Math.max(currentMax, level + 1);
                DFS(nc, nr, level + 1);
            }
        }
    }

    static boolean valid(int r, int c) {
        return 0 <= r && r < N && 0 <= c && c < N;
    }
}
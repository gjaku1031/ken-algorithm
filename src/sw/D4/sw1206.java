package sw.D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class sw1206 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int T;
    static int success;

    // up down left right
    static int[] dc = { 1, -1, 0, 0 };
    static int[] dr = { 0, 0, -1, 1 };

    static int[][] maze;
    static boolean[][] visited;
    static int start_c;
    static int start_r;
    static int end_c;
    static int end_r;

    public static void main(String[] args) throws IOException {
        for (int tc = 1; tc <= 10; tc++) {
            T = Integer.parseInt(br.readLine());
            maze = new int[16][16];
            visited = new boolean[16][16];
            success = 0;

            for (int i = 0; i < 16; i++) {
                String str = br.readLine();
                for (int j = 0; j < 16; j++) {
                    maze[i][j] = Integer.parseInt(Character.toString(str.charAt(j)));
                    if (maze[i][j] == 2) {
                        start_c = i;
                        start_r = j;
                    }

                    if (maze[i][j] == 3) {
                        end_c = i;
                        end_r = j;
                    }
                }
            }

            DFS(start_c, start_r);

            System.out.println("#" + tc + " " + success);
        }
    }

    static void DFS(int c, int r) {
        if (c == end_c && r == end_r) {
            success = 1;
            return;
        }

        visited[c][r] = true;

        for (int i = 0; i < 4; i++) {
            int nc = c + dc[i];
            int nr = r + dr[i];

            if (valid(nc, nr) && !visited[nc][nr] && maze[nc][nr] != 1) {
                DFS(nc, nr);
                if (success == 1)
                    return;
            }
        }

        visited[c][r] = false;
    }

    static boolean valid(int c, int r) {
        return 0 <= c && c < 16 && 0 <= r && r < 16;
    }
}
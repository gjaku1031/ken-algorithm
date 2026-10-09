package baek.gold.G3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj3109 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    // up-right, right, down-right
    static int[][] dir = {{-1, 1}, {0, 1}, {1, 1}};

    static int R, C;
    static char[][] map;
    static boolean[][] visited;

    static int result = 0;


    public static void main(String[] args) throws IOException {
        // Input
        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        visited = new boolean[R][C];

        for (int i = 0; i < R; i++) {
            String str = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = str.charAt(j);
            }
        }
        for (int i = 0; i < R; i++) {
            dfs(i, 0);
        }
        System.out.println(result);
    }

    static boolean dfs(int r, int c) {
        if (c == C - 1) {
            result++;
            return true;
        }
        for (int[] d : dir) {
            int nr = r + d[0];
            int nc = c + d[1];

            if (!valid(nr, nc)) continue;// check that it is inside the grid
            if (map[nr][nc] == 'x') continue;// check for a building
            if (visited[nr][nc]) continue;// check whether a pipe is already there

            visited[nr][nc] = true;
            if (dfs(nr, nc)) return true;
        }
        return false;
    }

    static boolean valid(int r, int c) {
        return 0 <= r && r < R && 0 <= c && c < C;
    }
}
package baek.gold.G4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj1987 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int R, C;

    static char[][] map;
    static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // up, down, left, right

    static boolean[] visited_alp = new boolean[26];

    static int max = 1;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];

        for (int i = 0; i < R; i++) {
            String str = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = str.charAt(j);
            }
        }

        visited_alp[map[0][0] - 'A'] = true;
        bt(0, 0, 1);
        System.out.println(max);
    }

    static void bt(int r, int c, int level) {
        for (int i = 0; i < 4; i++) {
            int nr = r + dir[i][0];
            int nc = c + dir[i][1];

            if (!valid(nr, nc)) continue;
            int currentChIdx = map[nr][nc] - 'A';
            if (visited_alp[currentChIdx]) continue;

            visited_alp[currentChIdx] = true;

            max = Math.max(max, level + 1);
            bt(nr, nc, level + 1);

            visited_alp[currentChIdx] = false;
        }
    }

    static boolean valid(int r, int c) {
        return 0 <= r && r < R && 0 <= c && c < C;
    }
}
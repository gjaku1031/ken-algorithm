package sw.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class sw11315 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static char[][] gomoku;

    static int[] dx = {0, 1, 1,  1};
    static int[] dy = {1, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine());
            gomoku = new char[N][N];

            for (int i = 0; i < N; i++) {
                String str = br.readLine();
                for (int j = 0; j < N; j++) {
                    gomoku[i][j] = str.charAt(j);
                }
            }

            String result = "NO";
            if (solve()) {
                result = "YES";
            }
            System.out.println("#" + tc + " " + result);
        }
    }

    static boolean solve() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (gomoku[i][j] == 'o') {
                    if (check(i, j)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    static boolean check(int r, int c) {
        for (int d = 0; d < 4; d++) { //Check 4 directions
            int count = 1;
            int nr = r;
            int nc = c;

            for (int k = 0; k < 4; k++) { //Check 4 stones
                nr += dx[d];
                nc += dy[d];

                if (isValid(nr, nc) && gomoku[nr][nc] == 'o') {
                    count++;
                } else {
                    break;
                }
            }

            if (count == 5) {
                return true;
            }
        }
        return false;
    }

    static boolean isValid(int r, int c) {
        return r >= 0 && r < N && c >= 0 && c < N;
    }
}
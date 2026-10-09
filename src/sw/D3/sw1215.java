package sw.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class sw1215 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static char[][] pal;
    static int count;

    public static void main(String[] args) throws IOException {
        for (int tc = 1; tc <= 10; tc++) {
            N = Integer.parseInt(br.readLine());
            count = 0;

            pal = new char[8][8];
            for (int i = 0; i < 8; i++) {
                String strInput = br.readLine().trim();
                for (int j = 0; j < 8; j++) {
                    pal[i][j] = strInput.charAt(j);
                }
            }

            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    solve(i, j);
                }
            }
            System.out.println("#" + tc + " " + count);
        }
    }

    static void solve(int r, int c) {
        // Horizontal
        if (c + N <= 8) {
            StringBuilder sb1 = new StringBuilder();
            for (int k = 0; k < N; k++) {
                sb1.append(pal[r][c + k]);
            }
            if (isPal(sb1.toString())) {
                count++;
            }
        }

        // Vertical
        if (r + N <= 8) {
            StringBuilder sb2 = new StringBuilder();
            for (int k = 0; k < N; k++) {
                sb2.append(pal[r + k][c]);
            }
            if (isPal(sb2.toString())) {
                count++;
            }
        }
    }

    static boolean isPal(String str) {
        int len = str.length();
        for (int i = 0; i < len / 2; i++) {
            if (str.charAt(i) != str.charAt(len - 1 - i)) {
                return false;
            }
        }
        return true;
    }
}

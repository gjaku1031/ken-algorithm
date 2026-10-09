package baek.gold.G4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class bj10993 {

    static char[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        if (N == 1) {
            System.out.println("*");
            return;
        }

        int height = (1 << N) - 1;
        int width = (1 << (N + 1)) - 3;

        map = new char[height][width];
        for (int i = 0; i < height; i++) {
            Arrays.fill(map[i], ' ');
        }
        

        // set the initial direction and starting point
        boolean isInitialUpward = (N % 2 == 1);
        int startRow = isInitialUpward ? 0 : height - 1;
        int startCol = width / 2;

        draw(N, startRow, startCol, isInitialUpward);

        // print the result
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < height; i++) {
            int lastStarIndex = -1;
            for (int j = 0; j < width; j++) {
                if (map[i][j] == '*') {
                    lastStarIndex = j;
                }
            }
            if (lastStarIndex != -1) {
                sb.append(new String(map[i], 0, lastStarIndex + 1));
            }
            if (i < height - 1) {
                sb.append("\n");
            }
        }
        System.out.print(sb.toString());
    }

    /**
     * Recursively draws the stars
     * @param n current level
     * @param r row coordinate of the apex of the current-level triangle
     * @param c column coordinate of the apex of the current-level triangle
     * @param isUpward whether the current triangle points upward
     */
    static void draw(int n, int r, int c, boolean isUpward) {
        if (n == 0) {
            return;
        }

        int h_border = 1 << (n - 1);

        if (isUpward) { // upward-pointing triangle
            // draw the slanted sides
            for (int i = 0; i < h_border; i++) {
                map[r + i][c - i] = '*';
                map[r + i][c + i] = '*';
            }
            // draw the base
            Arrays.fill(map[r + h_border - 1], c - (h_border - 1), c + h_border, '*');

            // next recursive call (downward-pointing pattern)
            int next_r = r + h_border / 2;
            draw(n - 1, next_r, c, !isUpward);

        } else { // downward-pointing triangle
            // draw the slanted sides
            for (int i = 0; i < h_border; i++) {
                map[r - i][c - i] = '*';
                map[r - i][c + i] = '*';
            }
            // draw the top side
            Arrays.fill(map[r - h_border + 1], c - (h_border - 1), c + h_border, '*');

            // next recursive call (upward-pointing pattern)
            int next_r = r - h_border / 2;
            draw(n - 1, next_r, c, !isUpward);
        }
    }
}
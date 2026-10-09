package baek.step.brute;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj1018 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        String[] chess = new String[a];
        for (int i = 0; i < a; i++) {
            chess[i] = br.readLine();
        }
        int min = test(testChess("B"), chess, 0, 0);

        for (int i = 0; i < a - 7; i++) {
            for (int j = 0; j < b - 7; j++) {
                int liveMin = Math.min(test(testChess("B"), chess, i, j), test(testChess("W"), chess, i, j));
                if (min > liveMin) {
                    min = liveMin;
                }
            }
        }
        System.out.println(min);
    }

    static String[] testChess(String startChar) {
        String row1 = "BWBWBWBW";
        String row2 = "WBWBWBWB";
        String[] testChess = new String[8];

        // Build test chessboards
        if (startChar.equals("B")) {
            for (int i = 0; i < 8; i++) {
                if (i % 2 == 0) {
                    testChess[i] = row1;
                } else {
                    testChess[i] = row2;
                }
            }
        } else if (startChar.equals("W")) {
            for (int i = 0; i < 8; i++) {
                if (i % 2 == 0) {
                    testChess[i] = row2;
                } else {
                    testChess[i] = row1;
                }
            }
        }

        return testChess;
    }

    // Check the chessboard
    static int test(String[] testChess, String[] chess, int x, int y) {
        int count = 0;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (testChess[i].charAt(j) != chess[x + i].charAt(y + j)) {
                    count++;
                }
            }
        }
        return count;
    }
}

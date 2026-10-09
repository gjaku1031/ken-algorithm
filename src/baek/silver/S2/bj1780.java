package baek.silver.S2;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class bj1780 {
    static BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
    static StringTokenizer st;
    static int[][] arr;
    static int N;
    static int[] result = new int[3];

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        recur(0, 0, N);
        for (int i = 0; i < 3; i++) {
            System.out.println(result[i]);
        }
    }

    static void recur(int r, int c, int n) {
        if (allSame(r, c, n)) {
            // -1 -> 0 | 0 -> 1 | 1 -> 2
            result[arr[r][c] + 1]++;
            return;
        }
        int next = n / 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                recur(r + i * next, c + j * next, next);
            }
        }
    }

    static boolean allSame(int r, int c, int n) {
        int start = arr[r][c];
        for (int i = r; i < r + n; i++) {
            for (int j = c; j < c + n; j++) {
                if (arr[i][j] != start) {
                    return false;
                }
            }
        }
        return true;
    }
}
package baek.gold.G5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj16935 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N, M, R, opt;
    static int[][] arr;
    static int[][] temp;

    static StringBuilder result = new StringBuilder();

    public static void main(String[] args) throws IOException {
        // Input
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        arr = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        temp = new int[N][M];
        for (int i = 0; i < N; i++) {
            temp[i] = arr[i].clone();
        }

        st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()) {
            int opt = Integer.parseInt(st.nextToken());
            switch (opt) {
                case 1:
                    opt1(temp);
                    break;
                case 2:
                    opt2(temp);
                    break;
                case 3:
                    opt3(temp);
                    break;
                case 4:
                    opt4(temp);
                    break;
                case 5:
                    opt5(temp);
                    break;
                case 6:
                    opt6(temp);
                    break;
            }
        }
        print(temp);
    }

    static void opt1(int[][] input) {
        int R = input.length;
        int C = input[0].length;

        int[][] temp_arr = new int[R][C];
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                temp_arr[i][j] = input[R - i - 1][j];
            }
        }

        temp = new int[R][C];
        for (int i = 0; i < R; i++) {
            temp[i] = temp_arr[i].clone();
        }
    }

    static void opt2(int[][] input) {
        int R = input.length;
        int C = input[0].length;

        int[][] temp_arr = new int[R][C];

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                temp_arr[i][j] = input[i][C - j - 1];
            }
        }
        temp = new int[R][C];
        for (int i = 0; i < R; i++) {
            temp[i] = temp_arr[i].clone();
        }
    }


    static void opt3(int[][] input) {
        int R = input.length;
        int C = input[0].length;

        int[][] temp_arr = new int[C][R];
        for (int i = 0; i < C; i++) {
            for (int j = 0; j < R; j++) {
                temp_arr[i][j] = input[R - 1 - j][i];
            }
        }

        temp = new int[C][R];
        for (int i = 0; i < C; i++) {
            temp[i] = temp_arr[i].clone();
        }
    }

    static void opt4(int[][] input) {
        int R = input.length;
        int C = input[0].length;

        int[][] temp_arr = new int[C][R];
        for (int i = 0; i < C; i++) {
            for (int j = 0; j < R; j++) {
                temp_arr[i][j] = input[j][C - 1 - i];
            }
        }
        temp = new int[C][R];
        for (int i = 0; i < C; i++) {
            temp[i] = temp_arr[i].clone();
        }
    }

    static void opt5(int[][] input) {
        int R = input.length;
        int C = input[0].length;

        int[][] temp_arr = new int[R][C];

        copy(temp_arr, input, 0, 0, R / 2, 0);          // top-left ← bottom-left
        copy(temp_arr, input, 0, C / 2, 0, 0);          // top-right ← top-left
        copy(temp_arr, input, R / 2, C / 2, 0, C / 2);  // bottom-right ← top-right
        copy(temp_arr, input, R / 2, 0, R / 2, C / 2);  // bottom-left ← bottom-right

        temp = new int[R][C];
        for (int i = 0; i < R; i++) {
            temp[i] = temp_arr[i].clone();
        }
    }

    static void opt6(int[][] input) {
        int R = input.length;
        int C = input[0].length;

        int[][] temp_arr = new int[R][C];

        copy(temp_arr, input, 0, 0, 0, C / 2);          // top-left ← top-right
        copy(temp_arr, input, 0, C / 2, R / 2, C / 2);  // top-right ← bottom-right
        copy(temp_arr, input, R / 2, C / 2, R / 2, 0);  // bottom-right ← bottom-left
        copy(temp_arr, input, R / 2, 0, 0, 0);          // bottom-left ← top-left

        temp = new int[R][C];
        for (int i = 0; i < R; i++) {
            temp[i] = temp_arr[i].clone();
        }
    }

    static void copy(int[][] dest, int[][] input, int destR, int destC, int srcR, int srcC) {
        int R = input.length;
        int C = input[0].length;

        for (int i = 0; i < R / 2; i++) {
            for (int j = 0; j < C / 2; j++) {
                dest[destR + i][destC + j] = input[srcR + i][srcC + j];
            }
        }
    }

    private static void print(int[][] temp_arr) {
        for (int i = 0; i < temp_arr.length; i++) {
            for (int j = 0; j < temp_arr[0].length; j++) {
                System.out.print(temp_arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}

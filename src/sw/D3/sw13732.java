package sw.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class sw13732 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int T;

    static int N;
    static char[][] board;
    static int start_c;
    static int start_r;

    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine());
            board = new char[N][N];

            boolean found = false;
            for (int i = 0; i < N; i++) {
                String line = br.readLine();
                for (int j = 0; j < N; j++) {
                    board[i][j] = line.charAt(j);

                    if (!found && board[i][j] == '#') {
                        start_c = i;
                        start_r = j;
                        found = true;
                       /* System.out.println("start found" + " c = " + start_c + " r = " + start_r);*/
                    }
                }
            }
            System.out.println("#" + tc + " " + isSquare());
        }
    }

    static String isSquare() {
        int width = 0;

        for (int i = 0; i < N; i++) {
            if (board[start_c][i] == '#') {
                width++;
            }
        }
       /* System.out.println("width = " + width);*/

        char[][] new_board = new char[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                new_board[i][j] = '.';
            }
        }

        for (int i = 0; i < width; i++) {
            for (int j = 0; j < width; j++) {
                if (valid(start_c + i, start_r + j)) {
                    new_board[start_c + i][start_r + j] = '#';
                } else {
             /*       System.out.println("i = " + i);
                    System.out.println("j = " + j);
                    System.out.println("returned because not valid");*/
                    return "no";
                }
            }
        }
/*
        System.out.println("====new board====");
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(new_board[i][j]);
            }
            System.out.println();
        }*/


        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (new_board[i][j] != board[i][j]) {
                    /*System.out.println("i = " + i);
                    System.out.println("j = " + j);
                    System.out.println("returned because board does not match");*/
                    return "no";
                }
            }
        }


        return "yes";
    }

    static boolean valid(int c, int r) {
        return 0 <= c && c < N && 0 <= r && r < N;
    }

}
/*

3
3
...
.##
.##
4
#..#
....
....
#..#
5
.....
.###.
.###.
.###.
.....
 */
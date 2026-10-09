package sw.D2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class sw1954 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            int N = Integer.parseInt(br.readLine());
            int[][] arr = new int[N][N];
            // right, down, left, up
            int[] dx = {0, 1, 0, -1};
            int[] dy = {1, 0, -1, 0};
            int x = 0, y = 0, dir = 0;

            for (int num = 1; num <= N * N; num++) {
                arr[x][y] = num;
                int nx = x + dx[dir];
                int ny = y + dy[dir];
                if (nx < 0 || ny < 0 || nx >= N || ny >= N || arr[nx][ny] != 0) {
                    dir = (dir + 1) % 4;
                    nx = x + dx[dir];
                    ny = y + dy[dir];
                }
                x = nx;
                y = ny;
            }

            System.out.println("#" + tc);
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    System.out.print(arr[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}
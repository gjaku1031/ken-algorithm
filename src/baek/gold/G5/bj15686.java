package baek.gold.G5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class bj15686 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N, M;
    static int[][] map;
    static List<int[]> houses;      // (r, c)
    static List<Chicken> chickens;  // chicken restaurant coordinates
    static int[] open;              // indices of the selected chicken restaurants

    static int result = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][N];

        houses = new ArrayList<>();
        chickens = new ArrayList<>();
        open = new int[M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) houses.add(new int[]{i, j});
                else if (map[i][j] == 2) chickens.add(new Chicken(i, j));
            }
        }

        bt(0, 0);
        System.out.println(result);
    }

    static void bt(int start, int dep) {
        if (dep == M) {
            int sum = 0;
            for (int[] h : houses) {
                int min = Integer.MAX_VALUE;
                for (int k = 0; k < M; k++) {
                    Chicken ch = chickens.get(open[k]);
                    int d = Math.abs(ch.row - h[0]) + Math.abs(ch.column - h[1]);
                    if (d < min) min = d;
                }
                sum += min;
                if (sum >= result) break;
            }
            result = Math.min(result, sum);
            return;
        }
        for (int i = start; i < chickens.size(); i++) {
            open[dep] = i;
            bt(i + 1, dep + 1);
        }
    }

    static class Chicken {
        int row, column;

        Chicken(int row, int column) {
            this.row = row;
            this.column = column;
        }
    }
}
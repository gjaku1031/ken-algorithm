package sw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class sw5644 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int T;
    static int M, A;

    static int[] arr_A;
    static int[] arr_B;

    // Up, right, down, left
    static int[][] dir = {{0, 0}, {0, -1}, {1,0}, {0, 1}, {-1, 0}};
    static List<Charge>[][] map;

    static int sum;
    static int A_x;
    static int A_y;

    static int B_x;
    static int B_y;


    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            A = Integer.parseInt(st.nextToken());

            arr_A = new int[M];
            arr_B = new int[M];

            map = new List[11][11];
            for (int i = 1; i <= 10; i++) {
                for (int j = 1; j <= 10; j++) {
                    map[i][j] = new ArrayList();
                }
            }


            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                arr_A[i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                arr_B[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 0; i < A; i++) {
                st = new StringTokenizer(br.readLine());

                // Center
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                int c = Integer.parseInt(st.nextToken()); // Charging range
                int p = Integer.parseInt(st.nextToken()); // Performance
                setDia(x, y, c, p, i);
            }

            A_x = 1;
            A_y = 1;
            sum = 0;

            B_x = 10;
            B_y = 10;

            for (int i = -1; i < M; i++) {
                //Move
                if (i != -1) {
                    A_x += dir[arr_A[i]][0];
                    A_y += dir[arr_A[i]][1];
                    B_x += dir[arr_B[i]][0];
                    B_y += dir[arr_B[i]][1];
                }

                if (map[A_y][A_x].isEmpty()) {
                    if (!map[B_y][B_x].isEmpty()) {
                        int max = Integer.MIN_VALUE;
                        for (int j = 0; j < map[B_y][B_x].size(); j++) {
                            max = Math.max(max, map[B_y][B_x].get(j).getPower());
                        }
                        sum += max;
                    }
                } else if (map[B_y][B_x].isEmpty()) {
                    if (!map[A_y][A_x].isEmpty()) {
                        int max = Integer.MIN_VALUE;
                        for (int j = 0; j < map[A_y][A_x].size(); j++) {
                            max = Math.max(max, map[A_y][A_x].get(j).getPower());
                        }
                        sum += max;
                    }
                } else {
                    int max = Integer.MIN_VALUE;
                    for (int j = 0; j < map[A_y][A_x].size(); j++) {
                        for (int k = 0; k < map[B_y][B_x].size(); k++) {
                            if (map[A_y][A_x].get(j).getIdx() == map[B_y][B_x].get(k).getIdx()) {
                                max = Math.max(max, map[A_y][A_x].get(j).getPower());
                            } else {
                                max = Math.max(max, map[A_y][A_x].get(j).getPower() + map[B_y][B_x].get(k).getPower());
                            }
                        }
                    }
                    sum += max;
                }
            }
            System.out.println("#" + tc + " " + sum);
        }
    }

    static void setDia(int x, int y, int c, int p, int idx) {
        for (int dx = -c; dx <= c; dx++) {
            int rem = c - Math.abs(dx);
            for (int dy = -rem; dy <= rem; dy++) {
                int nx = x + dx;
                int ny = y + dy;
                if (0 < nx && nx <= 10 && 0 < ny && ny <= 10) {
                    map[ny][nx].add(new Charge(idx, p));
                }
            }
        }
    }

    static class Charge {
        int idx;
        int power;

        public Charge(int idx, int power) {
            this.idx = idx;
            this.power = power;
        }

        public int getIdx() {
            return idx;
        }

        public int getPower() {
            return power;
        }
    }
}
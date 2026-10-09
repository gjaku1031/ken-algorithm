package sw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class sw1247 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int T;

    static Customer[] customers;
    static boolean[] visited;
    // up down left right
    static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    static int start_r;
    static int start_c;
    static int end_r;
    static int end_c;

    static int N;
    static int result;

    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine());

            customers = new Customer[N];
            visited = new boolean[N];


            st = new StringTokenizer(br.readLine());
            start_r = Integer.parseInt(st.nextToken());
            start_c = Integer.parseInt(st.nextToken());

            end_r = Integer.parseInt(st.nextToken());
            end_c = Integer.parseInt(st.nextToken());

            for (int i = 0; i < N; i++) {
                int r = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                customers[i] = new Customer(r, c);
            }

            result = Integer.MAX_VALUE;
            for (int i = 0; i < N; i++) {
                int distance = distance(start_r, start_c, customers[i].getR(), customers[i].getC());
                visited[i] = true;
                bt(i, distance, 1);
                visited[i] = false;
            }
            System.out.println("#" + tc + " " + result);
        }
    }

    static void bt(int current, int sum, int level) {
        if (level == N) {
            int distance = distance(customers[current].getR(), customers[current].getC(), end_r, end_c);
            result = Math.min(result, sum+distance);
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                int distance = distance(customers[current].getR(), customers[current].getC(),
                                        customers[i].getR(), customers[i].getC());
                bt(i, distance + sum, level + 1);
                visited[i] = false;
            }
        }
    }

    static int distance(int x1, int y1, int x2, int y2) {
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }

    static class Customer {
        int r;
        int c;

        public int getR() {
            return r;
        }

        public int getC() {
            return c;
        }

        public Customer(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }


}


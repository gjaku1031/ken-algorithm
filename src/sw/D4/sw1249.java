package sw.D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class sw1249 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int T, N;

    static int[][] map;
    static int[][] dist; //Stores minimum repair cost
    static int INFINITY_NUM = Integer.MAX_VALUE;
    static PriorityQueue<Node> pr;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine());
            map = new int[N][N];
            dist = new int[N][N];

            pr = new PriorityQueue<>();

            //Input
            for (int i = 0; i < N; i++) {
                String str = br.readLine();
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(Character.toString(str.charAt(j)));
                }
            }
            dijkstra();
            System.out.println("#" + tc + " " + dist[N - 1][N - 1]);
        }
    }

    static void dijkstra() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                dist[i][j] = INFINITY_NUM; //Initialize to max
            }
        }

        dist[0][0] = map[0][0];
        pr.add(new Node(map[0][0], 0, 0));

        while (!pr.isEmpty()) {
            Node current = pr.poll();
            int current_cost = current.getCost();
            int current_r = current.getRow();
            int current_c = current.getCol();

            //Skip if a shorter path is already stored
            if (current_cost > dist[current_r][current_c]) {
                continue;
            }

            for (int i = 0; i < 4; i++) {
                int nr = current_r + dr[i];
                int nc = current_c + dc[i];

                // Bounds check
                if (nr < 0 || nr >= N || nc < 0 || nc >= N) {
                    continue;
                }

                int new_cost = current_cost + map[nr][nc];

                if (new_cost < dist[nr][nc]) {
                    dist[nr][nc] = new_cost;
                    pr.add(new Node(new_cost, nr, nc));
                }
            }
        }
    }


    static class Node implements Comparable<Node> {
        int cost;
        int row;
        int col;

        public Node(int cost, int row, int col) {
            this.cost = cost;
            this.row = row;
            this.col = col;
        }

        public int getCost() {
            return cost;
        }

        public int getRow() {
            return row;
        }

        public int getCol() {
            return col;
        }

        @Override
        public int compareTo(Node other) {
            return this.cost - other.cost;
        }
    }
}
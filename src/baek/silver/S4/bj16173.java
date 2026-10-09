package baek.silver.S4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class bj16173 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N;

    static Node[][] square;
    //right, down
    static int[] dc = {0, 1};
    static int[] dr = {1, 0};

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        square = new Node[N][N];


        // input
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int move = Integer.parseInt(st.nextToken());
                square[i][j] = new Node(i, j);
                square[i][j].setMove(move);
            }
        }
        BFS();
    }

    static void BFS() {
        Deque<Node> deq = new ArrayDeque<>();
        deq.add(square[0][0]);
        int rest_move = square[0][0].getMove();

        while (!deq.isEmpty()) {
            Node current = deq.pollFirst();
            int current_c = current.getC();
            int current_r = current.getR();
            if (current_c == N - 1 && current_r == N - 1) {
                System.out.println("HaruHaru");
                return;
            }
            for (int i = 0; i < rest_move; i++) {
                for (int j = 0; j < 2; j++) {
                    int next_c = current_c + dc[i];
                    int next_r = current_r + dr[i];
                    if (valid(next_c, next_r)) {

                    }
                }
            }
        }
        System.out.println("Hing");
    }

    static boolean valid(int r, int c) {
        return 0 <= r && r < N && 0 <= c && c < N;
    }

    static class Node {
        int c;
        int r;
        int move;

        public Node(int c, int r) {
            this.c = c;
            this.r = r;
        }

        public int getC() {
            return c;
        }

        public int getR() {
            return r;
        }

        public int getMove() {
            return move;
        }

        public void setMove(int move) {
            this.move = move;
        }
    }
}

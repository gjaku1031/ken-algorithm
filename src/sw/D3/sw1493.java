package sw.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class sw1493 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int T;

    static Coordinate[] bo = new Coordinate[10001];

    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine());
        init();

        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());

            int p_x = bo[p].getX();
            int p_y = bo[p].getY();
            int q_x = bo[q].getX();
            int q_y = bo[q].getY();

            int nx = p_x + q_x;
            int ny = p_y + q_y;

            int S = nx + ny;

            /** (Formula derivation)
             * Number of points in the diagonal group with sum S -> (S - 1)
             * 
             * 1 + 2 + 3 + ... + (S - 2)
             * == ((S - 2) * (S - 1) / 2) : arithmetic series sum
             */
            int resultValue = ((S - 2) * (S - 1) / 2) + nx;

            System.out.println("#" + tc + " " + resultValue);
        }
    }

    static void init() {
        int idx = 1;
        for (int sum = 2; idx <= 10001; sum++) {
            for (int x = 1; x < sum; x++) {
                if (idx >= bo.length) {
                    return;
                }
                int y = sum - x;
                bo[idx] = new Coordinate(x, y, idx);
                idx++;
            }
        }
    }

    static class Coordinate {
        int x;
        int y;
        int count;

        public Coordinate(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
    }
}

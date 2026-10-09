package sw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class sw4013 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int T;

    static Deque<Integer>[] magnet;
    static int K;
    static int result;

    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            K = Integer.parseInt(br.readLine());
            result = 0;

            magnet = new Deque[4];
            for (int i = 0; i < 4; i++) {
                magnet[i] = new ArrayDeque<>();
            }

            for (int i = 0; i < 4; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 8; j++) {
                    magnet[i].addLast(Integer.parseInt(st.nextToken()));
                }
            }

            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int r = Integer.parseInt(st.nextToken());
                int d = Integer.parseInt(st.nextToken()); // 1: clockwise, -1: counterclockwise
                rotate(r, d);
            }

            score();
            System.out.println("#" + tc + " " + result);
        }
    }

    static void rotate(int r, int d) {
        int idx = r - 1;
        int[] dir = new int[4];
        dir[idx] = d;

        // Left
        for (int i = idx - 1; i >= 0; i--) {
            int rightPol = getAt(magnet[i], 2);
            int leftPolN = getAt(magnet[i + 1], 6);
            if (rightPol != leftPolN) {
                dir[i] = -dir[i + 1];
            } else break;
        }

        // Right
        for (int i = idx + 1; i < 4; i++) {
            int rightPolL = getAt(magnet[i - 1], 2);
            int leftPol   = getAt(magnet[i], 6);
            if (rightPolL != leftPol) {
                dir[i] = -dir[i - 1];
            } else break;
        }

        for (int i = 0; i < 4; i++) {
            if (dir[i] == 1) { // Clockwise
                magnet[i].addFirst(magnet[i].pollLast());
            } else if (dir[i] == -1) { // Counterclockwise
                magnet[i].addLast(magnet[i].pollFirst());
            }
        }
    }

    static int getAt(Deque<Integer> dq, int idx) {
        int i = 0;
        for (int v : dq) {
            if (i == idx) return v;
            i++;
        }
        return -1;
    }

    static void score() {
        for (int i = 0; i < 4; i++) {
            if (magnet[i].getFirst() == 1) {
                result += (int) Math.pow(2, i);
            }
        }
    }
}

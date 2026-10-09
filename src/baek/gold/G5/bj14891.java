package baek.gold.G5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class bj14891 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static Deque<Integer>[] magnet;
    static int K;
    static int result;

    public static void main(String[] args) throws IOException {
        result = 0;

        magnet = new Deque[4];
        for (int i = 0; i < 4; i++) {
            magnet[i] = new ArrayDeque<>();
        }

        for (int i = 0; i < 4; i++) {
            String line = br.readLine().trim();
            for (int j = 0; j < 8; j++) {
                magnet[i].addLast(line.charAt(j) - '0');
            }
        }

        K = Integer.parseInt(br.readLine().trim());

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            rotate(r, d);
        }

        score();
        System.out.println(result);
    }

    static void rotate(int r, int d) {
        int idx = r - 1; // 0-based
        int[] dir = new int[4];
        dir[idx] = d;

        for (int i = idx - 1; i >= 0; i--) {
            int rightPol = getAt(magnet[i], 2);
            int leftPolN = getAt(magnet[i + 1], 6);
            if (rightPol != leftPolN) dir[i] = -dir[i + 1];
            else break;
        }


        for (int i = idx + 1; i < 4; i++) {
            int rightPolL = getAt(magnet[i - 1], 2);
            int leftPol   = getAt(magnet[i], 6);
            if (rightPolL != leftPol) dir[i] = -dir[i - 1];
            else break;
        }


        for (int i = 0; i < 4; i++) {
            if (dir[i] == 1) { // clockwise
                magnet[i].addFirst(magnet[i].pollLast());
            } else if (dir[i] == -1) { // counterclockwise
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

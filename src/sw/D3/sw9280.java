package sw.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class sw9280 {
    static int n, m;
    static int[] R, W, park;
    static Deque<Integer> wait;
    static int result;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            R = new int[n];
            W = new int[m];
            park = new int[n];
            Arrays.fill(park, -1);
            wait = new ArrayDeque<>();
            result = 0;

            for (int i = 0; i < n; i++) {
                R[i] = Integer.parseInt(br.readLine());
            }
            for (int i = 0; i < m; i++) {
                W[i] = Integer.parseInt(br.readLine());
            }

            for (int i = 0; i < 2 * m; i++) {
                int carIdx = Integer.parseInt(br.readLine());
                if (carIdx > 0) {
                    parkIn(carIdx - 1);
                } else {
                    parkOut(-carIdx - 1);
                }
            }
            System.out.println("#" + tc + " " + result);
        }
    }

    // Car enters
    static void parkIn(int car) {
        int idx = findEmptySpot();
        if (idx != -1) {
            park[idx] = car;
        } else {
            wait.offer(car);
        }
    }

    // Car exits
    static void parkOut(int car) {
        int idx = findCarSpot(car);
        result += R[idx] * W[car];
        park[idx] = -1;
        if (!wait.isEmpty()) {
            int nextCar = wait.poll();
            park[idx] = nextCar;
        }
    }

    // Find an empty spot
    static int findEmptySpot() {
        for (int i = 0; i < n; i++) {
            if (park[i] == -1) return i;
        }
        return -1;
    }

    // Find the parked car's spot
    static int findCarSpot(int car) {
        for (int i = 0; i < n; i++) {
            if (park[i] == car) return i;
        }
        return -1;
    }
}
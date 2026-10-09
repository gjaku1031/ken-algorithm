package sw.D4;

import java.io.IOException;
import java.util.*;

public class sw4796 {
    static Scanner sc = new Scanner(System.in);
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int T;

    static int N;
    static int[] height;
    static int[] right_h;
    static int[] left_h;

    public static void main(String[] args) throws IOException {
        T = sc.nextInt();
        for (int tc = 1; tc <= T; tc++) {
            // Input
            N = sc.nextInt();

            height = new int[N];
            for (int i = 0; i < N; i++) {
                height[i] = sc.nextInt();
            }

            right_h = new int[N];
            left_h = new int[N];

            // Logic
            Deque<Integer> deque = new ArrayDeque<>();
            for (int i = 0; i < N; i++) {
                while (!deque.isEmpty() && height[deque.peekLast()] < height[i]) {
                    int idx = deque.pollFirst();
                    right_h[idx] = deque.size();
                }
                deque.addLast(i);
            }
            while (!deque.isEmpty()) {
                int idx = deque.pollFirst();
                right_h[idx] = deque.size();
            }
            deque.clear();
            for (int i = N - 1; i >= 0; i--) {
                while (!deque.isEmpty() && height[deque.peekLast()] < height[i]) {
                    int idx = deque.pollFirst();
                    left_h[idx] = deque.size();
                }
                deque.addLast(i);
            }
            while (!deque.isEmpty()) {
                int idx = deque.pollFirst();
                left_h[idx] = deque.size();
            }

            int result = 0;
            for (int i = 0; i < N; i++) {
                result += right_h[i] * left_h[i];
            }
            // Output
            sb.append("#" + tc + " " + result).append("\n");
        }
        System.out.println(sb);
    }
}
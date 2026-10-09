package sw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class sw5685 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int T;

    static int N, K;
    static Deque<Integer> deque;
    static TreeSet<Integer> set;

    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            // Input
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            deque = new ArrayDeque<>();
            set = new TreeSet<>();
            String line = br.readLine();
            for (char ch : line.toCharArray()) {
                if (ch >= 'A') {
                    deque.addLast(ch - 'A' + 10);
                } else {
                    deque.addLast(ch - '0');
                }
            }

            // Compute initial state
            for (int i = 0; i < N / 4; i++) {
                cal();
                deque.addFirst(deque.pollLast());
            }

            Iterator<Integer> it = set.descendingIterator();
            int ans = 0;
            for (int i = 0; i < K; i++) {
                ans = it.next();
            }



            System.out.println("#" + tc + " " + ans);
        }
    }

    static void cal() {
        int val = 0, cnt = 0;
        for (int d : deque) {
            val = (val << 4) + d;
            cnt++;
            if (cnt % (N / 4) == 0) {
                set.add(val);
                val = 0;
            }
        }
    }
}

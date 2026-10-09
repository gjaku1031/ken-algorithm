package baek.silver.S1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.StringTokenizer;

public class bj9934 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static Deque<Integer> deq = new ArrayDeque<>();
    static ArrayList<Integer>[] tree;
    static StringTokenizer st;
    static int N;
    static StringBuilder[] sbs;



    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        sbs = new StringBuilder[N];
        for (int i = 0; i < N; i++) {
            sbs[i] = new StringBuilder();
        }

        //read input
        st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()) {
            deq.addLast(Integer.parseInt(st.nextToken()));

        }
        setTree(0, N);

        for (int i = 0; i < N; i++) {
            System.out.println(sbs[N - i - 1]);
        }
    }

    static void setTree(int level, int maxLevel) {
        if (level == maxLevel) {
            return;
        }

        int size = (int) Math.pow(2, maxLevel - level);
        for (int i = 1; i <= size-1; i++) {
            if (i % 2 == 1) {
                sbs[level].append(deq.pollFirst()).append(" ");
            } else {
                deq.addLast(deq.pollFirst());
            }
        }
        setTree(level + 1, maxLevel);
    }
}

package sw.D5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class sw3421 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;


    static int T;
    static int N, M;
    static List<Integer>[] graph;

    static boolean[] selected;
    static int[] order;
    static long ans;

    static final boolean INCLUDE_EMPTY = true;

    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            //Input
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            graph = new ArrayList[N + 1];
            for (int i = 1; i <= N; i++) graph[i] = new ArrayList<>();

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                graph[a].add(b);
                graph[b].add(a);
            }


            selected = new boolean[N + 1];
            ans = 0L;
            // Sort so more pruning happens early
            order = buildSearchOrderByDegreeDesc();

            dfs(0);
            long result = INCLUDE_EMPTY ? ans : (ans - 1);
            System.out.println("#" + tc + " " + result);
        }
    }

    static int[] buildSearchOrderByDegreeDesc() {
        Integer[] nodes = new Integer[N]; //So that a Comparator can be used
        for (int i = 0; i < N; i++) {
            nodes[i] = i + 1;
        };

        Arrays.sort(nodes, (u, v) -> {
            int du = graph[u].size();
            int dv = graph[v].size();
            if (du != dv) {
                return Integer.compare(dv, du);
            }
            return Integer.compare(u, v);
        });

        int[] ord = new int[N];
        for (int i = 0; i < N; i++) {
            ord[i] = nodes[i];
        }
        return ord;
    }

    static void dfs(int pos) {
        if (pos == N) {
            ans++;
            return;
        }
        int node = order[pos];

        if (canSelect(node)) {
            selected[node] = true;
            dfs(pos + 1);
            selected[node] = false;
        }
        dfs(pos + 1);
    }
    static boolean canSelect(int node) {
        for (int nei : graph[node]) {
            if (selected[nei]) {
                return false;
            }
        }
        return true;
    }
}

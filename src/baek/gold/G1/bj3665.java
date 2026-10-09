package baek.gold.G1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class bj3665 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int T;

    static int n, m;
    static int[] arr;

    static List<Integer>[] graph;
    static int[] indegree;

    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < T; tc++) {
            init();
            topologicalSort();

        }
    }

    private static void init() throws IOException {
        n = Integer.parseInt(br.readLine());
        indegree = new int[n + 1];
        arr = new int[n + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        graph = new List[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                graph[arr[i]].add(arr[j]);
                indegree[arr[j]]++;
            }
        }

        m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (graph[a].contains(b)) {
                graph[a].remove((Integer) b);
                indegree[b]--;

                graph[b].add(a);
                indegree[a]++;
            } else {
                graph[b].remove((Integer) a);
                indegree[a]--;

                graph[a].add(b);
                indegree[b]++;
            }
        }
    }

    static void topologicalSort() {
        Queue<Integer> que = new ArrayDeque<>();
        List<Integer> order = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= n; i++) {
            if (indegree[i] == 0) {
                que.add(i);
            }
        }

        boolean isAmbiguous = false;

        while (!que.isEmpty()) {

            // if the queue holds 2 or more elements, the ranking cannot be uniquely determined.
            if (que.size() > 1) {
                isAmbiguous = true;
            }

            int node = que.poll();
            order.add(node);

            for (int nextNode : graph[node]) {
                indegree[nextNode]--;
                if (indegree[nextNode] == 0) {
                    que.add(nextNode);
                }
            }
        }

        // 1. cycle detection (IMPOSSIBLE)
        if (order.size() < n) {
            System.out.println("IMPOSSIBLE");
        }
        // 2. check whether there are multiple results (?)
        else if (isAmbiguous) {
            System.out.println("?");
        }
        // 3. a unique ranking is determined
        else {
            for (int team : order) {
                sb.append(team).append(" ");
            }
            System.out.println(sb.toString().trim());
        }
    }
}
package baek.gold.G2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Array;
import java.util.*;

public class bj1766 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, M; // N: number of problems, M: number of "better solved first" pairs

    static List<Integer>[] graph;
    static int[] indegree;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new List[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        indegree = new int[N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            indegree[b]++;
        }
        topologicalSort();
    }

    static void topologicalSort() {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        List<Integer> order = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            if (indegree[i] == 0) {
                pq.add(i);
            }
        }

        while (!pq.isEmpty()) {
            int size = pq.size();

            for (int i = 0; i < size; i++) {
                int node = pq.poll();
                order.add(node);

                for (int j = 0; j < graph[node].size(); j++) {
                    int now = graph[node].get(j);
                    indegree[now]--;
                    if (indegree[now] == 0) {
                        pq.add(now);
                    }
                }
            }


        }
        for (Integer i : order) {
            sb.append(i).append(" ");
        }
        System.out.println(sb);

    }
}

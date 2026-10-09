package baek.gold.G4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class bj1753 {
    static final long INF = (long) 1e18; // 1e18

    static class Edge {
        int to, w;

        Edge(int to, int w) {
            this.to = to;
            this.w = w;
        }
    }

    static class State implements Comparable<State> {
        int v;
        long d; // vertex, distance so far

        State(int v, long d) {
            this.v = v;
            this.d = d;
        }

        public int compareTo(State o) {
            return Long.compare(this.d, o.d);
        }
    }

    private static long[] dijkstra(int V, int K, List<Edge>[] g) {
        long[] dist = new long[V + 1];
        Arrays.fill(dist, INF);
        PriorityQueue<State> pq = new PriorityQueue<>();

        dist[K] = 0;
        pq.add(new State(K, 0));

        while (!pq.isEmpty()) {
            State cur = pq.poll();
            if (cur.d != dist[cur.v]) continue; // skip stale (outdated) entries

            for (Edge e : g[cur.v]) {
                long nd = cur.d + e.w;          // candidate distance for relaxation
                if (nd < dist[e.to]) {
                    dist[e.to] = nd;            // relaxation
                    pq.add(new State(e.to, nd));
                }
            }
        }
        return dist;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(br.readLine().trim());

        List<Edge>[] g = new ArrayList[V + 1];
        for (int i = 1; i <= V; i++) g[i] = new ArrayList<>();

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            g[u].add(new Edge(v, w)); // directed graph
        }

        long[] dist = dijkstra(V, K, g);

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= V; i++) {
            sb.append(dist[i] == INF ? "INF" : Long.toString(dist[i])).append('\n');
        }
        System.out.print(sb);
    }
}
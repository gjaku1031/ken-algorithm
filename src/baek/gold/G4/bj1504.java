package baek.gold.G4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class bj1504 {
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
        long d;

        State(int v, long d) {
            this.v = v;
            this.d = d;
        }

        public int compareTo(State o) {
            return Long.compare(this.d, o.d);
        }
    }

    static int N, E;
    static List<Edge>[] g;

    static long[] dijkstra(int s) {
        long[] dist = new long[N + 1];
        Arrays.fill(dist, INF);
        PriorityQueue<State> pq = new PriorityQueue<>();
        dist[s] = 0;
        pq.add(new State(s, 0));

        while (!pq.isEmpty()) {
            State cur = pq.poll();
            if (cur.d != dist[cur.v]) continue; // skip stale entries

            for (Edge e : g[cur.v]) {
                long nd = cur.d + e.w;          // relaxation candidate
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
        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        List<Edge>[] tmp = new ArrayList[N + 1];
        g = tmp;
        for (int i = 1; i <= N; i++) g[i] = new ArrayList<>();

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            g[a].add(new Edge(b, c));
            g[b].add(new Edge(a, c)); // undirected
        }

        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        long[] d1 = dijkstra(1);
        long[] dv1 = dijkstra(v1);
        long[] dv2 = dijkstra(v2);

        long path1 = d1[v1] + dv1[v2] + dv2[N]; // 1→v1→v2→N
        long path2 = d1[v2] + dv2[v1] + dv1[N]; // 1→v2→v1→N

        long ans = Math.min(path1, path2);
        System.out.println(ans >= INF ? -1 : ans);
    }
}

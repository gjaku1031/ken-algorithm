package sw.D4;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class sw3289 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int T;
    static int N, M;

    static StringBuilder result;

    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            //Input
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            UnionFind unionFind = new UnionFind();
            result = new StringBuilder();
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int input = Integer.parseInt(st.nextToken());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                if (input == 0) {
                    unionFind.union(a, b);
                } else {
                    result.append(unionFind.same(a, b) ? 1 : 0);
                }

            }
            //Output
            System.out.println("#" + tc + " " + result);
        }
    }

    static class UnionFind {
        int[] parent;
        int[] rank;

        // Constructor -- init
        UnionFind() {
            parent = new int[N + 1];
            rank = new int[N + 1];
            for (int i = 1; i <= N; i++) {
                parent[i] = i;
                rank[i] = 0;
            }
        }


        int find(int x) {
            if (parent[x] != x) parent[x] = find(parent[x]); //path compression
            return parent[x];
        }

        boolean union(int a, int b) {
            int ra = find(a), rb = find(b);
            if (ra == rb) return false;

            // Higher rank becomes the parent
            if (rank[ra] < rank[rb]) {
                parent[ra] = rb;
            } else if (rank[ra] > rank[rb]) {
                parent[rb] = ra;
            } else {
                parent[rb] = ra;
                rank[ra]++; // Same height, so increase by one
            }
            return true;
        }

        boolean same(int a, int b) {
            return find(a) == find(b);
        }
    }
}
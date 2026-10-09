package sw.D3;

import static java.lang.Math.max;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class sw2814 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int T;

    static int N, M;
    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static int maxLen;

    public static void main(String[] args) throws IOException {

        T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            graph = new ArrayList[N + 1];
            for (int i = 0; i <= N; i++) {
                graph[i] = new ArrayList<>();
            }

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());

                //Undirected
                graph[u].add(v);
                graph[v].add(u);
            }

            maxLen = 1;
            visited = new boolean[N + 1];

            BTC();
            sb.append("#").append(tc).append(" ").append(maxLen).append("\n");
        }
        System.out.println(sb);
    }

    private static void BTC() {
        for (int i = 1; i <= N; i++) {
            visited[i] = true;
            DFS(i, 1);
            visited[i] = false;
        }
    }

    // v: 
    static void DFS(int u, int length) {
        maxLen = max(maxLen, length);
        for (int v : graph[u]) {
            if (!visited[v]) {
                visited[v] = true;
                DFS(v, length + 1);
                visited[v] = false;
            }
        }
    }
}
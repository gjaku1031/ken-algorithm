package baek.step.mst;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class bj9372 {
    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static int answer, N, M;




    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            StringTokenizer st0 = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st0.nextToken());
            M = Integer.parseInt(st0.nextToken());

            // Prepare BFS
            visited = new boolean[N + 1];
            graph = new ArrayList[N + 1];

            // Start N-th try
            for (int j = 1; j <= N; j++) {
                graph[j] = new ArrayList<>();
            }

            for (int j = 0; j < M; j++) {
                StringTokenizer st1 = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st1.nextToken());
                int b = Integer.parseInt(st1.nextToken());
                graph[a].add(b);
                graph[b].add(a);
            }
            answer = 0;
            visited[1] = true;
            DFS(3);
            System.out.println(answer);
// Track parents separately


        }
    }

    public static void DFS(int v) {
        for (int i = 0; i < graph[v].size(); i++) {
            int x = graph[v].get(i);
            if (!visited[x]) {
                visited[x] = true;
                answer++;
                DFS(x);
            }
        }
    }
}
// Minimum spanning tree

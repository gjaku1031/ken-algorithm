package baek.step.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.StringTokenizer;

public class bj1707 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static ArrayList<Integer>[] graph;
    static StringTokenizer st;
    static int[] visited; // Also stores the color
    static int K, V, E;

    public static void main(String[] args) throws IOException {
        K = Integer.parseInt(br.readLine());
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());

            visited = new int[V + 1];
            graph = new ArrayList[V + 1];

            for (int j = 0; j <= V; j++) {
                graph[j] = new ArrayList<>();
            }

            for (int j = 0; j < E; j++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                graph[a].add(b);
                graph[b].add(a);
            }
            BFS();
        }
    }

    static void BFS() {
        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 1; i <= V; i++) {
            if (visited[i] == 0) {
                deque.add(i);
                visited[i] = 1;
            }
            while (!deque.isEmpty()) {
                int now = deque.pollFirst();

                for (int j = 0; j < graph[now].size(); j++) {
                    int next = graph[now].get(j);

                    // First visit
                    if (visited[next] == 0) {
                        deque.add(next);
                    }

                    // Return if same color
                    if (visited[next] == visited[now]) {
                        System.out.println("NO");
                        return;
                    }

                    // Paint with the other color
                    if (visited[now] == 1 && visited[next] == 0) {
                        visited[next] = 2;
                    } else if (visited[now] == 2 && visited[next] == 0) {
                        visited[next] = 1;
                    }
                }
            }
        }
        System.out.println("YES");
    }
}

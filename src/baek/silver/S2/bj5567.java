package baek.silver.S2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class bj5567 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static List<Integer>[] graph;
    static StringTokenizer st;
    static boolean[] visited;
    static int n, m;
    static int count;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        visited = new boolean[n + 1];
        graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[a].add(b);
            graph[b].add(a);
        }
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(1);
        visited[1] = true;

        int now = queue.poll();
        for (int i = 0; i < graph[now].size(); i++) {
            int next = graph[now].get(i);
            if (!visited[next]) {
                count++;
                visited[next] = true;
                queue.offer(next);
            }
        }
        int loopSize = queue.size(); //because the queue size changes dynamically
        for (int i = 0; i < loopSize; i++) {
            now = queue.poll();
            for (int j = 0; j < graph[now].size(); j++) {
                int next = graph[now].get(j);
                if (!visited[next]) {
                    count++;
                    visited[next] = true;
                }
            }
        }
        System.out.println(count);
    }
}

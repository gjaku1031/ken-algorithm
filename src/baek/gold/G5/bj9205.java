package baek.gold.G5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class bj9205 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int t, n;
    static int[] home, festival;


    static List<int[]> conveniences;
    static boolean[] visited;
    static String result;


    public static void main(String[] args) throws IOException {
        // Input
        t = Integer.parseInt(br.readLine());


        for (int tc = 0; tc < t; tc++) {
            n = Integer.parseInt(br.readLine());
            result = "sad";

            // home
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            home = new int[]{a, b};

            // convenience stores
            conveniences = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                conveniences.add(new int[]{x, y});
            }

            // festival
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            festival = new int[]{a, b};

            visited = new boolean[conveniences.size()];
            bfs();
            System.out.println(result);
        }
    }

    static void bfs() {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(home);

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            if (dist(festival, cur) <= 1000) {
                result = "happy";
                return;
            }
            for (int i = 0; i < conveniences.size(); i++) {
                if (!visited[i] && dist(cur, conveniences.get(i)) <= 1000) {
                    visited[i] = true;
                    queue.add(conveniences.get(i));
                }
            }
        }
    }

    static int dist(int[] idx1, int[] idx2) {
        return Math.abs(idx1[0] - idx2[0]) + Math.abs(idx1[1] - idx2[1]);
    }
}

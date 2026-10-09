package baek.silver.S3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj1966 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int T, N, M;
    static Queue<Integer> queue = new ArrayDeque<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            int count = 0;

            //setting
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                queue.add(Integer.parseInt(st.nextToken()));
            }

            while (true) {
                int a = queue.peek();

                if (queue.stream().anyMatch(num -> num > a)) { //a document with higher priority than the current one exists
                    int b = queue.poll();
                    queue.add(b);
                    if (M == 0) {
                        M = queue.size() - 1;
                    } else {
                        M--;
                    }
                } else if (M == 0) {
                    count++;
                    sb.append(count).append("\n");
                    queue.clear();
                    break;
                } else {
                    queue.poll();
                    count++;
                    M--;
                }
            }
        }
        System.out.println(sb);
    }
}
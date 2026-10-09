package sw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.PriorityQueue;

public class sw2477 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int T;

    static int N, M, K, A, B;
    static int[] a, b;

    static int[][] receipt;
    static int[][] maintenance;

    static PriorityQueue<Integer> pq = new PriorityQueue<>(); // Unused, but kept from the original code

    static Queue<Integer> waiting1 = new ArrayDeque<>();
    static Queue<Integer> waiting2 = new ArrayDeque<>();

    static int result = 0;
    static int count = 0;
    static int[][] clientArr;

    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {

            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());

            a = new int[N + 1];
            b = new int[M + 1];
            clientArr = new int[K + 1][2];

            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++) a[i] = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= M; i++) b[i] = Integer.parseInt(st.nextToken());

            // Read customer arrival times
            int[] arrive = new int[K + 1];
            int maxT = 0;
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= K; i++) {
                arrive[i] = Integer.parseInt(st.nextToken());
                if (arrive[i] > maxT) maxT = arrive[i];
            }

            ArrayList<Integer>[] arriveAt = new ArrayList[maxT + 1 + 1];
            for (int i = 1; i <= K; i++) {
                int t = arrive[i];
                if (arriveAt[t] == null) arriveAt[t] = new ArrayList<>();
                arriveAt[t].add(i);
            }

            receipt = new int[N + 1][2];
            maintenance = new int[M + 1][2];
            waiting1.clear();
            waiting2.clear();
            result = 0;
            count = 0;

            int t = 0;
            while (count < K) {
                // Advance repair desk work and handle completion
                for (int j = 1; j <= M; j++) {
                    if (maintenance[j][0] != 0) {
                        maintenance[j][1]--;
                        if (maintenance[j][1] == 0) { // Repair done

                            maintenance[j][0] = 0;
                            count++;
                        }
                    }
                }

                // Advance reception desk work and move finished customers to the repair queue
                for (int i = 1; i <= N; i++) {
                    if (receipt[i][0] != 0) {
                        receipt[i][1]--;
                        if (receipt[i][1] == 0) {
                            int finishedClient = receipt[i][0];
                            receipt[i][0] = 0; // Free the desk
                            waiting2.add(finishedClient); // Added in reception desk order i, so the rule is satisfied
                        }
                    }
                }

                // Repair queue -> assign repair desk (empty desks in ascending number)
                for (int j = 1; j <= M; j++) {
                    if (maintenance[j][0] == 0 && !waiting2.isEmpty()) {
                        int client = waiting2.poll();
                        maintenance[j][0] = client;
                        maintenance[j][1] = b[j];
                        clientArr[client][1] = j; // Record the repair desk used
                    }
                }

                // Add customers arriving now to the reception queue (can be received on arrival)
                if (t < arriveAt.length && arriveAt[t] != null) {
                    for (int client : arriveAt[t]) waiting1.add(client);
                }

                // Reception queue -> assign reception desk
                for (int i = 1; i <= N; i++) {
                    if (receipt[i][0] == 0 && !waiting1.isEmpty()) {
                        int client = waiting1.poll();
                        receipt[i][0] = client;
                        receipt[i][1] = a[i];
                        clientArr[client][0] = i; // Record the reception desk used
                    }
                }

                t++;
            }

            for (int i = 1; i <= K; i++) {
                if (clientArr[i][0] == A && clientArr[i][1] == B) {
                    result += i;
                }
            }
            if (result == 0) result = -1;

            System.out.println("#" + tc + " " + result);
        }
    }
}

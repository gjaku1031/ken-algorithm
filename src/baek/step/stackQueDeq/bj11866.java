package baek.step.stackQueDeq;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj11866 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Josephus josephus = new Josephus(N, K);
        josephus.jose();
        josephus.joseResult();
    }

    static class Josephus {
        int N;
        int K;

        public Josephus(int n, int k) {
            this.N = n;
            this.K = k;
        }

        int div;
        Queue<Integer> que = new LinkedList<>();
        StringBuilder result = new StringBuilder("<");

        void setQue() {
            for (int i = 1; i <= N; i++) {
                que.add(i);
            }
        }

        void setNewDiv() {
            if (K % que.size() != 0) {
                div = K % que.size();
            } else {
                div = que.size();
            }
        }

        void jose() {
            //store people in the queue
            setQue();
            while (!que.isEmpty()) {
                setNewDiv();
                for (int i = 0; i < div - 1; i++) {
                    que.add(que.poll());
                }
                result.append(que.poll()).append(", ");
            }
        }

        void joseResult() {
            result.delete(result.length() - 2, result.length()).append(">");
            System.out.println(result);
        }
    }
}

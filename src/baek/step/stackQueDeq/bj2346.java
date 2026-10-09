package baek.step.stackQueDeq;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class bj2346 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] target = new int[N];
        for (int i = 0; i < N; i++) {
            target[i] = Integer.parseInt(st.nextToken());
        }
        Balloon balloon = new Balloon(N, target);
        balloon.setBalloons();
        balloon.explodeBalloon();
    }

    static class Balloon {
        int N;
        Deque<Integer> balloons = new ArrayDeque<>();
        int[] target;
        int nextTarget;
        StringBuilder sb = new StringBuilder();

        // Constructor
        public Balloon(int n, int[] target) {
            N = n;
            this.target = target;
        }

        // Set up balloons
        public void setBalloons() {
            for (int i = 1; i <= N; i++) {
                balloons.addLast(i);
            }
        }

        // Pop balloons
        public void explodeBalloon() {
            // First try
            nextTarget = target[0];
            sb.append(balloons.getFirst()).append(" ");
            balloons.pollFirst();

            while (balloons.size() > 1) {
                if (nextTarget > 0) {
                    for (int i = 0; i < nextTarget - 1; i++) {
                        balloons.addLast(balloons.pollFirst());
                    }
                    nextTarget = target[balloons.getFirst() - 1];
                    sb.append(balloons.pollFirst()).append(" ");
                } else {
                    for (int i = 0; i < Math.abs(nextTarget) - 1; i++) {
                        balloons.addFirst(balloons.pollLast());
                    }
                    nextTarget = target[balloons.getLast() - 1];
                    sb.append(balloons.pollLast()).append(" ");
                }
            }
            sb.append(balloons.getFirst());
            System.out.println(sb);
        }
    }
}
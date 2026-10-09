package baek.gold.G5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj11729 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        System.out.println((1 << N) - 1); //bit operation
        hanoi(N, 1, 3, 2);
        System.out.println(sb);
    }

    static void hanoi(int n, int from, int to, int via) {
        if (n == 1) {
            sb.append(from).append(" ").append(to).append("\n");
            return;
        }

        hanoi(n - 1, from, via, to);
        sb.append(from).append(" ").append(to).append("\n");
        hanoi(n - 1, via, to, from);
    }
}
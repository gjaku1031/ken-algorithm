package baek.step.math1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj2903 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        System.out.println((int) Math.pow(edge(N), 2));

    }

    //differences between terms
    static int diff(int N) {
        return (int) Math.pow(2, N - 1);
    }

    //one side
    static int edge(int N) {
        int sum = 2;
        for (int i = 1; i <= N; i++) {
            sum += diff(i);
        }
        return sum;
    }
}
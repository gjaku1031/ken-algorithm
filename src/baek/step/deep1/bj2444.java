package baek.step.deep1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj2444 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        //print up to row N
        for (int i = 0; i < N; i++) {
            // Print spaces for row i
            for (int j = 0; j < N - 1 - i; j++) {
                System.out.print(" ");
            }
            // Print * for row i
            for (int j = 0; j < 2 * i + 1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        for (int i = 1; i < N; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < 2 * (N - i) - 1; j++) {
                System.out.print("*");
            }
            //remove spaces on the last line
            if (i != N - 1) {
                System.out.println();
            }
        }
    }
}

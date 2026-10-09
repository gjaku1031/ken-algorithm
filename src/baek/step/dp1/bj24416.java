package baek.step.dp1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj24416 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int count1 = 1;
    static int count2 = 1;

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        fibo2(n);
        System.out.println(count1 + " " + count2);
    }

    // Recursion
    static int fibo1(int n) {

        if (n == 1 || n == 2) {
            return 1;
        } else {
            count1++;
            return fibo1(n - 1) + fibo1(n - 2);
        }
    }

    // DP
    static void fibo2(int n) {
        if (n == 1 || n == 2) {
            return;
        }
        int a = 1;
        int b = 1;
        for (int i = 3; i < n; i++) {
            int temp = a;
            b = a + b;
            a = temp;
            count2++;
        }
    }
}

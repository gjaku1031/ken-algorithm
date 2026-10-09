package baek.step.divMulPrimes2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj17103 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int T;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine());
        boolean[] isNotPrime = new boolean[1000001]; // false means prime
        isNotPrime[0] = isNotPrime[1] = true;

        for (int i = 2; i < 1000; i++) {
            if (!isNotPrime[i]) {
                for (int j = i * i; j <= 1000000; j += i) {
                    isNotPrime[j] = true;
                }
            }
        }

        while (T-- > 0) {
            int a = Integer.parseInt(br.readLine());
            int count = 0;
            for (int i = 2; i <= a / 2; i++) {
                if (!isNotPrime[i] && !isNotPrime[a - i]) {
                    count++;
                }
            }
            sb.append(count).append("\n");
        }
        System.out.println(sb);
    }
}
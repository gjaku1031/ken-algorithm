package baek.step.divMulPrimes1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj2581 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int min = Integer.parseInt(br.readLine());
        int max = Integer.parseInt(br.readLine());
        int sum = 0;
        int firstDec = 0;
        for (int i = min; i <= max; i++) {

            // First prime
            if (isPrime(i) && sum == 0 && i != 1) {
                firstDec = i;
                sum += i;
                // Second prime
            } else if (isPrime(i) && i != 1) {
                sum += i;
            }
        }

        if (sum == 0) {
            System.out.println(-1);
        } else {
            System.out.println(sum);
            System.out.println(firstDec);
        }

    }

    static boolean isPrime(int n) {
        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}

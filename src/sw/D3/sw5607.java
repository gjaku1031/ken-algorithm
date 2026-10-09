package sw.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class sw5607 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int T;

    static long[] factorial = new long[1000001];
    static int MOD = 1234567891;

    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine());

        factorial[0] = 1;
        for (int i = 1; i < 1000001; i++) {
            factorial[i] = (factorial[i - 1] * i) % MOD;
        }

        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int R = Integer.parseInt(st.nextToken());

            long c1 = factorial[N] % MOD;
            long c2 = factorial[N - R] * factorial[R] % MOD;

            //Fermat's little theorem
            // a ^ (-1) ≡ a ^ (MOD - 2) (mod 1234567891)
            long c3 = pow(c2, MOD - 2); 

            System.out.println("#" + tc + " " + (c1 * c3 % MOD));
        }
    }

    // Divide and conquer
    // Compute n^k mod 1234567891
    static long pow(long n, long k) {
        if (k == 1) {
            return n;
        }
        long x = pow(n, k / 2) % MOD;
        if (k % 2 == 0) {
            return x * x % MOD;
        } else {
            return ((x * x) % MOD * n) % MOD;
        }
    }
}

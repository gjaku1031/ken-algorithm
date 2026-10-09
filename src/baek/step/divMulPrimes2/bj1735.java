package baek.step.divMulPrimes2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj1735 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int x1, x2, y1, y2;

    public static void main(String[] args) throws IOException {
        // Read input
        st = new StringTokenizer(br.readLine());
        x1 = Integer.parseInt(st.nextToken());
        y1 = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        x2 = Integer.parseInt(st.nextToken());
        y2 = Integer.parseInt(st.nextToken());

        int x3 = x1 * y2 + x2 * y1;
        int y3 = y1 * y2;
        int n = Euclidean(x3, y3);
        System.out.println(x3 / n + " " + y3 / n);
    }

    static int Euclidean(int a, int b) {
        if (b == 0)
            return a;
        return Euclidean(b, a % b);
    }
}
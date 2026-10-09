package baek.step.brute;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj2839 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int result = equation(n);
        System.out.println(result);
    }

    static int equation(int n) {
        int x = 0;
        int y = 0;
        int min = -1;
        for (int i = 0; true; i++) {
            x = i;

            // Check if y is an integer; if not, skip the following statements
            if ((n - 3 * x) % 5 == 0) {
                y = (n - 3 * x) / 5;
            } else {
                continue;
            }
            // Exit the for loop if y is negative
            if (y < 0) {
                break;
            }
            if (min > x + y || min == -1) {
                min = x + y;
            }
        }
        return min;
    }
}
// 3x + 5y = n
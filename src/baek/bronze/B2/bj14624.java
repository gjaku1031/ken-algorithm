package baek.bronze.B2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj14624 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        // even case
        if (n % 2 == 0) {
            System.out.println("I LOVE CBNU");
        }
        // odd case - print the Jeonbuk National University logo shape
        else {
            // first line - n stars
            for (int i = 0; i < n; i++) {
                sb.append('*');
            }
            sb.append('\n');

            // from the second line - V shape
            int mid = n / 2;  // middle position

            for (int i = 0; i <= mid; i++) {
                // left spaces
                for (int j = 0; j < mid - i; j++) {
                    sb.append(' ');
                }

                // left star
                sb.append('*');

                // middle spaces
                if (i > 0) {
                    for (int j = 0; j < 2 * i - 1; j++) {
                        sb.append(' ');
                    }
                    // right star
                    sb.append('*');
                }

                sb.append('\n');
            }

            System.out.print(sb);
        }

        br.close();
    }
}

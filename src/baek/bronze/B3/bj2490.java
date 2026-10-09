package baek.bronze.B3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj2490 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        
        // Repeat for 3 test cases in total.
        for (int tc = 0; tc < 3; tc++) {
            st = new StringTokenizer(br.readLine());
            int sum = 0;
            // Read the 4 yut sticks and compute the sum.
            for (int i = 0; i < 4; i++) {
                sum += Integer.parseInt(st.nextToken());
            }

            // --- completed part starts here ---

            // sum is the number of backs (count of 1s).
            // The problem is based on the number of bellies (count of 0s).
            // Use a switch to print the result based on sum.
            switch (sum) {
                case 0: // 0 backs, 4 bellies -> yut (D)
                    System.out.println("D");
                    break;
                case 1: // 1 back, 3 bellies -> geol (C)
                    System.out.println("C");
                    break;
                case 2: // 2 backs, 2 bellies -> gae (B)
                    System.out.println("B");
                    break;
                case 3: // 3 backs, 1 belly -> do (A)
                    System.out.println("A");
                    break;
                case 4: // 4 backs, 0 bellies -> mo (E)
                    System.out.println("E");
                    break;
            }
        }
    }
}
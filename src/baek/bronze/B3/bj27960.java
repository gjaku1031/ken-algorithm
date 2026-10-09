package baek.bronze.B3;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class bj27960 {
    // Bitmasking key points
    // - Target scores are powers of 2: 1, 2, 4, 8, ...
    // - Viewing the sum of targets a person hit in binary,
    //   each bit (0 or 1) indicates whether that score's target was hit (1) or not (0).
    // - Sum of "targets hit by exactly one of A and B" = A XOR B (bitwise exclusive OR)
    //   Per-bit XOR truth table:
    //     A  B | A ^ B
    //     0  0 |   0   (neither hit → 0 in C)
    //     0  1 |   1   (only B hit → included in C)
    //     1  0 |   1   (only A hit → included in C)
    //     1  1 |   0   (both hit → excluded from C)
    //
    // Example)
    //   A = 13 (binary 1101 = 8+4+1), B = 10 (binary 1010 = 8+2)
    //   A ^ B = 0111 (binary) = 7 (4+2+1) → sum of targets hit by exactly one person
    //
    // Time/space complexity:
    //   - O(1), a single XOR on two integers

    public static void main(String[] args) throws Exception {
        // Input: A and B (integers) on one line
        // Output: A ^ B
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] parts = br.readLine().trim().split("\\s+");
        int A = Integer.parseInt(parts[0]);
        int B = Integer.parseInt(parts[1]);

        // XOR gives the sum of "targets hit by exactly one of the two"
        System.out.println(A ^ B);
    }
}

package baek.gold.G4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj10830 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int N;
    static long B;
    static long[][] A;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        B = Long.parseLong(st.nextToken());
        A = new long[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                A[i][j] = Long.parseLong(st.nextToken());
            }
        }
        long[][] result = recur(A, B);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(result[i][j] % 1000).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }

    static long[][] recur(long[][] matrix, long exp) {
        // if the exponent is 1, return the matrix as is
        if (exp == 1) {
            return matrix;
        }

        long[][] half = recur(matrix, exp / 2);

        long[][] squared = multiple(half, half);

        if (exp % 2 == 1) {
            return multiple(squared, A);
        }

        return squared;
    }

    static long[][] multiple(long[][] matrix_1, long[][] matrix_2) {
        long[][] matrix = new long[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    matrix[i][j] += matrix_1[i][k] * matrix_2[k][j] % 1000;
                }
            }
        }
        return matrix;
    }
}

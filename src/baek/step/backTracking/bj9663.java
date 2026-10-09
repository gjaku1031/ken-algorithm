package baek.step.backTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj9663 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    // Store queen positions in a 1D array - arr[i] = j means a queen at row i, column j
    static int[] queens;
    static int count = 0;
    static int N;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        queens = new int[N];
        nQueen(0);
        System.out.println(count);
    }
    
    static void nQueen(int depth) {
        if (depth == N) {
            count++;
            return;
        }
        
        // Try placing a queen in each column of row depth
        for (int i = 0; i < N; i++) {
            queens[depth] = i;
            
            // Check if a queen can be placed at the current position
            if (isValid(depth)) {
                nQueen(depth + 1);
            }
        }
    }
    
    static boolean isValid(int depth) {
        for (int i = 0; i < depth; i++) {
            // Check for the same column
            if (queens[depth] == queens[i]) {
                return false;
            }
            
            // Check for diagonals
            // Same row and column difference means on a diagonal
            if (Math.abs(queens[depth] - queens[i]) == Math.abs(depth - i)) {
                return false;
            }
        }
        return true;
    }
}
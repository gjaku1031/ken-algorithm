package baek.step.math1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj1193 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        if (findLine(N) % 2 == 0) {
            countEvenIdx(N);
            //System.out.println("Even = " + N);
        } else {
            countOddIdx(N);
            //System.out.println("Odd = " + N);
        }
    }
    // Find the max index of the n-th diagonal
    static int findMax(int n) {
        int max = 1;
        for (int i = 0; i < n; i++) {
            max += i;
        }
        return max;
    }

    // Find the diagonal containing N
    static int findLine(int N) {
        for (int i = 1; true; i++) {
            if (findMax(i) <= N && N < findMax(i + 1)) {
                return i;
            }
        }
    }


    // Count along odd diagonal
    static void countOddIdx(int N) {
        // First fraction of this diagonal
        int count = N - findMax(findLine(N));
        int mom = 1;
        int son = findLine(N) + 1 - mom;
        for (int i = 0; i < count; i++) {
            mom++;
            son--;
        }
        System.out.println(son + "/" + mom);
    }

    // Count along even diagonal
    static void countEvenIdx(int N) {
        // First fraction of this diagonal
        int count = N - findMax(findLine(N));

        int son = 1;
        int mom = findLine(N) + 1 - son;
        for (int i = 0; i < count; i++) {
            mom--;
            son++;
        }
        System.out.println(son + "/" + mom);
    }
}

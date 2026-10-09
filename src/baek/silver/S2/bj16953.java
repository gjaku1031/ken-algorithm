package baek.silver.S2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj16953 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static long A, B;
    static int result = -1;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        DFS(B, 1);
        System.out.println(result);
    }

    static void DFS(long now, int level) {
        if (now < A) {
            return;
        }
        if (now == A) {
            result = level;
            return;
        }

        if (result != -1) {
            return;
        }

        if (now % 10 == 1) {
            DFS(now / 10, level + 1);
        } else if (now % 2 == 0) {
            DFS(now / 2, level + 1);
        }
    }
}
/*
 public class Main { // rename class to Main
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());

        int count = 1;
        while (B > A) {
            if (B % 10 == 1) {
                B /= 10;
            } else if (B % 2 == 0) {
                B /= 2;
            } else {
                // if neither operation applies, A cannot be reached
                break;
            }
            count++;
        }

        if (B == A) {
            System.out.println(count);
        } else {
            System.out.println(-1);
        }
    }
}
 */
package baek.silver.S2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj12891 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int S, P;
    static String str;
    static int[] arr;
    static int result = 0;
    static int[] count;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        S = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        str = br.readLine();
        arr = new int[4];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        count = new int[4];

        // check only the first window
        for (int i = 0; i < P; i++) {
            correct(i);
        }
        if (valid_password()) {
            result++;
        }
        

        for (int i = 1; i <= S - P; i++) {
            rollback(i - 1);
            correct(i + P - 1);
            if (valid_password()) {
                result++;
            }

        }
        System.out.println(result);

    }

    static void rollback(int idx) {
        switch(str.charAt(idx)) {
            case 'A': count[0]--; break;
            case 'C': count[1]--; break;
            case 'G': count[2]--; break;
            case 'T': count[3]--; break;
        }
    }

    static void correct(int idx) {
        switch(str.charAt(idx)) {
            case 'A': count[0]++; break;
            case 'C': count[1]++; break;
            case 'G': count[2]++; break;
            case 'T': count[3]++; break;
        }
    }

    static boolean valid_password() {
        return count[0] >= arr[0] && count[1] >= arr[1] && count[2] >= arr[2] && count[3] >= arr[3];
    }
}

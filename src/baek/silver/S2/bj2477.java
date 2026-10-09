package baek.silver.S2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj2477 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder result;
    static StringTokenizer st;
    static int cal;

    public static void main(String[] args) throws IOException {
        cal = Integer.parseInt(br.readLine());
        int[] dir = new int[12]; // not needed
        int[] len = new int[12];

        for (int i = 0; i < 6; i++) {
            st = new StringTokenizer(br.readLine());
            dir[i] = dir[i + 6] = Integer.parseInt(st.nextToken());
            len[i] = len[i + 6] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < 6; i++) {
            if (len[i] != len[i + 2] + len[i + 4]) continue;
            if (len[i + 1] != len[i + 3] + len[i + 5]) continue;
            System.out.println((len[i] * len[i + 1] - len[i + 3] * len[i + 4]) * cal);
        }
    }
}


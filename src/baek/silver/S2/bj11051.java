package baek.silver.S2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class bj11051 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, K;
    static ArrayList<Integer>[] pascal;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        pasTri();
    }

    public static void pasTri() {
        pascal = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) {
            pascal[i] = new ArrayList<>();
        }

        // add first row
        pascal[1].add(1);
        pascal[1].add(1);

        for (int i = 2; i <= N; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    pascal[i].add(1);
                } else {
                    pascal[i].add((pascal[i - 1].get(j - 1) + pascal[i - 1].get(j)) % 10007);
                }
            }
        }

        System.out.println(pascal[N].get(K));

    }
}

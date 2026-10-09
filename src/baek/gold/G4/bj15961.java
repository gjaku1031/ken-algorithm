package baek.gold.G4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj15961 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, d, k, c;

    static int[] sushi;
    static int[] kind;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        sushi = new int[N];
        kind = new int[d + 1];

        for (int i = 0; i < N; i++) {
            sushi[i] = Integer.parseInt(br.readLine());
        }

        int result = 0;
        int distinct = 0;

        // first, add k items
        for (int i = 0; i < k; i++) {

            if (kind[sushi[i]] == 0) {
                distinct++;
            }
            kind[sushi[i]]++;
        }
        result = distinct + (kind[c] == 0 ? 1 : 0);

        for (int i = 1; i < N; i++) {
            int outIdx = sushi[i - 1];
            kind[outIdx]--;
            if (kind[outIdx] == 0) {
                distinct--;
            }

            int inIdx = sushi[(i + k - 1) % N];
            if (kind[inIdx] == 0) {
                distinct++;
            }
            kind[inIdx]++;

            int cand = distinct + (kind[c] == 0 ? 1 : 0);
            if (cand > result) {
                result = cand;
            }
        }
        System.out.println(result);
    }
}
package baek.gold.G2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class bj12015 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N;
    static int[] seq;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        seq = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            seq[i] = Integer.parseInt(st.nextToken());
        }
        System.out.println(listLen());
    }

    static int listLen() {
        List<Integer> tails = new ArrayList<>();
        for (int i : seq) {
            int idx = Collections.binarySearch(tails, i);
            if (idx < 0) idx = -idx - 1;

            if (idx == tails.size()) tails.add(i);
            else tails.set(idx, i);
        }
        return tails.size();
    }
}
/**
 * idx = -(insertionPoint) - 1
 * insertionPoint = -idx - 1
 [10, 20, 30]

 x = 25
 not found!
 idx = -2 -1 = -3
 pos = -(-3) -1 = 2
 tails[2] = 25

 idx =

 x = 20
 found!
 idx = 1
 pos = 1 -> replace

 */

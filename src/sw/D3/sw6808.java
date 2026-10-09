package sw.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class sw6808 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int T;

    static Set<Integer> cardSet;
    static ArrayList<Integer> cardList;
    static int[] cards_A;
    static int[] cards_B;
    static boolean[] visited;

    static int win;
    static int lose;

    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {

            // Initialize
            cards_A = new int[9];
            cards_B = new int[9];
            visited = new boolean[9];
            win = 0;
            lose = 0;

            cardSet = new HashSet<>();
            for (int i = 1; i <= 18; i++) {
                cardSet.add(i);
            }

            // Input
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 9; i++) {
                int now = Integer.parseInt(st.nextToken());
                cards_A[i] = now;
                cardSet.remove(now);
            }
            cardList = new ArrayList<>(cardSet);

            BTC(0);

            System.out.println("#" + tc + " " + win + " " + lose);
        }
    }

    static void BTC(int level) {
        if (level == 9) {
            compare();
            return;
        }

        for (int i = 0; i < 9; i++) {
            if (!visited[i]) {
                visited[i] = true;
                cards_B[level] = cardList.get(i);
                BTC(level + 1);
                visited[i] = false;
            }
        }
    }

    static void compare() {
        int sum = 0;
        for (int i = 0; i < 9; i++) {
            if (cards_A[i] > cards_B[i]) {
                sum += cards_A[i] + cards_B[i];
            }
        }
        if (sum > 171 / 2) {
            win++;
        } else {
            lose++;
        }
    }
}

package baek.gold.G5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj1759 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int L, C;
    static char[] arr;

    static char[] vowels = {'a', 'e', 'i', 'o', 'u'};

    static StringBuilder temp = new StringBuilder();
    static StringBuilder result = new StringBuilder();

    public static void main(String[] args) throws IOException {
        // Input
        st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        arr = new char[C];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < C; i++) {
            arr[i] = st.nextToken().charAt(0);
        }

        // Sort
        Arrays.sort(arr);
        bt(0, 0, 0, 0);
        System.out.println(result);
    }

    static void bt(int start, int level, int vowelCnt, int consCnt) {
        if (level == L) {
            if (vowelCnt >= 1 && consCnt >= 2) {
                result.append(temp).append("\n");
            }
            return;
        }

        for (int i = start; i < C; i++) {
            temp.append(arr[i]);
            if (isVowel(arr[i])) {
                bt(i + 1, level + 1, vowelCnt + 1, consCnt);
            } else {
                bt(i + 1, level + 1, vowelCnt, consCnt + 1);
            }
            temp.setLength(level);
        }
    }

    static boolean isVowel(char ch) {
        for (int i = 0; i < 5; i++) {
            if (ch == vowels[i]) {
                return true;
            }
        }
        return false;
    }
}
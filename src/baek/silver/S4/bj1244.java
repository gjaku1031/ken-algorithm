package baek.silver.S4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj1244 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int N, M;
    static int[] bull;


    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        bull = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            bull[i] = Integer.parseInt(st.nextToken());
        }

        M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int gender = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());
            if (gender == 1) {
                man(num);
            } else {
                woman(num);
            }
        }
        for (int j = 1; j <= N; j++) {
            sb.append(bull[j]).append(' ');
            if (j % 20 == 0) sb.append('\n');
        }
        if (N % 20 != 0) sb.append('\n');

        System.out.println(sb);
    }

    static void man(int num) {
        for (int i = 1; i <= N / num; i++) {
            //System.out.println(i*num+" bulb toggled");
            bull[i * num] = (bull[i * num] + 1) % 2;
        }
    }

    static void woman(int num) {
        int maxRange = 0;
        for (int i = 1; valid(num - i, num + i); i++) {
            if (bull[num - i] == bull[num + i]) {
                maxRange = i;
            } else {
                break;
            }
        }

        bull[num] = (bull[num] + 1) % 2;
        for (int i = 1; i <= maxRange; i++) {
            bull[num - i] = (bull[num - i] + 1) % 2;
            bull[num + i] = (bull[num + i] + 1) % 2;
        }
    }

    static boolean valid(int x, int y) {
        return 0 < x && x <= N && 0 < y && y <= N;
    }
}
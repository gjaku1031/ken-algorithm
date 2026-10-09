package sw.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class sw11285 { // Class name changed (example)
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int T;

    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            int N = Integer.parseInt(br.readLine());
            int totalScore = 0;

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                double r = Math.sqrt((long)x * x + (long)y * y);

                int dartScore;

                if (x == 0 && y == 0) {
                    dartScore = 10;
                } else {
                    dartScore = Math.max(0, 11 - (int)Math.ceil(r / 20.0));
                }
                totalScore += dartScore;
            }
            System.out.println("#" + tc + " " + totalScore);
        }
    }
}
package sw.D2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class sw1979 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            int[][] words = new int[N][N];


            //Input
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    words[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int count = 0;

            //Scan the entire array
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {

                    //Candidate search --> when 1
                    if (words[i][j] == 1) {

                        //Specific candidate (leftmost, or the cell to the left is blocked)
                        if (j == 0 || words[i][j - 1] == 0) {
                            int currentLength = 0;
                            for (int k = 0; k < K; k++) {

                                //On failure
                                if (j + k >= N || words[i][j + k] == 0) {
                                    currentLength = -1;
                                    break;
                                }
                                currentLength++;
                            }

                            if (currentLength == K) {
                                if (j + K == N || words[i][j + K] == 0) {
                                    count++;
                                }
                            }
                        }

                        if (i == 0 || words[i - 1][j] == 0) {
                            int currentLength = 0;
                            for (int k = 0; k < K; k++) {
                                if (i + k >= N || words[i + k][j] == 0) {
                                    currentLength = -1;
                                    break;
                                }
                                currentLength++;
                            }

                            if (currentLength == K) {
                                if (i + K == N || words[i + K][j] == 0) {
                                    count++;
                                }
                            }
                        }
                    }
                }
            }

            System.out.println("#" + tc + " " + count);
        }
        br.close();
    }
}

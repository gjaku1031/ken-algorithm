package baek.bronze.B2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj13300 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N, K;
    static int[][] arr = new int[7][2];

    public static void main(String[] args) throws IOException {
        //input
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int gen = Integer.parseInt(st.nextToken());
            int cls = Integer.parseInt(st.nextToken());
            arr[cls][gen]++;
        }

        //solution
        int result = 0;
        for (int i = 1; i <= 6; i++) {
            for (int j = 0; j < 2; j++) {
                result += (arr[i][j] + (K - 1)) / K;
            }
        }
        System.out.println(result);
    }

}
/*
(Read carefully)
3-day, 2-night school trip
multiple grades at the same place
assign rooms for students from grade 1 to grade 6

boys together, girls together
each room holds students of the same grade -> a room may hold just one student

maximum number of students per room: K

find the minimum number of rooms needed to assign all students under these conditions

==========================================================
Example)
 */

/*
0 - 0

1
2
3

4
5
6
 */
package baek.step.arr2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj2566 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] arr = new int[9][9];
        for (int i = 0; i < 9; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int max = 0;
        // Find the max
        for (int i = 0; i < 9; i++) {
            int m = Arrays.stream(arr[i]).max().getAsInt();
            max = Math.max(max, m);
        }

        // Find the max index
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (arr[i][j] == max) {
                    System.out.println(max);
                    System.out.println((i + 1) + " " + (j + 1));
                    break;
                }
            }
        }

    }
}

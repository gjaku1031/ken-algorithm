package sw.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class sw13428 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int T;

    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            String number = br.readLine();
            char[] digits = number.toCharArray();

            int original = Integer.parseInt(number);
            int min = original;
            int max = original;

            for (int i = 0; i < digits.length - 1; i++) {
                for (int j = i + 1; j < digits.length; j++) {

                    swap(digits, i, j);

                    if (digits[0] != '0') {
                        int val = Integer.parseInt(new String(digits));
                        min = Math.min(min, val);
                        max = Math.max(max, val);
                    }
                    swap(digits, i, j); // Backtrack
                }
            }
            System.out.println("#" + tc + " " + min + " " + max);
        }
    }

    static void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
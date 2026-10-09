package baek.step.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class bj10809 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int[] alp = new int[26];

        // Fill the array with val
        Arrays.fill(alp, -1);

        for (int i = 0; i < 26; i++) {
            int count = 0;
            for (int j = 0; j < s.length(); j++) {
                if ((char) (97 + i) == s.charAt(j)) {
                    alp[i] = count;
                } else {
                    count++;
                }
            }
        }
        for (int i = 0; i < 26; i++) {
            System.out.print(alp[i] + " ");
        }
        //System.out.println("1 0 -1 -1 2 -1 -1 -1 -1 4 3 -1 -1 7 5 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1");
    }
}

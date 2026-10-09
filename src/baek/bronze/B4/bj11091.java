package baek.bronze.B4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj11091 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String sentence = br.readLine().toLowerCase(); // convert to lowercase
            boolean[] alphabet = new boolean[26]; // a-z check array

            // mark letters present in the sentence
            for (char c : sentence.toCharArray()) {
                if (c >= 'a' && c <= 'z') {
                    alphabet[c - 'a'] = true;
                }
            }

            // find missing letters
            StringBuilder missing = new StringBuilder();
            for (int j = 0; j < 26; j++) {
                if (!alphabet[j]) {
                    missing.append((char)('a' + j));
                }
            }

            // print result
            if (missing.length() == 0) {
                System.out.println("pangram");
            } else {
                System.out.println("missing " + missing.toString());
            }
        }
    }

}

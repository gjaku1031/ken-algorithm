package sw.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.HashMap;

public class sw1240 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int T;
    static int N, M;
    static String code;

    static HashMap<String, Integer> patternToDigit = new HashMap<>();

    static void initPatterns() {
        patternToDigit.put("0001101", 0);
        patternToDigit.put("0011001", 1);
        patternToDigit.put("0010011", 2);
        patternToDigit.put("0111101", 3);
        patternToDigit.put("0100011", 4);
        patternToDigit.put("0110001", 5);
        patternToDigit.put("0101111", 6);
        patternToDigit.put("0111011", 7);
        patternToDigit.put("0110111", 8);
        patternToDigit.put("0001011", 9);
    }

    public static void main(String[] args) throws IOException {
        initPatterns();

        T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            code = null;
            input();

            if (code != null && code.length() == 56) { // Code found; check that the length is valid
                decodeAndPrint(tc);
            } else {
                // Code not found or invalid (by the problem constraints it should always be found)
                System.out.println("#" + tc + " " + 0);
            }
        }
    }


    static void input() throws IOException {
        boolean found = false;
        for (int i = 0; i < N; i++) {
            String currentLine = br.readLine();

            if (found) { //Read and discard the remaining lines
                continue;
            }

            for (int j = currentLine.length() - 1; j >= 55; j--) {
                if (currentLine.charAt(j) == '1') {
                    String potentialCode = currentLine.substring(j - 55, j + 1);

                    code = potentialCode;
                    found = true;
                    break;
                }
            }
        }
    }

    static void decodeAndPrint(int tc) {
        int[] decodedDigits = new int[8];
        int sumOfDigits = 0;

        for (int k = 0; k < 8; k++) {
            String sub = code.substring(k * 7, (k + 1) * 7);
            if (patternToDigit.containsKey(sub)) {
                int digit = patternToDigit.get(sub);
                decodedDigits[k] = digit;
                sumOfDigits += digit;
            } else {
                System.out.println("#" + tc + " " + 0);
                return;
            }
        }

        int oddSum = 0;
        int evenSum = 0;

        for (int k = 0; k < 8; k++) {
            if ((k + 1) % 2 != 0) {
                oddSum += decodedDigits[k];
            } else {
                evenSum += decodedDigits[k];
            }
        }

        int verificationSum = (oddSum * 3) + evenSum;

        if (verificationSum % 10 == 0) {
            System.out.println("#" + tc + " " + sumOfDigits);
        } else {
            System.out.println("#" + tc + " " + 0);
        }
    }
}
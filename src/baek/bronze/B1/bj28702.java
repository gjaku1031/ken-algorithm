package baek.bronze.B1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj28702 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = 0;
        int idx = 0;
        for (int i = 0; i < 3; i++) {
            String line = br.readLine();
            if (isNumeric(line)) {
                a = Integer.parseInt(line);
                idx = i;
            }
        }
        int result = a + 3 - idx;
        fizzBuzz(result);
    }

    static boolean isNumeric(String str) {
        try {
            Double.parseDouble(str); // try parsing as a number, integer or real
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    static void fizzBuzz(int result) {
        if (result % 3 == 0 && result % 5 == 0) {
            System.out.println("FizzBuzz");
        } else if (result % 3 == 0) {
            System.out.println("Fizz");
        } else if (result % 5 == 0) {
            System.out.println("Buzz");
        } else {
            System.out.println(result);
        }

    }

}

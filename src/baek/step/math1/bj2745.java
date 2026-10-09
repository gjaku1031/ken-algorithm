package baek.step.math1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj2745 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String num = st.nextToken();
        int base = Integer.parseInt(st.nextToken());
        System.out.println(baseConvert(num, base));

    }

    static int baseConvert(String num, int base) {
        int convertedNum = 0;
        if (base == 10) {
            return Integer.parseInt(num);

        } else {
            for (int i = 0; i < num.length(); i++) {
                int a = 0;

                // Convert letter -> number (A : 65 -> A : 10)
                if ((int) (num.charAt(i)) >= 65) {
                    a = ((int) num.charAt(i)) - 55;
                    //System.out.println("a = " + a);
                } else {
                    a = Integer.parseInt(Character.toString(num.charAt(i)));
                    //System.out.println("a = " + a);
                }

                // digit value * ((position) ^ Base)
                convertedNum += a * (int) Math.pow(base, num.length() - i - 1);
            }
            return convertedNum;
        }
    }
}

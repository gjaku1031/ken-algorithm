package baek.bronze.B3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class bj2935 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // read first number
        BigInteger A = new BigInteger(br.readLine());

        // read operator
        String operator = br.readLine();

        // read second number
        BigInteger B = new BigInteger(br.readLine());

        // compute based on operator
        BigInteger result;
        if (operator.equals("+")) {
            result = A.add(B);
        } else {
            result = A.multiply(B);
        }

        // print result
        System.out.println(result);

        br.close();
    }
}

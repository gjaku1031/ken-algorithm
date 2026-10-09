package baek.bronze.B2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj15829 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        String str = br.readLine();

        long totalNum = 0;
        long power = 1; // stores 31^i
        long mod = 1234567891;

        for (int i = 0; i < N; i++) {
            int value = str.charAt(i) - 'a' + 1; // a=1, b=2, ...
            totalNum = (totalNum + value * power % mod) % mod; // modular arithmetic
            power = (power * 31) % mod; // modular arithmetic
        }

        System.out.println(totalNum);
    }
}
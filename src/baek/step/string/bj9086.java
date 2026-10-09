package baek.step.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj9086 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        String[] strings = new String[T];
        for (int i = 0; i < T; i++) {
            strings[i] = br.readLine();
        }
        for (int i = 0; i < T; i++) {
            System.out.println(strings[i].charAt(0) + "" +strings[i].charAt(strings[i].length() - 1));
        }
    }
}

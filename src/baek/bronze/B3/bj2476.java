package baek.bronze.B3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj2476 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        int maxPrize = 0;
        
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            
            int prize = calculatePrize(a, b, c);
            maxPrize = Math.max(maxPrize, prize);
        }
        
        System.out.println(maxPrize);
    }
    
    private static int calculatePrize(int a, int b, int c) {
        // all three are equal
        if (a == b && b == c) {
            return 10000 + a * 1000;
        }
        // two are equal
        else if (a == b) {
            return 1000 + a * 100;
        } else if (b == c) {
            return 1000 + b * 100;
        } else if (a == c) {
            return 1000 + a * 100;
        }
        // all different
        else {
            int max = Math.max(a, Math.max(b, c));
            return max * 100;
        }
    }
}

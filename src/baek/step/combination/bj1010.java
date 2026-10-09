package baek.step.combination;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class bj1010 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int T;
    static ArrayList<Integer>[] pascal;
    static int x, y;


    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            pasTri();
        }
    }

    // Use Pascal's triangle
    public static void pasTri() {
        pascal = new ArrayList[y + 1];
        for (int i = 0; i <=y; i++) {
            pascal[i] = new ArrayList<>();
        }

        // Add the first row
        pascal[1].add(1);
        pascal[1].add(1);

        for (int i = 2; i <= y; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    pascal[i].add(1);
                } else {
                    pascal[i].add(pascal[i - 1].get(j - 1) + pascal[i - 1].get(j));
                }
            }
        }
        System.out.println(pascal[y].get(x));
    }
}

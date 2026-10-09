package baek.step.arr;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj10811 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st1.nextToken());
        int M = Integer.parseInt(st1.nextToken());
        int[] baskets = new int[N];

        for (int i = 0; i < N; i++) {
            baskets[i] = i + 1;
        }
        for (int i = 0; i < M; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st2.nextToken());
            int y = Integer.parseInt(st2.nextToken());
            reverseBas(baskets, x, y);
        }
        for (int basket : baskets) {
            System.out.print(basket + " ");
        }
    }

    static void reverseBas(int[] baskets, int x, int y) {
        if (x == y) {
            return;
        }

        int size = y - x + 1;
        int[] tempArr = new int[size];

        // Put numbers in a temp array
        for (int i = 0; i < size; i++) {
            tempArr[i] = baskets[x - 1 + i];
        }

        // Put them in reverse order
        for (int i = 0; i < size; i++) {
            baskets[x - 1 + i] = tempArr[size - 1 - i];
        }
    }
}

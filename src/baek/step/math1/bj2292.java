package baek.step.math1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj2292 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int roomNum = Integer.parseInt(br.readLine());
        if (roomNum == 1) {
            System.out.println(1);
        } else {
            for (int i = 1; true; i++) {
                if (maxRoom(i - 1) < roomNum && roomNum <= maxRoom(i)) {
                    System.out.println(i);
                    break;
                }
            }
        }
    }

    //differences between terms
    static int diff(int N) {
        return 6 * N;
    }

    static int maxRoom(int N) {
        int sum = 1;
        for (int i = 0; i < N; i++) {
            sum += diff(i);
        }
        return sum;
    }
}

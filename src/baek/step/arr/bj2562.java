package baek.step.arr;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class bj2562 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[9];
        int count = 0;

        for (int i = 0; i < 9; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        int max = Arrays.stream(arr).max().getAsInt();
        System.out.println(Arrays.stream(arr).max().getAsInt()); // Method to get the max of the array
        for (int i = 0; i < 9; i++) {
            count++;
            if (max == arr[i]) {
                System.out.println(count);
                break;
            }
        }
    }
}

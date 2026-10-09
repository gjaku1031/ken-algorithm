package baek.step.arr;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj1546 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] nums = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {

            nums[i] = Integer.parseInt(st.nextToken());
        }

        // Find the max
        int max = Arrays.stream(nums).max().getAsInt();


        double sum = 0;
        for (int num : nums) {
            sum += ((double) num * 100 / (double) max);

        }
        System.out.println(sum / n);
    }
}

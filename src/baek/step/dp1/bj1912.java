package baek.step.dp1;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj1912 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int[] arr;
    static int n;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        dp = new int[n];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dp[0] = arr[0];
        int max = arr[0];


        /*
         Having considered up to the i-th element, what info must be stored for the next step (i+1)? -> think about this
            - Here, the key is knowing the max sum among contiguous subarrays that must include the i-th element
            -> arr[i+1] starts a new contiguous subarray on its own
            -> or, can appending arr[i+1] to the max contiguous subarray ending at arr[i] make a larger sum
         */
        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(arr[i], dp[i - 1] + arr[i]);
            if (dp[i] > max) {
                max = dp[i];
            }
        }
        System.out.println(max);
    }
}
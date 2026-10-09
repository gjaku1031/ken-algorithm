package baek.step.dp1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj1912_Kadane {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[] arr;
    static int n;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int currentMax = arr[0]; // Max contiguous sum ending at the current index
        int overallMax = arr[0]; // Max contiguous sum over the whole array

    
        for (int i = 1; i < n; i++) {
            // Decide whether to start fresh at the current element or extend the previous sum
            currentMax = Math.max(arr[i], currentMax + arr[i]);
            
            // Update the overall max
            overallMax = Math.max(overallMax, currentMax);
        }

        System.out.println(overallMax);
    }

}

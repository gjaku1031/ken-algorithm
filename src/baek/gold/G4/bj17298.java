package baek.gold.G4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class bj17298 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int N;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        // Input
        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Stack<Integer> stack = new Stack<>();
        int[] NGE = new int[N];
        Arrays.fill(NGE, -1);
        stack.push(0);

        for (int i = 1; i < N; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
                int index = stack.pop();
                NGE[index] = arr[i];
            }
            stack.push(i);
        }

        for (int i = 0; i < N; i++) {
            sb.append(NGE[i]).append(" ");
        }
        System.out.println(sb);
    }
}

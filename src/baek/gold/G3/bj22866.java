package baek.gold.G3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class bj22866 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int N;
    static int[] arr;
    static int[] nearest_left;
    static int[] nearest_right;

    static int[] count_left;
    static int[] count_right;

    public static void main(String[] args) throws IOException {
        // Input
        N = Integer.parseInt(br.readLine());
        arr = new int[N + 1];
        nearest_left = new int[N + 1];
        nearest_right = new int[N + 1];

        count_left = new int[N + 1];
        count_right = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Stack<Integer> stack = new Stack<>();

        // left
        for (int i = 1; i <= N; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] <= arr[i]) {
                stack.pop();
            }
            count_left[i] = stack.size();
            nearest_left[i] = stack.isEmpty() ? 0 : stack.peek();
            stack.push(i);
        }
        stack.clear();

        // right
        for (int i = N; i >= 1; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] <= arr[i]) {
                stack.pop();
            }
            count_right[i] = stack.size();
            nearest_right[i] = stack.isEmpty() ? 0 : stack.peek();
            stack.push(i);
        }

        for (int i = 1; i <= N; i++) {
            int total = count_left[i] + count_right[i];

            if (total == 0) {
                sb.append("0\n");
            } else {
                int nearest = 0;
                if (nearest_left[i] == 0)
                    nearest = nearest_right[i];
                else if (nearest_right[i] == 0)
                    nearest = nearest_left[i];
                else
                    nearest = (i - nearest_left[i] <= nearest_right[i] - i) ? nearest_left[i] : nearest_right[i];
                sb.append(total).append(" ").append(nearest).append("\n");
            }
        }
        System.out.println(sb);
    }

}

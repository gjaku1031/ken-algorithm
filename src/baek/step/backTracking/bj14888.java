package baek.step.backTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj14888 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static int[] operator = new int[4];
    static int max = -1000000000;
    static int min = 1000000000;
    static int[] operatorIndex;
    static StringTokenizer st;
    static boolean[] visited;
    static int[] nums;
    static int N;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        operatorIndex = new int[N - 1];
        visited = new boolean[N];
        nums = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int a = Integer.parseInt(st.nextToken());
            nums[i] = a;
        }

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < 4; i++) {
            operator[i] = Integer.parseInt(st.nextToken());
        }
        setOperator();
        BTC(0, 0);
        System.out.println(max);
        System.out.println(min);
    }

    static void BTC(int start, int depth) {
        if (depth == N - 1) {
            int totalNum = 0;
            for (int i = 0; i < N - 1; i++) {
                if (i == 0) {
                    totalNum = biOperator(nums[0], nums[1], sb.charAt(operatorIndex[i]));
                } else {
                    totalNum = biOperator(totalNum, nums[i + 1], sb.charAt(operatorIndex[i]));
                }
            }
            max = Math.max(max, totalNum);
            min = Math.min(min, totalNum);
            return;
        }

        for (int i = 0; i < N - 1; i++) {
            if (!visited[i]) {
                visited[i] = true;
                operatorIndex[depth] = i;
                BTC(start + 1, depth + 1);
                operatorIndex[depth] = 0;
                visited[i] = false;
            }
        }
    }

    static int biOperator(int a, int b, char operator) {
        if (operator == '+') {
            return a + b;
        } else if (operator == '-') {
            return a - b;
        } else if (operator == '*') {
            return a * b;
        } else {
            return a / b;
        }
    }

    static void setOperator() {
        // Add '+' operator
        for (int i = 0; i < operator[0]; i++) {
            sb.append('+');
        }
        
        // Add '-' operator
        for (int i = 0; i < operator[1]; i++) {
            sb.append('-');
        }
        
        // Add '*' operator
        for (int i = 0; i < operator[2]; i++) {
            sb.append('*');
        }
        
        // Add '/' operator
        for (int i = 0; i < operator[3]; i++) {
            sb.append('/');
        }
    }
}
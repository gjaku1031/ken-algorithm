package sw.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class sw6190 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int T;

    static int N;
    static int[] arr;
    static int result;

    public static void main(String[] args) throws IOException { //Main logic
        T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine());
            arr = new int[N];
            result = -1;
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            BTC(0);
            System.out.println("#" + tc + " " + result);

        }
    }

    static void BTC(int level) { //Function 1
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (isUpper(arr[i] * arr[j])) {
                    result = Math.max(result, arr[i] * arr[j]);
                }
            }
        }
    }

    static boolean isUpper(int num) { //Function 2
        String strNum = Integer.toString(num);
        for (int i = 0; i < strNum.length() - 1; i++) {
            if (strNum.charAt(i) > strNum.charAt(i + 1)) {
                return false;
            }
        }
        return true;
    }
}
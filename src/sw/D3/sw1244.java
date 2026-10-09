package sw.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class sw1244 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int T;

    static char[] numArr;
    static int maxSwap;
    static int maxPrize;
    static HashSet<String>[] visited;

    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            String sNum = st.nextToken();
            maxSwap = Integer.parseInt(st.nextToken());
            numArr = sNum.toCharArray();
            maxPrize = 0;

            visited = new HashSet[maxSwap + 1];

            for (int i = 0; i <= maxSwap; i++) {
                visited[i] = new HashSet<>();
            }

            DFS(0);

            System.out.println("#" + tc + " " + maxPrize);

        }
    }

    static void DFS(int currentSwaps) {
        String currentNumStr = new String(numArr); // Current number board state

        if (visited[currentSwaps].contains(currentNumStr)) { // Pruning
            return;
        }

        visited[currentSwaps].add(currentNumStr);

        if (currentSwaps == maxSwap) { //Max swaps reached -> update
            maxPrize = Math.max(maxPrize, Integer.parseInt(currentNumStr));
            return;
        }

        for (int i = 0; i < numArr.length - 1; i++) {
            for (int j = i + 1; j < numArr.length; j++) {
                swap(i, j);
                DFS(currentSwaps + 1);
                swap(i, j); //Backtrack
            }

        }
    }

    static void swap(int i, int j) {
        char temp = numArr[i];
        numArr[i] = numArr[j];
        numArr[j] = temp;
    }
}

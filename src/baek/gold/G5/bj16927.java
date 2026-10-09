package baek.gold.G5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj16927 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}}; // right, down, left, up
    static int N, M, R;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        StringBuilder result = new StringBuilder();
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int groupCount = Math.min(N, M) / 2;

        for (int i = 0; i < groupCount; i++) {
            int perimeter = 2 * (N - 2 * i) + 2 * (M - 2 * i) - 4;
            int rotateCount = R % perimeter;

            for (int j = 0; j < rotateCount; j++) {
                rotateLayer(i);
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                result.append(arr[i][j]).append(" ");
            }
            result.append("\n");
        }
        System.out.println(result);
    }

    public static void rotateLayer(int layer) {
        int temp = arr[layer][layer];

        int currentX = layer;
        int currentY = layer;

        for (int d = 0; d < 4; d++) {
            while (true) {
                int nextX = currentX + dir[d][0];
                int nextY = currentY + dir[d][1];
                if (nextX < layer || nextX >= N - layer || nextY < layer || nextY >= M - layer) break;
                arr[currentX][currentY] = arr[nextX][nextY];
                currentX = nextX;
                currentY = nextY;
            }
        }
        arr[layer + 1][layer] = temp;
    }
}

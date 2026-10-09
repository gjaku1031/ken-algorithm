package baek.step.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class bj2667 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static ArrayList<Integer> houseNum;
    static int[][] houses;
    static boolean[][] visited;
    static StringTokenizer st;
    static int count;
    static int N;

    static int[] dx = { 0, 0, -1, 1 };
    static int[] dy = { -1, 1, 0, 0 };

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        houses = new int[N][N];
        visited = new boolean[N][N];
        houseNum = new ArrayList<>();

        // Input
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                houses[i][j] = Integer.parseInt(Character.toString(line.charAt(j)));
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (houses[i][j] == 1 && !visited[i][j]) {
                    count = 1;
                    visited[i][j] = true;
                    search(i, j);
                    houseNum.add(count);
                }
            }
        }

        Collections.sort(houseNum);
        System.out.println(houseNum.size());
        for (Integer num : houseNum) {
            System.out.println(num);
        }
    }

    public static void search(int currentX, int currentY) {
        // 4 directions
        for (int i = 0; i < 4; i++) {
            int nextX = currentX + dx[i];
            int nextY = currentY + dy[i];

            if (nextX >= 0 && nextX < N && nextY >= 0 && nextY < N) {
                if (houses[nextX][nextY] == 1 && !visited[nextX][nextY]) {
                    visited[nextX][nextY] = true;
                    count++;
                    search(nextX, nextY);
                }
            }
        }
    }
}

package baek.gold.G4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj6987 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int[][] team;
    static StringBuilder result = new StringBuilder();
    static int answer;

    public static void main(String[] args) throws IOException {

        for (int tc = 0; tc < 4; tc++) {
            // Input
            st = new StringTokenizer(br.readLine());
            team = new int[6][3];
            answer = 0;

            for (int i = 0; i < 6; i++) {
                team[i][0] = Integer.parseInt(st.nextToken());
                team[i][1] = Integer.parseInt(st.nextToken());
                team[i][2] = Integer.parseInt(st.nextToken());

            }

            // skip backtracking if wins + draws + losses != 5
            boolean flag = true;
            for (int i = 0; i < 6; i++) {
                if (team[i][0] + team[i][1] + team[i][2] != 5) {
                    flag = false;
                    break;
                }
            }
            // Backtracking
            if (flag) {
                bt(0, 1);
            }
            result.append(answer + " ");
        }
        System.out.println(result);
    }


    static void bt(int idx, int next) {
        if (answer == 1) {
            return;
        }

        if (idx == 5) {
            answer = 1;
            return;
        }

        if (team[idx][0] > 0 && team[next][2] > 0) {
            team[idx][0]--;
            team[next][2]--;
            if (next == 5) {
                bt(idx + 1, idx + 2);
            } else {
                bt(idx, next + 1);
            }

            team[idx][0]++;
            team[next][2]++;
        }
        if (team[idx][1] > 0 && team[next][1] > 0) {
            team[idx][1]--;
            team[next][1]--;
            if (next == 5) {
                bt(idx + 1, idx + 2);
            } else {
                bt(idx, next + 1);
            }

            team[idx][1]++;
            team[next][1]++;
        }
        if (team[idx][2] > 0 && team[next][0] > 0) {
            team[idx][2]--;
            team[next][0]--;
            if (next == 5) {
                bt(idx + 1, idx + 2);
            } else {
                bt(idx, next + 1);
            }
            team[idx][2]++;
            team[next][0]++;
        }
    }
}
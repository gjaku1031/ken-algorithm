package sw.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.HashMap;

public class sw1873 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int T, H, W, order_count;
    static char[][] map;
    static int c = 0;
    static int r = 0;
    static char idx = ' ';
    static int dirNumericIdx = 0; //Tank's current direction index

    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static char[] dirChars = {'^', 'v', '<', '>'};

    static HashMap<Character, Integer> dirCharToIdxMap = new HashMap<>();
    static HashMap<Character, Integer> commandToDirIdxMap = new HashMap<>();


    public static void main(String[] args) throws IOException {
        dirCharToIdxMap.put('^', 0);
        dirCharToIdxMap.put('v', 1);
        dirCharToIdxMap.put('<', 2);
        dirCharToIdxMap.put('>', 3);

        commandToDirIdxMap.put('U', 0);
        commandToDirIdxMap.put('D', 1);
        commandToDirIdxMap.put('L', 2);
        commandToDirIdxMap.put('R', 3);


        T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            H = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            map = new char[H][W];
            for (int i = 0; i < H; i++) {
                String str = br.readLine();
                for (int j = 0; j < W; j++) {
                    map[i][j] = str.charAt(j);
                }
            }
            findCurrentIdx();

            order_count = Integer.parseInt(br.readLine());
            String command = br.readLine();
            battle(command);

            System.out.print("#" + tc + " ");
            for (int i = 0; i < H; i++) {
                for (int j = 0; j < W; j++) {
                    System.out.print(map[i][j]);
                }
                System.out.println();
            }
        }
    }

    static void findCurrentIdx() {
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                char cell = map[i][j];
                if (dirCharToIdxMap.containsKey(cell)) {
                    c = i;
                    r = j;
                    idx = cell;

                    dirNumericIdx = dirCharToIdxMap.get(cell);
                    return;
                }
            }
        }
    }

    static void battle(String commandStr) {
        for (int i = 0; i < commandStr.length(); i++) {
            char currentCommand = commandStr.charAt(i);

            if (currentCommand == 'S') {
                shoot();
            } else {
                move(currentCommand);
            }
        }
    }

    private static void move(char currentCommand) {
        dirNumericIdx = commandToDirIdxMap.get(currentCommand);
        idx = dirChars[dirNumericIdx];
        map[c][r] = idx;

        int next_c = c + dr[dirNumericIdx];
        int next_r = r + dc[dirNumericIdx];

        if (valid(next_c, next_r) && map[next_c][next_r] == '.') {
            map[c][r] = '.';
            c = next_c;
            r = next_r;
            map[c][r] = idx;
        }
    }

    private static void shoot() {
        int boom_c = c;
        int boom_r = r;

        while (true) {
            boom_c += dr[dirNumericIdx];
            boom_r += dc[dirNumericIdx];

            if (!valid(boom_c, boom_r)) {
                break;
            }

            if (map[boom_c][boom_r] == '*') {
                map[boom_c][boom_r] = '.';
                break;
            } else if (map[boom_c][boom_r] == '#') {
                break;
            }
        }
    }

    static boolean valid(int nr, int nc) {
        return nr >= 0 && nr < H && nc >= 0 && nc < W;
    }
}
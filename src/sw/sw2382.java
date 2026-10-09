package sw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class sw2382 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int T;

    static int N, M, K;
    static List<Micro>[][] map, nextMap;

    static int[][] dir = {{}, {-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            map = new List[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    map[i][j] = new LinkedList<>();
                }
            }

            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int r = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                int n = Integer.parseInt(st.nextToken());
                int d = Integer.parseInt(st.nextToken());
                map[r][c].add(new Micro(n, d));
            }

            for (int time = 0; time < M; time++) {
                // Next map
                nextMap = new List[N][N];
                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < N; j++) {
                        nextMap[i][j] = new LinkedList<>();
                    }
                }

                for (int r = 0; r < N; r++) {
                    for (int c = 0; c < N; c++) {
                        if (map[r][c].isEmpty()) continue;

                        for (Micro cur : map[r][c]) {
                            int cnt = cur.getCnt();
                            int d = cur.getDir();

                            int nr = r + dir[d][0];
                            int nc = c + dir[d][1];

                            if (nr == 0 || nr == N - 1 || nc == 0 || nc == N - 1) {
                                cnt = cnt / 2;
                                if (cnt == 0) continue;
                                if (d == 1) d = 2;
                                else if (d == 2) d = 1;
                                else if (d == 3) d = 4;
                                else d = 3;
                            }

                            nextMap[nr][nc].add(new Micro(cnt, d));
                        }
                    }
                }

                for (int r = 0; r < N; r++) {
                    for (int c = 0; c < N; c++) {
                        if (nextMap[r][c].size() <= 1) continue;

                        int sum = 0;
                        Micro maxMicro = null;

                        for (Micro m : nextMap[r][c]) {
                            sum += m.getCnt();
                            if (maxMicro == null || m.getCnt() > maxMicro.getCnt()) {
                                maxMicro = m;
                            }
                        }

                        nextMap[r][c].clear();
                        nextMap[r][c].add(new Micro(sum, maxMicro.getDir()));
                    }
                }

                map = nextMap;
            }

            int result = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (map[i][j].isEmpty()) continue;
                    for (Micro m : map[i][j]) result += m.getCnt();
                }
            }
            System.out.println("#" + tc + " " + result);
        }
    }

    static class Micro implements Comparable<Micro> {
        int cnt, dir;

        public Micro(int cnt, int dir) {
            this.cnt = cnt;
            this.dir = dir;
        }

        public int getCnt() {
            return cnt;
        }

        public int getDir() {
            return dir;
        }

        public void setDir(int dir) {
            this.dir = dir;
        }

        @Override
        public int compareTo(Micro o) {
            return this.cnt - o.cnt;
        }
    }
}
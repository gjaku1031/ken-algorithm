package sw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class sw5648 {

    static class Atom {
        int x, y, dir, k;

        public Atom(int x, int y, int dir, int k) {
            this.x = x;
            this.y = y;
            this.dir = dir;
            this.k = k;
        }
    }

    static class Point {
        double x, y;

        public Point(double x, double y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point point = (Point) o;
            return Double.compare(point.x, x) == 0 && Double.compare(point.y, y) == 0;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

    // 0:up, 1:down, 2:left, 3:right
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int t = 1; t <= T; t++) {
            int N = Integer.parseInt(br.readLine());
            Atom[] atoms = new Atom[N];
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int dir = Integer.parseInt(st.nextToken());
                int k = Integer.parseInt(st.nextToken());
                atoms[i] = new Atom(x, y, dir, k);
            }

            long totalEnergy = solve(N, atoms);
            sb.append("#").append(t).append(" ").append(totalEnergy).append("\n");
        }
        System.out.print(sb);
    }

    private static long solve(int N, Atom[] atoms) {
        // time -> <collision position, atom set>
        TreeMap<Float, Map<Point, Set<Integer>>> collisionEvents = new TreeMap<>();

        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                Atom a1 = atoms[i];
                Atom a2 = atoms[j];

                float time = -1;
                Point colPoint = null;

                int v1x = dx[a1.dir];
                int v1y = dy[a1.dir];
                int v2x = dx[a2.dir];
                int v2y = dy[a2.dir];

                // 1. Moving in parallel on the same axis
                if ((a1.dir <= 1 && a2.dir <= 1) || (a1.dir >= 2 && a2.dir >= 2)) {
                    if (a1.y == a2.y && v1x != v2x) { // Horizontal movement
                        if ((a1.x < a2.x && v1x > 0 && v2x < 0) || (a1.x > a2.x && v1x < 0 && v2x > 0)) {
                            time = Math.abs((float) (a1.x - a2.x) / 2.0f);
                            colPoint = new Point(a1.x + v1x * time, a1.y);
                        }
                    } else if (a1.x == a2.x && v1y != v2y) { // Vertical movement
                        if ((a1.y < a2.y && v1y > 0 && v2y < 0) || (a1.y > a2.y && v1y < 0 && v2y > 0)) {
                            time = Math.abs((float) (a1.y - a2.y) / 2.0f);
                            colPoint = new Point(a1.x, a1.y + v1y * time);
                        }
                    }
                }
                // 2. Moving perpendicular to each other
                else {
                    float t1, t2;
                    if (v1x != 0 && v2y != 0) { // a1 horizontal, a2 vertical
                        if ((a2.x - a1.x) * v1x > 0 && (a1.y - a2.y) * v2y > 0) {
                            t1 = (float) Math.abs(a2.x - a1.x) / Math.abs(v1x);
                            t2 = (float) Math.abs(a1.y - a2.y) / Math.abs(v2y);
                            if (t1 == t2) {
                                time = t1;
                                colPoint = new Point(a2.x, a1.y);
                            }
                        }
                    } else if (v1y != 0 && v2x != 0) { // a1 vertical, a2 horizontal
                        if ((a1.x - a2.x) * v2x > 0 && (a2.y - a1.y) * v1y > 0) {
                            t1 = (float) Math.abs(a1.x - a2.x) / Math.abs(v2x);
                            t2 = (float) Math.abs(a2.y - a1.y) / Math.abs(v1y);
                            if (t1 == t2) {
                                time = t1;
                                colPoint = new Point(a1.x, a2.y);
                            }
                        }
                    }
                }

                if (time > 0) {
                    collisionEvents.putIfAbsent(time, new HashMap<>());
                    Map<Point, Set<Integer>> pointMap = collisionEvents.get(time);
                    pointMap.putIfAbsent(colPoint, new HashSet<>());
                    Set<Integer> atomSet = pointMap.get(colPoint);
                    atomSet.add(i);
                    atomSet.add(j);
                }
            }
        }

        long totalEnergy = 0;
        boolean[] removed = new boolean[N];

        for (float time : collisionEvents.keySet()) {
            Map<Point, Set<Integer>> pointMap = collisionEvents.get(time);
            for (Set<Integer> atomSet : pointMap.values()) {
                List<Integer> currentCollisionAtoms = new ArrayList<>();
                for (int atomIdx : atomSet) {
                    if (!removed[atomIdx]) {
                        currentCollisionAtoms.add(atomIdx);
                    }
                }

                if (currentCollisionAtoms.size() > 1) {
                    for (int atomIdx : currentCollisionAtoms) {
                        totalEnergy += atoms[atomIdx].k;
                        removed[atomIdx] = true;
                    }
                }
            }
        }
        return totalEnergy;
    }
}

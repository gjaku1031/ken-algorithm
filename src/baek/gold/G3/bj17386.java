package baek.gold.G3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj17386 {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static StringTokenizer st;
  static long x1, y1, x2, y2, x3, y3, x4, y4;

  static long ccw(long ax, long ay, long bx, long by, long cx, long cy) {
    long v = (bx - ax) * (cy - ay) - (by - ay) * (cx - ax);
    if (v > 0) return 1;
    if (v < 0) return -1;
    return 0;
  }

  static boolean intersect() {
    long ab_c = ccw(x1, y1, x2, y2, x3, y3);
    long ab_d = ccw(x1, y1, x2, y2, x4, y4);
    long cd_a = ccw(x3, y3, x4, y4, x1, y1);
    long cd_b = ccw(x3, y3, x4, y4, x2, y2);

    // collinear case: intersect if the bounding boxes overlap
    if (ab_c == 0 && ab_d == 0 && cd_a == 0 && cd_b == 0) {
      boolean xOverlap =
          Math.max(Math.min(x1, x2), Math.min(x3, x4))
              <= Math.min(Math.max(x1, x2), Math.max(x3, x4));
      boolean yOverlap =
          Math.max(Math.min(y1, y2), Math.min(y3, y4))
              <= Math.min(Math.max(y1, y2), Math.max(y3, y4));
      return xOverlap && yOverlap;
    }
    // general case
    return ab_c * ab_d <= 0 && cd_a * cd_b <= 0;
  }

  public static void main(String[] args) throws Exception {
    st = new StringTokenizer(br.readLine());
    x1 = Long.parseLong(st.nextToken());
    y1 = Long.parseLong(st.nextToken());
    x2 = Long.parseLong(st.nextToken());
    y2 = Long.parseLong(st.nextToken());

    st = new StringTokenizer(br.readLine());
    x3 = Long.parseLong(st.nextToken());
    y3 = Long.parseLong(st.nextToken());
    x4 = Long.parseLong(st.nextToken());
    y4 = Long.parseLong(st.nextToken());

    System.out.println(intersect() ? 1 : 0);
  }
}

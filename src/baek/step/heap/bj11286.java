package baek.step.heap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class bj11286 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<AbsNum> pQ = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            int a = Integer.parseInt(br.readLine());
            if (a != 0) {
                pQ.offer(new AbsNum(a));
            } else if (!pQ.isEmpty()) {
                System.out.println(pQ.poll().getAbsNum());
            } else {
                System.out.println(0);
            }
        }
    }

    static class AbsNum implements Comparable<AbsNum> {
        private int num;

        public AbsNum(int num) {
            this.num = num;
        }

        public int getAbsNum() {
            return this.num;
        }

        @Override
        public int compareTo(AbsNum o) {
            if (Math.abs(this.num) > Math.abs(o.getAbsNum())) {
                return 1;
            } else if (Math.abs(this.num) < Math.abs(o.getAbsNum())) {
                return -1;
            } else {
                return Integer.compare(this.num, o.getAbsNum()); // Integer method
            }
        }
    }
}
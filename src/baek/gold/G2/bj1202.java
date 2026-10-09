package baek.gold.G2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class bj1202 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N, K;
    static PriorityQueue<Jewel> jewelQueue = new PriorityQueue<>();  // jewels kept in ascending order of weight
    static PriorityQueue<Integer> bag = new PriorityQueue<>();  // bags kept in ascending order of capacity
    static PriorityQueue<Integer> candidate = new PriorityQueue<>(Collections.reverseOrder());  // selectable jewels kept in descending order of price

    static class Jewel implements Comparable<Jewel> {
        int weight, price;

        public Jewel(int weight, int price) {
            this.weight = weight;
            this.price = price;
        }

        @Override
        public int compareTo(Jewel o) {
            return this.weight - o.weight;  // lighter weight first
        }
    }

    public static void main(String[] args) throws IOException {
        // Input: number of jewels N, number of bags K
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        // read N jewels (weight, price)
        // stored in jewelQueue, automatically sorted by weight ascending
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int weight = Integer.parseInt(st.nextToken());
            int price = Integer.parseInt(st.nextToken());
            jewelQueue.add(new Jewel(weight, price));
        }

        // read the capacities of K bags
        // stored in bag, automatically sorted by capacity ascending
        for (int i = 0; i < K; i++) {
            bag.add(Integer.parseInt(br.readLine()));
        }

        long answer = 0;  // maximum total price (up to 300,000 * 1,000,000 = 300 billion, so use long)

        // process bags from the smallest capacity up
        for (int i = 0; i < K; i++) {
            int bagCapacity = bag.poll();  // capacity of the bag being processed

            // add every jewel that fits in the current bag to candidate
            // jewelQueue is ordered by weight, so poll every jewel with weight <= current bag capacity
            while (!jewelQueue.isEmpty() && jewelQueue.peek().weight <= bagCapacity) {
                candidate.add(jewelQueue.poll().price);  // add only the price to candidate (automatically sorted by price descending)
            }

            // pick the single most expensive jewel from candidate
            // if candidate is not empty (= some jewel fits)
            if (!candidate.isEmpty()) {
                answer += candidate.poll();  // add the price of the most expensive jewel
            }
        }

        System.out.println(answer);
    }
}
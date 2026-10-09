package baek.step.stackQueDeq;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class bj2164 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Card card = new Card(N);
        card.setQue();
        card.mix();
        card.result();

    }

    static class Card {
        int N;
        Queue<Integer> cardQue = new LinkedList<>();
        public Card(int n) {
            this.N = n;
        }
        // Set up cards
        void setQue() {
            for (int i = 1; i <= N; i++) {
                cardQue.add(i);
            }
        }
        void getOff() {
            cardQue.add(cardQue.poll());
        }
        void result() {
            System.out.println(cardQue.poll());
        }
        void mix() {
            while (cardQue.size() > 1) {
                cardQue.poll();
                getOff();
            }
        }
    }
}

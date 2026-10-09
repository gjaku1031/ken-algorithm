package baek.step.condi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj2480 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int dice1 = Integer.parseInt(st.nextToken());
        int dice2 = Integer.parseInt(st.nextToken());
        int dice3 = Integer.parseInt(st.nextToken());
        DiceSet dice = new DiceSet(dice1, dice2, dice3);
        System.out.println(dice.calculatePrize());
    }

    static class DiceSet {
        int dice1;
        int dice2;
        int dice3;

        public DiceSet(int dice1, int dice2, int dice3) {
            this.dice1 = dice1;
            this.dice2 = dice2;
            this.dice3 = dice3;
        }

        int isTriple() { // Is this method name right?
            if (dice1 == dice2 && dice2 == dice3) {
                return dice1 * 1000 + 10000;
            } else {
                return 0;
            }
        }

        int isPair() {
            if (dice1 == dice2 && dice1 != dice3) {
                return dice1 * 100 + 1000;
            } else if (dice1 == dice3 && dice1 != dice2) {
                return dice1 * 100 + 1000;
            } else if (dice2 == dice3 && dice2 != dice1) {
                return dice2 * 100 + 1000;
            } else {
                return 0;
            }
        }

        int isDistinct() {
            if ((dice1 != dice2) && (dice2 != dice3) && (dice3 != dice1)) {
                return Math.max(dice1, Math.max(dice2, dice3)) * 100; // A way to find the max of three?
            }
            return 0;
        }

        int calculatePrize() {
            return isTriple() + isPair() + isDistinct(); // Is this the best way?
        }
    }
}

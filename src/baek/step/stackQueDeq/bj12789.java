package baek.step.stackQueDeq;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class bj12789 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Snack snack = new Snack(arr);
        snack.line();
        snack.checkStack();
        snack.result();
    }

    static class Snack {
        int[] arr;
        int currentIndex = 1; // Number that should leave next
        Stack<Integer> stack = new Stack<>();

        // Build the line from the array
        public Snack(int[] arr) {
            this.arr = arr;
        }

        public void line() {
            // Change to while(true)
            for (int i = 0; i < arr.length; i++) {
                // If the current number equals the (i+1)-th number, leave -> current number +1
                if (currentIndex == arr[i]) {
                    currentIndex++;
                    System.out.println(arr[i] + " got a snack");

                // Front of the waiting line matches current number -> that person leaves
                } else if (!stack.isEmpty() && stack.peek() == currentIndex) {
                    checkStack();
                    i--;
                } else {
                    stack.push(arr[i]);
                    System.out.println(arr[i] + " joined the line");
                    System.out.println("Current line: " + stack);
                }
            }
        }

        // Front person in the waiting line
        public void checkStack() {
            while (!stack.isEmpty() && currentIndex == stack.peek()) {
                System.out.println(stack.peek() + " finally goes to get a snack");
                stack.pop();
                currentIndex++;
            }
        }

        public void result() {
            if (stack.isEmpty()) {
                System.out.println("Nice");
            } else {
                System.out.println("Sad");
            }
        }
    }
}
package baek.step.condi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj2884 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        Clock clock = new Clock(a, b);
        clock.showClock();

    }

    // Why static class?
    static class Clock {
        int hour;
        int minute;

        Clock(int hour, int minute) {
            this.hour = hour;
            this.minute = minute;
        }

        public void showClock() {
            if (minute < 45) {
                minute = minute + 60 - 45;
                if (hour < 1) {
                    hour = hour + 24;
                }
                hour = hour - 1;
            } else {
                minute = minute - 45;
            }
            System.out.println(hour + " " + minute);
        }

    }
}



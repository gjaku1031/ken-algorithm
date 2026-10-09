package baek.bronze.B1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj4344 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int C = Integer.parseInt(br.readLine()); // number of test cases
        
        for (int i = 0; i < C; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            int N = Integer.parseInt(st.nextToken()); // number of students
            int[] scores = new int[N];
            
            // read scores
            for (int j = 0; j < N; j++) {
                scores[j] = Integer.parseInt(st.nextToken());
            }
            
            // compute average
            double sum = 0;
            for (int j = 0; j < N; j++) {
                sum += scores[j];
            }
            double average = sum / N;
            
            // count students above average
            int count = 0;
            for (int j = 0; j < N; j++) {
                if (scores[j] > average) {
                    count++;
                }
            }
            
            // compute and print ratio
            double ratio = (double) count / N * 100;
            System.out.printf("%.3f%%\n", ratio);
        }
        
        br.close();
    }
}

package sw.D1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
   The class name must be Solution, so using Solution.java is recommended.
   Even so, you can run the program the same way with the java Solution command.
 */
public class sw2072 {
	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(br.readLine());
			int[] arr = new int[10];
			int sum = 0;
			for (int i = 0; i < 10; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
				if (arr[i] % 2 != 0) {
					sum += arr[i];
				}
			}
			System.out.println("#" + test_case + " " + sum);
		}
	}
}
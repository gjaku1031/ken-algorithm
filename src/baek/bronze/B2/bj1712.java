package baek.bronze.B2;

import java.util.Scanner;

public class bj1712 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt(); // fixed cost
		int B = sc.nextInt(); // variable cost
		int C = sc.nextInt(); // selling price

		if (B >= C) {
			System.out.println(-1);
		} else {
			System.out.println(A / (C - B) + 1);
		}
	}
}

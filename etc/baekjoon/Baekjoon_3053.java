package etc.baekjoon;

import java.util.Scanner;

public class Baekjoon_3053 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int R = sc.nextInt();
		
		System.out.printf("%.6f\n", R*R*Math.PI);
		System.out.printf("%.6f\n", (double)R*R*2);
	}

}

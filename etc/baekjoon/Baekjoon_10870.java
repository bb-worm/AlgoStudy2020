package etc.baekjoon;

import java.util.Scanner;

public class Baekjoon_10870 {

	static int[] fibbo = new int[21];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		System.out.println(getFibbo(n));
	}
	
	static int getFibbo(int n) {
		if (n == 0)
			return 0;
		else if (n == 1)
			return 1;
		else if (fibbo[n] != 0)
			return fibbo[n];
		else 
			return fibbo[n] = getFibbo(n-2) + getFibbo(n-1);
	}

}

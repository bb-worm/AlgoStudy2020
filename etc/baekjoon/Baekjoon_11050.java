package etc.baekjoon;

import java.util.Scanner;

public class Baekjoon_11050 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		int result1 = 1;
		for (int i=0; i<K; i++) {
			result1 *= (N-i);
		}
		
		int result2 = 1;
		for (int i=K; i>=1; i--){
			result2 *= i;
		}
		
		System.out.println(result1 / result2);
		
	}

}

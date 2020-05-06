package etc.baekjoon;

import java.util.Scanner;

public class Baekjoon_2609 {
	
	static int a, b;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		a = sc.nextInt();
		b = sc.nextInt();
		
		int result1 = findMax(Math.min(a, b));
		int result2 = findMin(Math.max(a, b));
		
		System.out.println(result1);
		System.out.println(result2);
	}
	
	static int findMax(int end) {
		int result = 1;
		for (int i=2; i<=end; i++) {
			if (a%i==0 && b%i==0)
				result = i;
		}
		return result;
	}
	
	static int findMin(int start) {
		int tmp = start;
		while (true) {
			if (tmp%a==0 && tmp%b==0)
				return tmp;
			
			tmp += start;
		}
	}
	
	

}

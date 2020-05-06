package etc.baekjoon;

import java.util.Scanner;

public class Baekjoon_2562 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int max = 0;
		int idx = 0;
		
		for (int i=1; i<=9; i++) {
			int num = sc.nextInt();
			
			if (max < num) {
				max = num;
				idx = i;
			}
		}
		
		System.out.println(max);
		System.out.println(idx);
	}

}

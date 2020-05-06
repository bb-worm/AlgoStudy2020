package etc.baekjoon;

import java.util.Scanner;

public class Baekjoon_1436 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int find = 0;
		
		String num;
		for (int i=666; ;i++) {
			num = Integer.toString(i);
			if (num.contains("666")) {
				find++;
				if (find == N) {
					System.out.println(num);
					return;
				}
			}
		}
		
	}

}

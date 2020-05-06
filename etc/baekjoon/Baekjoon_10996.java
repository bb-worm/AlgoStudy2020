package etc.baekjoon;

import java.util.Scanner;

public class Baekjoon_10996 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		int N = sc.nextInt();
		
		for (int t=0; t<N; t++) {
			
			for (int i=0; i<N; i++) {
				if (i%2==0)
					sb.append('*');
				else
					sb.append(' ');
			}
			sb.append('\n');
			
			for (int i=0; i<N; i++) {
				if (i%2==0)
					sb.append(' ');
				else
					sb.append('*');
			}
			sb.append('\n');
		}
		System.out.println(sb);
	}
}

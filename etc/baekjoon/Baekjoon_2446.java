package etc.baekjoon;

import java.util.*;

public class Baekjoon_2446 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int N = sc.nextInt();
		
		int max = N*2-1;
		
		int i=max;
		while (i>=1) {
			for (int k=0; k<(max-i)/2; k++) {
				sb.append(' ');
			}
			for (int k=0; k<i; k++) {
				sb.append('*');
			}
			sb.append('\n');
			i -= 2;
		}
		
		i += 4;
		while (i <= max) {
			for (int k=0; k<(max-i)/2; k++) {
				sb.append(' ');
			}
			for (int k=0; k<i; k++) {
				sb.append('*');
			}
			sb.append('\n');
			i += 2;
		}
		System.out.println(sb);
	}

}

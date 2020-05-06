package etc.baekjoon;

import java.util.Scanner;
import java.util.ArrayList;

public class Baekjoon_2164 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		ArrayList<Integer> al = new ArrayList<>();
		for (int i=0; i<N; i++) {
			al.add(i+1);
		}
		
		int start = 0;
		int end = N-1;
		while (start != end) {
			start++;
			al.add(al.get(start));
			start++;
			end++;
		}
		System.out.println(al.get(start));
	}
}

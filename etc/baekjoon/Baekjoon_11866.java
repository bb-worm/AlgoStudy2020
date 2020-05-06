package etc.baekjoon;

import java.util.Scanner;
import java.util.ArrayList;

public class Baekjoon_11866 {
	
	static ArrayList<Integer> al = new ArrayList<>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		for (int i=0; i<N; i++) {
			al.add(i+1);
		}
		
		int sum = 0;
		int idx = K-1;
		sb.append('<');
		while (sum < N) {
			if (sum!=0) {
				sb.append(", ");
			}
			
			if (idx >= al.size()) {
				idx %= al.size();
			}
			
			sb.append(al.get(idx));
			al.remove(idx);
			sum++;
			idx += K-1;
		}
		sb.append('>');
		
		System.out.println(sb);
	}

}

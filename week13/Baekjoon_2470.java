package week13;

import java.io.*;
import java.util.*;

public class Baekjoon_2470 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		ArrayList<Integer> al = new ArrayList<>();
		st = new StringTokenizer(br.readLine());
		for (int i=0; i<N; i++) {
			al.add(Integer.parseInt(st.nextToken()));
		}
		
		al.sort(null);
		
		int start = 0;
		int end = al.size()-1;
		
		int ans1=start, ans2=end;
		long closeValue = (long)Math.pow(10, 9)*2 + 1;
		
		while (start < end) {
			long sum = (long)al.get(start) + al.get(end);
			
			if (Math.abs(sum) < closeValue) {
				closeValue = Math.abs(sum);
				ans1 = al.get(start);
				ans2 = al.get(end);
			}
			
			if (sum < 0) {
				start++;
			} else {
				end--;
			}
		}
		System.out.println(ans1 + " " + ans2);
	}
}

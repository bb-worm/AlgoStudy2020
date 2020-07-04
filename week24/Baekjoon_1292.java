package week24;

import java.io.*;
import java.util.*;

public class Baekjoon_1292 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		List<Integer> al = new ArrayList<>();
		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end= Integer.parseInt(st.nextToken());
		
		al.add(0);
		
		int ans = 0;
		int num = 1;
		while (true) {
			
			for (int i=0; i<num; i++) {
				al.add(num + al.get(al.size()-1));
			}
			num++;
			
			if (al.size() > end) {
				ans = al.get(end) - al.get(start-1);
				break;
			}
		}
		System.out.println(ans);
	}

}

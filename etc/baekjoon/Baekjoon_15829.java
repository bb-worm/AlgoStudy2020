package etc.baekjoon;

import java.io.*;
import java.util.*;

public class Baekjoon_15829 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int L = Integer.parseInt(br.readLine());
		char[] input = br.readLine().toCharArray();
		
		long r = 1;
		int M = 1234567891;
		
		double ans = 0;
		for (int i=0; i<L; i++) {
			ans += (double)(input[i]-'a'+1) * r;
			ans %= M;
			
			r *= 31;
			r %= M;
		}
		System.out.printf("%.0f\n",ans);
	}
}

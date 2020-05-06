package etc.baekjoon;

import java.io.*;
import java.util.*;

public class Baekjoon_2231 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int ans = 0;
		int sum;
		for (int i=1; i<=N; i++) {
			sum = i + getSum(i);
			
			if (sum==N) {
				ans = i;
				break;
			}
		}
		System.out.println(ans);
	}
	
	static int getSum(int i) {
		
		int sum = 0;
		
		while (i > 0) {
			sum += i % 10;
			i /= 10;
		}
		
		return sum;
		
	}

}

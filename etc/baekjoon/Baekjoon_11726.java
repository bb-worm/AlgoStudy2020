package etc.baekjoon;

import java.io.*;

public class Baekjoon_11726 {
	
	static long[] val;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		val = new long[1001];
		
		long ans = findAns(N);
		
		System.out.println(ans);
	}
	
	static long findAns(int n) {
		
		if (n < 0)
			return 0;
		
		if (n == 0)
			return 1;
		
		if (val[n] != 0) {
			return val[n];
		}
		
		return val[n] = ((findAns(n-1) + findAns(n-2)) % 10007);
	}

}

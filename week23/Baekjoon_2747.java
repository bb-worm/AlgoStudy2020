package week23;

import java.io.*;

public class Baekjoon_2747 {
	
	static int[] fibo;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		fibo = new int[N+1];
		System.out.println(getFibo(N));
	}
	
	static int getFibo(int n) {
		if (n == 0)
			return 0;
		else if (n == 1)
			return 1;
		else if (fibo[n] != 0)
			return fibo[n];
		else
			return fibo[n] = getFibo(n-2) + getFibo(n-1);
	}
}

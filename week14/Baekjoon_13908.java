package week14;

import java.io.*;
import java.util.*;

public class Baekjoon_13908 {
	
	static int n, m;
	static int[] isUse;
	
	static int ans;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		isUse = new int[10];
		Arrays.fill(isUse, 1);
		
		st = new StringTokenizer(br.readLine());
		for (int i=0; i<m; i++) {
			int num = Integer.parseInt(st.nextToken());
			isUse[num] = 0;
		}
		
		ans = 0;
		permutation(0, 0);

		System.out.println(ans);
	}

	static void permutation(int now, int choose) {
		
		if (now >= n) {
			
			if (choose != m)
				return;
			
			ans++;
			return;
		}
		
		if (n-now < m-choose)
			return;
		
		for (int i=0; i<=9; i++) {
			if (isUse[i] == 0) {
				isUse[i] = 1;
				permutation(now+1, choose+1);
				isUse[i] = 0;
			} else{
				permutation(now+1, choose);
			}
		}
	}
}

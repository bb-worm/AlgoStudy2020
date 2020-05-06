package week12;

import java.io.*;
import java.util.*;

public class Baekjoon_1043 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] knowTrue = new int[N+1];

		st = new StringTokenizer(br.readLine());
		int knowNum = Integer.parseInt(st.nextToken());
		for (int i=0; i<knowNum; i++) {
			int num = Integer.parseInt(st.nextToken());
			knowTrue[num]++;
		}
		
		boolean[] canGo = new boolean[M];
		Arrays.fill(canGo, true);
		
		// 진실 아는 사람 있는지 체크 
		int[][] party = new int[M][];
		for (int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int total = Integer.parseInt(st.nextToken());
			party[i] = new int[total];
			
			for (int j=0; j<total; j++) {
				party[i][j] = Integer.parseInt(st.nextToken());
				
				if (knowTrue[party[i][j]] != 0) {
					canGo[i] = false;
				}
			}
		}
		
		int[] visit = new int[M];
		boolean isChange = true;
		while (isChange) {
			isChange = false;
			
			// 진실 아는 사람과 함께 파티하는 사람 체크 
			for (int i=0; i<M; i++) {
				if (visit[i] == 0 && canGo[i] == false) {
					visit[i] = 1;
					for (int j=0; j<party[i].length; j++) {
						knowTrue[party[i][j]]++;
					}
				}
			}
			
			// 새롭게 영향 받은 파티 체크 
			for (int i=0; i<M; i++) {
				if (canGo[i] == true) {
					
					boolean isContain = false;
					for (int j=0; j<party[i].length; j++) {
						if (knowTrue[party[i][j]] != 0) {
							isContain = true;
							break;
						}
					}
					if (isContain) {
						isChange = true;
						canGo[i] = false;
					}
				}
			}
		}
		
		int ans = 0;
		for (int i=0; i<M; i++) {
			if (canGo[i])
				ans++;
		}
		System.out.println(ans);
	}
}

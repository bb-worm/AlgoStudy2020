package week10;

import java.io.*;
import java.util.*;

public class Baekjoon_2116 {
	
	static int N;
	static int[][] dice;
	
	static int ans;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		dice = new int[N][6];
		
		for (int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<6; j++) {
				dice[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		ans = 0;
		
		if (N > 0) {			
			for (int i=0; i<6; i++) {
				int oppo = getOpposite(i);
				
				int max = 0;
				for (int j=0; j<6; j++) {
					if (j==i || j==oppo)
						continue;
					max = Math.max(max, dice[0][j]);
				}
				DFS(1, dice[0][i], max);
			}
		}
		
		System.out.println(ans);
	}
	
	static void DFS(int idx, int num, int total) {
		if (idx >= N) {
			ans = Math.max(ans, total);
			return;
		}
		
		// 같은 숫자 적힌 인덱스 찾기 
		int sameIdx=0, oppoIdx=0;
		for (int i=0; i<6; i++) {
			if (dice[idx][i] == num) {
				sameIdx = i;
				oppoIdx = getOpposite(i);
				break;
			}
		}
		
		// 위아래 제외한 가장 큰 값 찾기
		int max = 0;
		for (int i=0; i<6; i++) {
			if (i==sameIdx || i==oppoIdx)
				continue;
			max = Math.max(max, dice[idx][i]);
		}
		
		DFS(idx+1, dice[idx][oppoIdx], total+max);
	}
	
	static int getOpposite(int i) {
		if (i==0)
			return 5;
		else if (i==1 || i==2)
			return i+2;
		else if (i==3 || i==4)
			return i-2;
		else
			return 0;
	}

}

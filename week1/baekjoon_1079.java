package week1;

import java.io.*;
import java.util.*;

public class baekjoon_1079 {
	
	public static int N;
	public static int[] point;
	public static int[][] R;
	public static int me;
	
	public static int[] isDead;
	
	public static int ans;

	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		point = new int[N];
		R = new int[N][N];
		isDead = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i=0; i<N; i++) {
			point[i] = Integer.parseInt(st.nextToken());
		}
		for (int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<N; j++) {
				R[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		me = Integer.parseInt(br.readLine());
		//////////////////////////////////////////////////
		
		ans = 0;
		playGame(N, 0);
		System.out.println(ans);
	}
	
	public static void playGame(int left, int totalNight) {
		if (left == 1) {		// win game 
			ans = totalNight;
			return;
		}
		
		if (left%2 == 0) { // night
			for (int i=0; i<N; i++) {
				if (i == me)
					continue;
				
				// if not dead
				if (isDead[i] == 0) {
					isDead[i] = 1;
					for (int j=0; j<N; j++) {
						point[j] += R[i][j];
					}
					
					playGame(left-1, totalNight + 1);
					
					for (int j=0; j<N; j++) {
						point[j] -= R[i][j];
					}
					isDead[i] = 0;
				}
			}
		}
		else { // day
			int idx = -1;
			int maxPoint = Integer.MIN_VALUE;
			
			for (int i=0; i<N; i++) {
				if (isDead[i] == 0 && point[i] > maxPoint) {
					idx = i;
					maxPoint = point[i];
				}
			}
			
			if (idx == me) {
				ans = Math.max(ans, totalNight);
				return;
			}
			else {
				isDead[idx] = 1;
				playGame(left-1, totalNight);
				isDead[idx] = 0;
			}
		}
	}
}

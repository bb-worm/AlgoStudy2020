package etc.baekjoon;

import java.io.*;
import java.util.*;

public class Baekjoon_2096 {
	
	static int[][] map;
	static int[][] max;
	static int[][] min;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		map = new int[N][3];
		max = new int[N][3];
		min = new int[N][3];
		
		for (int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<3; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i=0; i<3; i++)
			max[0][i] = min[0][i] = map[0][i];
		
		// find
		for (int i=1; i<N; i++) {
			for (int j=0; j<3; j++) {
				max[i][j] = map[i][j] + getPreMax(i, j);
				min[i][j] = map[i][j] + getPreMin(i, j);
			}
		}
		
		int ans1 = Math.max(max[N-1][0], Math.max(max[N-1][1], max[N-1][2]));
		int ans2 = Math.min(min[N-1][0], Math.min(min[N-1][1], min[N-1][2]));
		
		System.out.println(ans1 + " " + ans2);
	}
	
	static int getPreMax(int i, int j) {
		int result = 0;
		for (int k=-1; k<=1; k++) {
			if (j+k < 0 || j+k > 2)
				continue;
			
			result = Math.max(result, max[i-1][j+k]);
		}
		return result;
	}
	
	static int getPreMin(int i, int j) {
		int result = Integer.MAX_VALUE;
		for (int k=-1; k<=1; k++) {
			if (j+k < 0 || j+k > 2)
				continue;
			
			result = Math.min(result, min[i-1][j+k]);
		}
		return result;
	}
}

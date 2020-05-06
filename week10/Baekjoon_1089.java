package week10;

import java.io.*;
import java.util.*;

public class Baekjoon_1089 {
	
	static int N;
	static int[][] map;
	
	static int[][][] num = {{{1,1,1},
							 {1,0,1},
							 {1,0,1},
							 {1,0,1},
							 {1,1,1}},
							{{0,0,1},
							 {0,0,1},
							 {0,0,1},
							 {0,0,1},
							 {0,0,1}},
							{{1,1,1},
							 {0,0,1},
							 {1,1,1},
							 {1,0,0},
							 {1,1,1}},
							{{1,1,1},
							 {0,0,1},
							 {1,1,1},
							 {0,0,1},
							 {1,1,1}},
							{{1,0,1},
							 {1,0,1},
							 {1,1,1},
							 {0,0,1},
							 {0,0,1}},
							{{1,1,1},
							 {1,0,0},
							 {1,1,1},
							 {0,0,1},
							 {1,1,1}},
							{{1,1,1},
							 {1,0,0},
							 {1,1,1},
							 {1,0,1},
							 {1,1,1}},
							{{1,1,1},
							 {0,0,1},
							 {0,0,1},
							 {0,0,1},
							 {0,0,1}},
							{{1,1,1},
							 {1,0,1},
							 {1,1,1},
							 {1,0,1},
							 {1,1,1}},
							{{1,1,1},
							 {1,0,1},
							 {1,1,1},
							 {0,0,1},
							 {1,1,1}}}; 

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		map = new int[5][3*N];
		
		for (int i=0; i<5; i++) {
			char[] input = br.readLine().toCharArray();
			
			int k = 0;
			for (int j=0; j<4*N-1; j++) {
				if (j%4 == 3)
					continue;
				
				if (input[j] == '#')
					map[i][k] = 1;
				else
					map[i][k] = 0;
				
				k++;
			}
		}
//		printAll();
		
		double[] sum = new double[N];
		int[] count = new int[N];
		double totalCount = 1;
		for (int k=0; k<N; k++) {
			int[] possible = getPossible(k*3);
			
			sum[k] = possible[0] * Math.pow(10, (N-1-k));
			count[k] = possible[1];
			totalCount *= count[k];
		}
		
//		for (double i : sum)
//			System.out.printf("%.0f ",i);
//		System.out.println();
//		for (int i : count)
//			System.out.print(i + " ");
//		System.out.println();
//		System.out.println(totalCount);
//		System.out.println();
		
		if (totalCount == 0)
			System.out.println(-1);
		else {
			double ans = 0;
			for (int k=0; k<N; k++) {
				ans += (sum[k] / count[k]);
			}
			System.out.printf("%.5f\n", ans);
		}
	}
	
	static int[] getPossible(int offset) {
		int[] result = new int[2];
		
		int sum = 0;
		int total = 0;
		
		for (int i=0; i<10; i++) {
			int possible = 1;
			
			for (int n=0; n<5 && possible==1; n++) {
				for (int m=0; m<3; m++) {
					if (num[i][n][m]==0 && map[n][m+offset]==1) {
						possible = 0;
						break;
					}
				}
			}
			
			if (possible==1) {
				sum += i;
				total++;
			}
		}
		
		result[0] = sum;
		result[1] = total;
		
		return result;
	}
	
	static void printAll() {
		for (int i=0; i<5; i++) {
			for (int j=0; j<3*N; j++) {
				System.out.print(map[i][j] + " ");
			}System.out.println();
		}System.out.println();
	}

}

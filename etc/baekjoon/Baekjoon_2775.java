package etc.baekjoon;

import java.io.*;
import java.util.*;

public class Baekjoon_2775 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[][] map = new int[15][15];
		
		for (int i=0; i<15; i++) {
			for (int j=1; j<15; j++) {
				if (i==0) {
					map[i][j] = j;
				} else {
					map[i][j] = 0;
					for (int m=1; m<=j; m++) {
						map[i][j] += map[i-1][m];
					}
				}
			}
		}
		
//		for (int i=0; i<15; i++) {
//			for (int j=0; j<15; j++) {
//				System.out.printf("%2d ",map[i][j]);
//			}System.out.println();
//		}System.out.println();
		
		int T = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		
		int k, n;
		for (int t=0; t<T; t++) {
			
			k = Integer.parseInt(br.readLine());
			n = Integer.parseInt(br.readLine());
			
			sb.append(map[k][n]);
			sb.append('\n');
		}
		
		System.out.println(sb);

	}

}

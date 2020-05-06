package etc.baekjoon;

import java.io.*;
import java.util.*;

public class Baekjoon_2630 {
	
	static int N;
	static int[][] map;
	static int[][] visit;
	
	static int white;
	static int blue;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visit = new int[N][N];
		
		for (int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		white = 0;
		blue = 0;
		
		divide(0, 0, N, 0);
		divide(0, 0, N, 1);
		
		System.out.println(white);
		System.out.println(blue);
	}
	
	static int[] da = {0, 1, 1};
	static int[] db = {1, 0, 1};
	
	static void divide(int a, int b, int size, int type) {
		
		int allSame = 1;
		
		for (int i=a; i<a+size && allSame==1; i++) {
			for (int j=b; j<b+size; j++) {
				if (map[i][j] != type) {
					allSame = 0;
					break;
				}
			}
		}
		
		if (allSame == 1) {
			if (type == 0)
				white++;
			else
				blue++;
			
			return;
		} 
		else if (size == 1) {
			return;
		}
		else {
			
			int na = a + size/2;
			int nb = b + size/2;
			
			divide(a, b, size/2, type);
			divide(na, b, size/2, type);
			divide(a, nb, size/2, type);
			divide(na, nb, size/2, type);
		}
	}
	
	static void printVisit() {
		for (int i=0; i<N; i++) {
			for (int j=0; j<N; j++) {
				System.out.print(visit[i][j] + " ");
			}System.out.println();
		}System.out.println();
	}
}

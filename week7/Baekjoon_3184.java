package week7;

import java.io.*;
import java.util.*;

public class Baekjoon_3184 {
	
	static int R, C;
	static char[][] map;
	static int[][] visit;
	
	static int sheep, wolf;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new char[R][C];
		visit = new int[R][C];
		
		for (int i=0; i<R; i++) {
			char[] input = br.readLine().toCharArray();
			for (int j=0; j<C; j++) {
				map[i][j] = input[j];
			}
		}
		
		sheep = wolf = 0;
		for (int i=0; i<R; i++) {
			for (int j=0; j<C; j++) {
				if (map[i][j]!='#' && visit[i][j]==0) {
					BFS(i, j);
//					printVisit();
				}
					
			}
		}
		System.out.println(sheep + " " + wolf);
	}
	
	static int[] da = {-1, 1, 0, 0};
	static int[] db = {0, 0, -1, 1};
	
	static void BFS(int i, int j) {
		Queue<Integer> q = new LinkedList<>();
		
		q.add(i); q.add(j);
		visit[i][j] = 1;
		
//		int isValid = 1;
		int totalSheep = map[i][j]=='o' ? 1 : 0;
		int totalWolf = map[i][j]=='v' ? 1 : 0;
		
		int a, b;
		while (!q.isEmpty()) {
			a = q.poll(); b = q.poll();
			
			int na, nb;
			for (int k=0; k<4; k++) {
				na = a + da[k];
				nb = b + db[k];
				
				if (na<0||na>=R||nb<0||nb>=C) {
//					isValid = 0;
					continue;
				}
				
				if (visit[na][nb]!=0 || map[na][nb]=='#')
					continue;
				
				if (map[na][nb] == 'o') {
					totalSheep++;
				} else if (map[na][nb] == 'v') {
					totalWolf++;
				}
				
				q.add(na); q.add(nb);
				visit[na][nb] = 1;
			}
		}
		if (totalSheep > totalWolf) {
			sheep += totalSheep;
		} else 
			wolf += totalWolf;
	}
	
	static void printMap() {
		for (int i=0; i<R; i++) {
			for (int j=0; j<C; j++) {
				System.out.print(map[i][j]);
			}System.out.println();
		}System.out.println();
	}
	
	static void printVisit() {
		for (int i=0; i<R; i++) {
			for (int j=0; j<C; j++) {
				System.out.print(visit[i][j]);
			}System.out.println();
		}System.out.println();
	}
}

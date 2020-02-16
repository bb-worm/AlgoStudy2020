package week2;

import java.io.*;
import java.util.*;

class Move {
	int a, b;
	int[] key;
	int val;
	
	public Move(int a, int b, int[] key, int val) {
		this.a = a;
		this.b = b;
		this.key = new int[6];
		for (int k=0; k<6; k++) {
			this.key[k] = key[k];
		}
		this.val = val;
	}
}

public class baekjoon_1194 {
	
	public static int N, M;
	public static int r, c;
	public static char[][] map;
	public static int[][][][][][][][] visit;
	public static int ans;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new char[N][M];
		visit = new int[N][M][2][2][2][2][2][2];
		ans = Integer.MAX_VALUE;
		
		char[] str;
		for (int i=0; i<N; i++) {
			str = br.readLine().toCharArray();
			for (int j=0; j<M; j++) {
				map[i][j] = str[j];
				
				if (map[i][j] == '0') {
					r = i; c = j;
				}
			}
		}
		start();
		if (ans == Integer.MAX_VALUE)
			ans = -1;
		System.out.println(ans);
	}
	
	public static int[] da = {-1, 1, 0, 0};
	public static int[] db = {0, 0, -1, 1};
	
	public static void start() {
		Queue<Move> q = new LinkedList<Move>();
		
		int[] arr = {0, 0, 0, 0, 0, 0};
		q.add(new Move(r, c, arr, 1));
		visit[r][c][0][0][0][0][0][0] = 1;
		
		int a, b;
		int[] key;
		int val;
		
		while(!q.isEmpty()) {
			Move m = q.poll();
			
			a = m.a;
			b = m.b;
			key = m.key;
			val = m.val;
			
//			printAll(a, b, key, val);
			
			int na, nb;
			int[] nKey = new int[6];
			
			for (int i=0; i<4; i++) {
				na = a + da[i];
				nb = b + db[i];
				
				if (na<0 || na>=N || nb<0 || nb>=M) {
					continue;
				}
				
				char ch = map[na][nb];
				
				if (ch == '#') {
					continue;
				}
				if (ch == '1') {
					ans = val;
					q.clear();
					return;
				}
				
				if (visit[na][nb][key[0]][key[1]][key[2]][key[3]][key[4]][key[5]] == 1) {
					continue;
				}
				
				//////////////////////////
				for (int k=0; k<6; k++) {
					nKey[k] = key[k];
				}
				
//				printAll(na, nb, nKey, val);
				
				// door
				if (ch >='A' && ch <= 'F') {
//					printAll(na, nb, nKey, val);
					if (nKey[ch-'A'] == 1) {
						visit[na][nb][nKey[0]][nKey[1]][nKey[2]][nKey[3]][nKey[4]][nKey[5]] = 1;
						q.add(new Move(na, nb, nKey, val+1));
//						printAll(na, nb, nKey, val);
					}
				}
				else {
					visit[na][nb][nKey[0]][nKey[1]][nKey[2]][nKey[3]][nKey[4]][nKey[5]] = 1;
					// key
					if (ch >= 'a' && ch <= 'f') {	
						nKey[ch-'a'] = 1;
					}
					q.add(new Move(na, nb, nKey, val+1));
//					printAll(na, nb, nKey, val);
				}
			}
		}
	}
	
	public static void printAll(int a, int b, int[] key, int val) {
		System.out.println(a + " " + b);
		System.out.println(val);
		for (int i=0; i<6; i++) {
			System.out.print(key[i] + " ");
		}System.out.println();
		System.out.println();
	}
}

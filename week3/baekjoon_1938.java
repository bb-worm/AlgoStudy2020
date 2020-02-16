package week3;

import java.io.*;
import java.util.*;

class Tree {
	int[] a, b, c;
	int type;
	
	public Tree (int[] a, int[] b, int[] c, int type) {
		this.a = new int[2];
		this.b = new int[2];
		this.c = new int[2];
		
		this.a[0] = a[0]; this.a[1] = a[1];
		this.b[0] = b[0]; this.b[1] = b[1];
		this.c[0] = c[0]; this.c[1] = c[1];
		
		this.type = type;
	}
}

public class baekjoon_1938 {
	public static int N;
	public static int[][] map;
	public static int[][][] visit;
	
	public static int ans;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visit = new int[N][N][2];
		
		int[][] B = new int[3][2];
		int idx = 0;
		
		char[] str;
		for (int i=0; i<N; i++) {
			str = br.readLine().toCharArray();
			for (int j=0; j<N; j++) {
				if (str[j] == 'E') {
					map[i][j] = 2;
				} else if (str[j] == 'B') {
					B[idx][0] = i;
					B[idx++][1] = j;
				} else {
					map[i][j] = str[j] - '0';
				}
			}
		}
		
		int type;
		// 세로 
		if (B[0][1] == B[1][1])
			type = 0;
		// 가로 
		else
			type = 1;
		
		ans = 0;
		Tree tree = new Tree(B[0], B[1], B[2], type);
		BFS(tree);
		System.out.println(ans);
	}
	
	public static int[] dy = {-1, 1, 0, 0};
	public static int[] dx = {0, 0, -1, 1};
	
	public static void BFS(Tree start) {
		Queue<Tree> q = new LinkedList<Tree>();
		
		q.add(start);
		visit[start.b[0]][start.b[1]][start.type] = 1;
		
		int[] a = new int[2];
		int[] b = new int[2];
		int[] c = new int[2];
		int[] na = new int[2];
		int[] nb = new int[2];
		int[] nc = new int[2];
		int type;
		int ntype;
		
		Tree t;
		
		int val;
		while(!q.isEmpty()) {
//			printVisit();
			t = q.poll();
			
			a[0] = t.a[0]; a[1] = t.a[1];
			b[0] = t.b[0]; b[1] = t.b[1];
			c[0] = t.c[0]; c[1] = t.c[1];
			type = t.type;
			
			val = visit[b[0]][b[1]][type];
			
			if (map[a[0]][a[1]] == 2 && map[b[0]][b[1]] == 2 && map[c[0]][c[1]] == 2) {
				ans = val-1;
				q.clear();
				return;
			}
			
			// 이동 
			for (int i=0; i<4; i++) {
				na[0] = a[0] + dy[i];
				na[1] = a[1] + dx[i];
				nb[0] = b[0] + dy[i];
				nb[1] = b[1] + dx[i];
				nc[0] = c[0] + dy[i];
				nc[1] = c[1] + dx[i];
				
				if (!check(na, nb, nc, type)) {
					continue;
				}
				
				q.add(new Tree(na, nb, nc, type));
				visit[nb[0]][nb[1]][type] = val + 1;
			}
			
			// 회전 
			if (canRotate(a, b, c, type)) {
				ntype = (type+1) % 2;
				rotate(a, b, c, type);
				q.add(new Tree(a, b, c, ntype));
				visit[b[0]][b[1]][ntype] = val + 1;
			}
		}
	}
	
	public static void rotate(int[] a, int[] b, int[] c, int type) {
		// 세로 -> 가로 
		if (type == 0) {
			a[0]++;
			a[1]--;
			c[0]--;
			c[1]++;
		}
		// 가로 -> 세로 
		else {
			a[0]--;
			a[1]++;
			c[0]++;
			c[1]--;
		}
	}
	
	public static boolean canRotate(int[] a, int[] b, int[] c, int type) {
		// 세로 
		if (type == 0) {
			
			if (visit[b[0]][b[1]][1] != 0)
				return false;
			
			if (a[1]<=0||a[1]>=N-1)
				return false;
			
			for (int i=a[0]; i<=c[0]; i++) {
				for (int j=a[1]-1; j<=a[1]+1; j++) {
					if (map[i][j] == 1)
						return false;
				}
			}
			return true;
		}
		// 가로 
		else {
			
			if (visit[b[0]][b[1]][0] != 0)
				return false;
			
			if (a[0]<=0||a[0]>=N-1)
				return false;
			
			for (int i=a[0]-1; i<=a[0]+1; i++) {
				for (int j=a[1]; j<=c[1]; j++) {
					if (map[i][j] == 1)
						return false;
				}
			}
			return true;
		}
	}
	
	public static boolean check(int[] a, int[] b, int[] c, int type) {
		if (a[0]<0||a[1]<0||b[0]<0||b[1]<0||c[0]<0||c[1]<0)
			return false;
		if (a[0]>=N||a[1]>=N||b[0]>=N||b[1]>=N||c[0]>=N||c[1]>=N)
			return false;
		if (map[a[0]][a[1]] == 1 || map[b[0]][b[1]] == 1 || map[c[0]][c[1]] == 1)
			return false;
		if (visit[b[0]][b[1]][type] != 0)
			return false;
		
		return true;
	}
	
	public static void printVisit() {
		for (int i=0; i<N; i++) {
			for (int k=0; k<2; k++) {
				for (int j=0; j<N; j++) {
					System.out.print(visit[i][j][k]);
				}System.out.print("     ");
			}System.out.println();
		}System.out.println();
	}

}

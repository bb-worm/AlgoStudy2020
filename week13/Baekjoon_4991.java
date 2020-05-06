package week13;

import java.io.*;
import java.util.*;

public class Baekjoon_4991 {
	
	static class Posi {
		int a, b;
		public Posi(int a, int b) {
			this.a = a;
			this.b = b;
		}
	}
	
	static int h, w;
	static int[][] map;
	static int[][] distance;
	static ArrayList<Posi> dust;
	
	static int[] isUse;
	
	static int ans;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		while(true) {
			st = new StringTokenizer(br.readLine());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			
			// 종료 
			if (w+h == 0)
				break;
			
			map = new int[h][w];
			dust = new ArrayList<>();
			int a=0, b=0;
			for (int i=0; i<h; i++) {
				char[] input = br.readLine().toCharArray();
				for (int j=0; j<w; j++) {
					if (input[j] == 'o') {
						a = i;
						b = j;
						map[i][j] = 1;
					} else if (input[j] == '*') {
						dust.add(new Posi(i, j));
						map[i][j] = dust.size()+1;
					} else if (input[j] == 'x') {
						map[i][j] = -1;
					} else {
						map[i][j] = 0;
					}
				}
			}
			distance = new int[dust.size()+2][dust.size()+2];

			BFS(1, a, b);
			for (int i=0; i<dust.size(); i++) {
				BFS(i+2, dust.get(i).a, dust.get(i).b);
			}
			
			ans = Integer.MAX_VALUE;
			for (int j=2; j<distance[0].length; j++) {
				if (distance[1][j]==0) {
					ans = -1;
				}
			}
			
			if (ans != -1) {
				isUse = new int[dust.size()];
				perm(1, 0, 0);
			}
			sb.append(ans).append('\n');
		}
		System.out.println(sb);
	}
	
	static void perm(int pre, int now, int sum) {
		
		if (sum >= ans)
			return;
		
		if (now >= dust.size()){
			ans = Math.min(ans, sum);
			return;
		}
		
		for (int i=0; i<dust.size(); i++) {
			if (isUse[i] == 0) {
				isUse[i] = 1;
				perm(i+2, now+1, sum+distance[pre][i+2]);
				isUse[i] = 0;
			}
		}
	}
	
	static int[] da = {-1, 1, 0, 0};
	static int[] db = {0, 0, -1, 1};
	
	static void BFS(int idx, int i, int j) {
		Queue<Integer> q = new LinkedList<>();
		int[][] visit = new int[h][w];
		
		q.add(i); q.add(j);
		visit[i][j] = 1;
		
		while (!q.isEmpty()) {
			int a = q.poll();
			int b = q.poll();
			
			int na, nb;
			for (int k=0; k<4; k++) {
				na = a + da[k];
				nb = b + db[k];
				
				if (na<0||na>=h||nb<0||nb>=w||map[na][nb]==-1||visit[na][nb]!=0)
					continue;
				
				if (map[na][nb] > 0) {
					distance[idx][map[na][nb]] = distance[map[na][nb]][idx] = visit[a][b];
				} 
				q.add(na); q.add(nb);
				visit[na][nb] = visit[a][b] + 1;
			}
		}
	}
	
	static void printArr(int[][] arr) {
		for (int i=0; i<h; i++) {
			for (int j=0; j<w; j++) {
				System.out.printf("%2d ",arr[i][j]);
			}System.out.println();
		}System.out.println();
	}
}

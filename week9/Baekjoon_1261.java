package week9;

import java.io.*;
import java.util.*;

public class Baekjoon_1261 {
	
	static int N, M;
	static int[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		
		for (int i=0; i<N; i++) {
			char[] input = br.readLine().toCharArray();
			for (int j=0; j<M; j++) {
				map[i][j] = input[j] - '0';
			}
		}
		
		int ans = BFS();
		System.out.println(ans);
	}
	
	static int[] da = {-1, 1, 0, 0};
	static int[] db = {0, 0, -1, 1};
	
	static class Node implements Comparable<Node>{
		int a, b;
		int breakNum;
		
		public Node (int a, int b, int breakNum) {
			this.a = a;
			this.b = b;
			this.breakNum = breakNum;
		}
		
		public int compareTo(Node n) {
			return this.breakNum - n.breakNum;
		}
	}
	
	static int BFS() {
		int result = 0;
		
		PriorityQueue<Node> pq = new PriorityQueue<>();
		int[][] visit = new int[N][M];
		for (int i=0; i<N; i++) {
			for (int j=0; j<M; j++) {
				visit[i][j] = Integer.MAX_VALUE;
			}
		}
		
		pq.add(new Node(0, 0, 0));
		visit[0][0] = 1;
		
		int a, b;
		int breakNum;
		while(!pq.isEmpty()) {
			Node n = pq.poll();
			a = n.a;
			b = n.b;
			breakNum = n.breakNum;
			
			if (a==N-1 && b==M-1) {
				pq.clear();
				result = breakNum;
				break;
			}
			
			int na, nb;
			for (int k=0; k<4; k++) {
				na = a + da[k];
				nb = b + db[k];
				
				if (na<0||na>=N||nb<0||nb>=M)
					continue;
				
				if (map[na][nb] == 1) {
					if (visit[na][nb] <= breakNum+1)
						continue;
					
					pq.add(new Node(na, nb, breakNum+1));
					visit[na][nb] = breakNum + 1;
				} else {
					if (visit[na][nb] <= breakNum)
						continue;
					
					pq.add(new Node(na, nb, breakNum));
					visit[na][nb] = breakNum;
				}
			}
		}
		return result;
	}
}
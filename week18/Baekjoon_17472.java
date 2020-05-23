package week18;

import java.io.*;
import java.util.*;

public class Baekjoon_17472 {
	
	static int N, M;
	static int[][] map;
	static Node[] node;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		
		
		for (int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int total = preprocessing();
		node = new Node[total+1];
		for (int i=1; i<=total; i++)
			node[i] = new Node(i);
		
		PriorityQueue<Edge> pq = connect();
		
		int ans = 0;
		while (!pq.isEmpty()) {
			Edge e = pq.poll();
			
			if (e.node1.find() != e.node2.find()) {
				e.node1.union(e.node2);
				ans += e.weight;
			}
		}
		
		for (int i=1; i<total && ans>=0; i++) {
			for (int j=i+1; j<=total; j++) {
				if (node[i].find() != node[j].find()) {
					ans = -1;
					break;
				}
			}
		}
		
		System.out.println(ans);
	}
	
	static class Node {
		int num;
		Node parent;
		
		public Node(int num) {
			this.num = num;
			this.parent = this;
		}
		
		public Node find() {
			if (this.parent == this)
				return this;
			else
				return this.parent = this.parent.find();
		}
		
		public void union(Node n) {
			this.find().parent = n.find();
		}
	}
	
	static class Edge implements Comparable<Edge>{
		Node node1, node2;
		int weight;
		
		public Edge(Node node1, Node node2, int weight) {
			this.node1 = node1;
			this.node2 = node2;
			this.weight = weight;
		}
		
		public int compareTo(Edge e) {
			return this.weight - e.weight;
		}
	}
	
	static PriorityQueue<Edge> connect() {
		
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		
		int[] result = new int[2];
		
		for (int i=0; i<N; i++) {
			for (int j=0; j<M; j++) {
				if (map[i][j] != 0) {
					
					int na, nb;
					for (int k=0; k<4; k++) {
						
						na = i + da[k];
						nb = j + db[k];
						if (na<0||na>=N||nb<0||nb>=M||map[na][nb]!=0)
							continue;
						
						result = go(na, nb, k, 0);
						if (result == null || result[1] < 2)
							continue;
						
						int now = map[i][j];
						int next = result[0];

						pq.add(new Edge(node[now], node[next], result[1]));
					}
				}
			}
		}
		
		return pq;
	}
	
	static int[] go(int a, int b, int k, int jump) {
		if (a<0||a>=N||b<0||b>=M) {
			return null;
		} else if (map[a][b] == 0) {
			return go(a+da[k], b+db[k], k, jump+1);			
		} else {
			return new int[] {map[a][b], jump};
		}
	}
	
	static int preprocessing() {
		int num = 1;
		
		boolean[][] visit = new boolean[N][M];
		
		for (int i=0; i<N; i++) {
			for (int j=0; j<M; j++) {
				if (map[i][j] != 0 && !visit[i][j]) {
					BFS(num, i, j, visit);
					num++;
				}
			}
		}
		
		return num-1;
	}
	
	static int[] da = {-1, 1, 0, 0};
	static int[] db = {0, 0, -1, 1};
	
	static void BFS(int num, int i, int j, boolean[][] visit) {
		Queue<Integer> q = new LinkedList<>();
		
		q.add(i); q.add(j);
		visit[i][j] = true;
		
		int a, b;
		while(!q.isEmpty()) {
			a = q.poll();
			b = q.poll();
			map[a][b] = num;
			
			int na, nb;
			for (int k=0; k<4; k++) {
				na = a + da[k];
				nb = b + db[k];
				
				if (na<0||na>=N||nb<0||nb>=M||visit[na][nb]||map[na][nb]==0)
					continue;
				
				q.add(na); q.add(nb);
				visit[na][nb] = true;
			}
		}
	}
	
	static void print() {
		for (int i=0; i<N; i++) {
			for (int j=0; j<M; j++) {
				System.out.print(map[i][j] + " ");
			}System.out.println();
		}System.out.println();
	}

}

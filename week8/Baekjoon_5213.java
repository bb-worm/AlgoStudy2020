package week8;

import java.io.*;
import java.util.*;

public class Baekjoon_5213 {
	
	static class Node{
		int a, b;
		
		int num;
		int left, right;
		
		int preA, preB;
		
		public Node(int a, int b, int num, int left, int right) {
			this.a = a;
			this.b = b;
			this.num = num;
			this.left = left;
			this.right = right;
		}
	}
	
	static Node[][] node;
	
	static int N;
	static int ansLength;
	static String ansPath;
	
	static int[][] visit;
	
	static int lastA, lastB;
	
	public static void main(String[] agrs) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		node = new Node[N][N];
		visit = new int[N][N];
		
		int num = 1;
		for (int i=0; i<N; i++) {
			for (int j=0; j<N; j++) {
				if (i%2 != 0 && j==N-1)
					continue;
				
				st = new StringTokenizer(br.readLine());
				int left, right;
				left = Integer.parseInt(st.nextToken());
				right = Integer.parseInt(st.nextToken());
				node[i][j] = new Node(i, j, num, left, right);
				num++;
			}
		}
		
		ansLength = Integer.MAX_VALUE;
		BFS();
		
//		System.out.println(node[1][1].num);
//		System.out.println(node[1][1].preA +  " " + node[1][1].preB);
		
		ansPath = "";
		Node now;
		while (lastA != 0 || lastB != 0) {
			now = node[lastA][lastB];
			ansPath = now.num + " " + ansPath;
			lastA = now.preA;
			lastB = now.preB;
		} 
		ansPath = 1 + " " + ansPath;
		
		System.out.println(ansLength);
		System.out.println(ansPath.trim());
	}
	
	static int[][] da = {{-1, -1, 1, 1, 0, 0},
						{-1, -1, 1, 1, 0, 0}};
	static int[][] db = {{-1, 0, -1, 0, -1, 1},
						{0, 1, 0, 1, -1, 1}};
	
	static void BFS() {
		Queue<Node> q = new LinkedList<>();
		
		q.add(node[0][0]);
		visit[0][0] = 1;
		lastA = 0;
		lastB = 0;
		
		int a, b, left, right;
		while(!q.isEmpty()) {
			Node n = q.poll();
			a = n.a; b = n.b;
			left = n.left; right = n.right;
//			printVisit();
			if (node[a][b].num > node[lastA][lastB].num) {
				lastA = a;
				lastB = b;
				ansLength = visit[a][b];
			}
			
			int na, nb;
			for (int i=0; i<6; i++) {
				int k = a%2;
				na = a + da[k][i];
				nb = b + db[k][i];
				
				if (na<0||na>=N||nb<0||nb>=N||visit[na][nb]!=0)
					continue;
				if (na%2!=0 && nb==N-1)
					continue;
				
				// left side - upleft, downleft, left
				if (i==0 || i==2 || i==4) {
					if (left == node[na][nb].right) {
						q.add(node[na][nb]);
						visit[na][nb] = visit[a][b] + 1;
						node[na][nb].preA = a;
						node[na][nb].preB = b;
					}
				}
				// right side - upright, downright, right
				else {
					if (right == node[na][nb].left) {
						q.add(node[na][nb]);
						visit[na][nb] = visit[a][b] + 1;
						node[na][nb].preA = a;
						node[na][nb].preB = b;
					}
				}
			}
		}
	}
	
	static void printVisit() {
		for (int i=0; i<N; i++) {
			for (int j=0; j<N; j++) {
				System.out.print(visit[i][j]);
			}System.out.println();
		}System.out.println();
	}
}

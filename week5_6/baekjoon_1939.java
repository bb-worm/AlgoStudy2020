package week5_6;

import java.io.*;
import java.util.*;

public class baekjoon_1939 {
	
	static class Node {
		int idx;
		int val;
		ArrayList<Node> edge;
		ArrayList<Integer> weight;
		int isVisit;
		
		public Node (int idx) {
			this.idx = idx;
			this.val = Integer.MIN_VALUE;
			this.edge = new ArrayList<>();
			this.weight = new ArrayList<>();
			this.isVisit = 0;
		}
		
		public void addEdge(int idx, int weight) {
			this.edge.add(node[idx]);
			this.weight.add(weight);
		}
	}
	
	public static int N, M;
	
	public static Node[] node;
	
	public static int Start, End;
	public static int ans;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		node = new Node[N];
		for (int i=0; i<N; i++)
			node[i] = new Node(i);
		
		int a, b;
		int weight;
		for (int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken())-1;
			b = Integer.parseInt(st.nextToken())-1;
			weight = Integer.parseInt(st.nextToken());
			
			// 중복 체크 
			int isDuplicate = 0;
			for (int j=0; j<node[a].edge.size(); j++) {
				if (node[a].edge.get(j).idx == b) {
					isDuplicate = 1;
					int nowWeight = node[a].weight.get(j);
					if (nowWeight < weight) {
						node[a].weight.set(j, weight);
						for (int k=0; k<node[b].edge.size(); k++) {
							if (node[b].edge.get(k).idx == a) {
								node[b].weight.set(k, weight);
								break;
							}
						}
					}
					break;
				}
			}
			
			if (isDuplicate == 0) {
				node[a].addEdge(b, weight);
				node[b].addEdge(a, weight);
			}
		}
		
		st = new StringTokenizer(br.readLine());
		Start = Integer.parseInt(st.nextToken())-1;
		End = Integer.parseInt(st.nextToken())-1;
		ans = Integer.MIN_VALUE;
		
		int now = Start;
		node[Start].val = Integer.MAX_VALUE;
		int visitNum = 0;
		while (visitNum < N) {
			node[now].isVisit = 1;
			visitNum++;
			
			// relaxation
			for (int i=0; i<node[now].edge.size(); i++) {
				Node next = node[now].edge.get(i);
				if (next.isVisit == 1)
					continue;
				
				next.val = Math.min(node[now].val, Math.max(next.val, node[now].weight.get(i)));
			}
			
			// find next max
			int max = Integer.MIN_VALUE;
			for (int i=0; i<N; i++) {
				if (node[i].isVisit == 0 && max < node[i].val) {
					max = node[i].val;
					now = i;
				}
			}
		}
		
		System.out.println(node[End].val);
	}
}
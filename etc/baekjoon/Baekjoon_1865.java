package etc.baekjoon;

import java.io.*;
import java.util.*;

public class Baekjoon_1865 {
	
	static class Node {
		int idx;
		ArrayList<Node> next;
		ArrayList<Integer> time;
		long distance;
		
		public Node (int idx) {
			this.idx = idx;
			this.next = new ArrayList<>();
			this.time = new ArrayList<>();
			this.distance = Integer.MAX_VALUE;
		}
	}
	
	static int N, M, W;
	static Node[] node;
	static boolean hasNegativeCycle;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int TC = Integer.parseInt(br.readLine());
		for (int t=0; t<TC; t++) {
			
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			
			node = new Node[N+1];
			for (int i=1; i<=N; i++) {
				node[i] = new Node(i);
			}
			
			int S, E, T;
			for (int i=0; i<M; i++) {
				st = new StringTokenizer(br.readLine());
				S = Integer.parseInt(st.nextToken());
				E = Integer.parseInt(st.nextToken());
				T = Integer.parseInt(st.nextToken());
				
				node[S].next.add(node[E]);
				node[S].time.add(T);
				node[E].next.add(node[S]);
				node[E].time.add(T);
			}
			
			int[] holeIdx = new int[W];
			for (int i=0; i<W; i++) {
				st = new StringTokenizer(br.readLine());
				S = Integer.parseInt(st.nextToken());
				E = Integer.parseInt(st.nextToken());
				T = Integer.parseInt(st.nextToken());
				
				node[S].next.add(node[E]);
				node[S].time.add(-T);
				
				holeIdx[i] = S;
			}
			
			hasNegativeCycle = false;
			node[1].distance = 0;
			bellmanFord();
//			for (int i=0; i<W && !hasNegativeCycle; i++) {
//				bellmanFord(holeIdx[i]);
//				for (int k=1; k<=N && !hasNegativeCycle; k++) {
//					node[k].distance = Integer.MAX_VALUE;
//				}
//			}
			
			if (hasNegativeCycle)
				sb.append("YES").append('\n');
			else
				sb.append("NO").append('\n');
		}
		System.out.println(sb);
	}
	
	static void bellmanFord(){
		
		for (int t=0; t<N-1; t++) {
			for (int i=1; i<=N; i++) {
				Node now = node[i];
				
//				if (now.distance == Integer.MAX_VALUE)
//					continue;
				
				Node next;
				int time;
				for (int j=0; j<now.next.size(); j++) {
					next = now.next.get(j);
					time = now.time.get(j);
					
					// relaxation
					next.distance = Math.min(next.distance, now.distance+time);
				}
			}
		}
		
		// n번째에도 바뀌는 값이 있는지 확인 
		for (int i=1; i<=N; i++) {
			Node now = node[i];
			
//			if (now.distance == Integer.MAX_VALUE)
//				continue;
			
			Node next;
			int time;
			for (int j=0; j<now.next.size(); j++) {
				next = now.next.get(j);
				time = now.time.get(j);
				
				if (next.distance > now.distance + time) {
					hasNegativeCycle = true;
					return;
				}
			}
		}
	}
}

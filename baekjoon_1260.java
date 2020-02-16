import java.io.*;
import java.util.*;

public class baekjoon_1260 {
	
	public static int N, M, V;
	
	public static int[][] connect;
	public static int[] visit;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		
		connect = new int[N+1][N+1];
		visit = new int[N+1];
		int a, b;
		for (int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			connect[a][b] = connect[b][a] = 1;
		}
		
		DFS();
		for(int i=1; i<=N; i++) visit[i] = 0;
		System.out.println();
		BFS();
	}
	
	public static Stack<Integer> s = new Stack<Integer>();
	public static void DFS() {
		s.add(V);
		
		int v;
		while(!s.isEmpty()) {
			v = s.pop();
			if (visit[v] != 0)
				continue;
			
			visit[v] = 1;
			System.out.print(v + " ");
			
			for (int i=N; i>=1; i--) {
				if (i==v || visit[i] != 0)
					continue;
				
				if (connect[v][i] == 1) {
					s.add(i);
				}
			}
//			System.out.println(s);
		}
	}
	
	public static Queue<Integer> q = new LinkedList<Integer>();
	public static void BFS() {
		q.add(V);
		visit[V] = 1;
		System.out.print(V + " ");
		
		int v;
		while (!q.isEmpty()) {
			v = q.poll();
			
			for (int i=1; i<=N; i++) {
				if (i==v || visit[i] != 0)
					continue;
					
				if (connect[v][i] == 1) {
					q.add(i);
					visit[i] = 1;
					System.out.print(i + " ");
				}	
			}
		}
	}
}

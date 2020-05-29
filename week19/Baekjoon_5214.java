package week19;

import java.io.*;
import java.util.*;

public class Baekjoon_5214 {
	
	static class Tube{
		int idx;
		Set<Integer> stations;
		public Tube(int idx) {
			this.idx = idx;
			this.stations = new HashSet<Integer>();
		}
	}
	
	static int N, K, M;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		Tube[] tube = new Tube[M];
		List<Integer>[] tubeList = new List[N+1];
		for (int i=1; i<=N; i++) {
			tubeList[i] = new ArrayList<Integer>();
		}
		
		// tube 생성 및 station이 포함된 tube 리스트 만들기 
		for (int i=0; i<M; i++) {
			tube[i] = new Tube(i);
			
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<K; j++) {
				int station = Integer.parseInt(st.nextToken());
				tube[i].stations.add(station);
				tubeList[station].add(i);
			}
		}
		
		if (N > 1) {
			int ans = BFS(tube, tubeList);
			System.out.println(ans);
		} else {
			System.out.println(1);
		}
	}
	
	static int BFS(Tube[] tube, List<Integer>[] tubeList) {
		Queue<Tube> q = new LinkedList<Tube>();
		int[] visitTube = new int[tube.length];
		boolean[] visitStation = new boolean[N+1];
		
		// 1이 포함된 튜브들 큐에 담기
		for (int i=0; i<tube.length; i++) {
			if(tube[i].stations.contains(1)) {
				q.add(tube[i]);
				visitTube[i] = 1;
			}
		}
		visitStation[1] = true;
		
		Tube t;
		while(!q.isEmpty()) {
			t = q.poll();
			
			for (int station : t.stations) {
				// 방문 여부 확인 
				if (visitStation[station])
					continue;
				visitStation[station] = true;
				
				// 목적지 도착 
				if (station == N) {
					q.clear();
					return visitTube[t.idx]+1;
				}
				
                // 해당 역과 연결된 하이퍼튜브 확인하여 방문되지 않았으면 큐에 넣기
				for (int i=0; i<tubeList[station].size(); i++) {
					int nextTube = tubeList[station].get(i);
					if (visitTube[nextTube] == 0) {
						q.add(tube[nextTube]);
						visitTube[nextTube] = visitTube[t.idx]+1;
					}
				}
			}
		}
		
		return -1;
	}
	

}

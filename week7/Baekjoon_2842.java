package week7;

import java.io.*;
import java.util.*;

public class Baekjoon_2842 {
	
	static int N;
	static char[][] town;
	static int[][] height;
	
	static int sa, sb;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		town = new char[N][N];
		height = new int[N][N];
		
		int homeNum = 0;
		
		for (int i=0; i<N; i++) {
			town[i] = br.readLine().toCharArray();
			for (int j=0; j<N; j++) {
				if (town[i][j] == 'P') {
					sa = i; sb = j; // BFS 시작 지점 
				} else if (town[i][j] == 'K') {
					homeNum++; // 집 개수 파악 
				}
			}
		}
		
		ArrayList<Integer> al = new ArrayList<>(); // 높이 저장 
		
		int maxH = 0;
		int minH = Integer.MAX_VALUE;
		for (int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<N; j++) {
				height[i][j] = Integer.parseInt(st.nextToken());
				if (town[i][j] == 'P' || town[i][j] == 'K') {
					maxH = Math.max(maxH, height[i][j]);
					minH = Math.min(minH, height[i][j]);
				}
				if (!al.contains(height[i][j])) // unique 하게 저장 
					al.add(height[i][j]);
			}
		}
		
		al.sort(null); // 높이 정렬 
		
		int minIdx = 0; // 최소 높이 idx
		int maxIdx = 0; // 최대 높이 idx 찾기 
		for (int i=0; i<al.size(); i++) {
			if (al.get(i) == maxH) {
				maxIdx = i;
				break;
			}
		}
		
		int ans = Integer.MAX_VALUE;
		
		// maxIdx가 범위 벗어나거나, min 값이 집의 최솟값 벗어나면 종료 
		while (maxIdx < al.size() && al.get(minIdx) <= minH) {

			int result = BFS(al.get(minIdx), al.get(maxIdx));

			// 모든 집을 탐색할 수 있으면 최소 범위 늘임 
			if (result == homeNum) {
				ans = Math.min(ans, al.get(maxIdx) - al.get(minIdx));
				minIdx++;
				
				if (minIdx > maxIdx)
					maxIdx++;
			}
			else { // 모든 집을 탐색할 수 없으면 최대 범위 늘임 
				maxIdx++;
			}
		}
		System.out.println(ans);
	}
	
	static int[] da = {-1, 1, 0, 0, -1, 1, 1, -1};
	static int[] db = {0, 0, -1, 1, 1, 1, -1, -1};
	
	static int BFS(int minH, int maxH) {
		int result = 0;
		
		Queue<Integer> q = new LinkedList<>();
		int[][] visit = new int[N][N];
		
		q.add(sa); q.add(sb);
		visit[sa][sb] = 1;
		
		while (!q.isEmpty()) {
			int a = q.poll();
			int b = q.poll();
			
			if (town[a][b] == 'K')
				result++;
			
			int na, nb;
			for (int k=0; k<8; k++) {
				na = a + da[k];
				nb = b + db[k];
				
				if (na<0||na>=N||nb<0||nb>=N||visit[na][nb]!=0)
					continue;
				
				// 구간 안에 갈 수 있는 고도인지 확인
				if (height[na][nb] >= minH && height[na][nb] <= maxH) {
					q.add(na); q.add(nb);
					visit[na][nb] = 1;
				}
			}
		}
		return result;
	}
}

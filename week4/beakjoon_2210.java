package week4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.HashMap;

public class beakjoon_2210 {
	
	public static int N;
	public static int[][] map;
	
	public static HashMap<String, Integer> hm = new HashMap<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = 5;
		map = new int[N][N];
		for (int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i=0; i<N; i++) {
			for (int j=0; j<N; j++) {
				DFS(i, j, 0, Integer.toString(map[i][j]));
			}
		}
		System.out.println(hm.size());
		hm.clear();
	}
	public static int[] da = {-1, 1, 0, 0};
	public static int[] db = {0, 0, -1, 1};
	
	public static void DFS(int a, int b, int total, String str) {
		if (total >= 5) {
			hm.put(str, hm.getOrDefault(str, 0) + 1);
			return;
		}
		
		int na, nb;
		for (int i=0; i<4; i++) {
			na = a + da[i];
			nb = b + db[i];
			
			if (na<0||na>=N||nb<0||nb>=N)
				continue;
			
			DFS(na, nb, total+1, str + map[na][nb]);
		}
	}
}

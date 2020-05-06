package week12;

import java.io.*;
import java.util.*;

public class Baekjoon_6593 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int[] da = {-1, 1, 0, 0, 0, 0};
		int[] db = {0, 0, -1, 1, 0, 0};
		int[] dc = {0, 0, 0, 0, -1, 1};
		
		while (true) {
			st = new StringTokenizer(br.readLine());
			int L, R, C;
			L = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			
			if (L == 0)
				break;
			
			char[][][] map = new char[L][R][C];
			int[][][] visit = new int[L][R][C];
			
			Queue<Integer> q = new LinkedList<>();			
			for (int i=0; i<L; i++) {
				for (int j=0; j<R; j++) {
					char[] input = br.readLine().toCharArray();
					for (int k=0; k<C; k++) {
						map[i][j][k] = input[k];
						
						if (map[i][j][k] == 'S') {
							q.add(i);
							q.add(j);
							q.add(k);
							visit[i][j][k] = 1;
						}
					}
				}
				br.readLine();
			}
			
			int ans = 0;
			
			int a, b, c;
			while(!q.isEmpty()) {
				a = q.poll();
				b = q.poll();
				c = q.poll();
				
				int na, nb, nc;
				for (int i=0; i<6; i++) {
					na = a + da[i];
					nb = b + db[i];
					nc = c + dc[i];
					
					if (na<0||na>=L||nb<0||nb>=R||nc<0||nc>=C||visit[na][nb][nc]!=0||map[na][nb][nc]=='#')
						continue;
					
					if (map[na][nb][nc] == 'E') {
						ans = visit[a][b][c];
						q.clear();
						break;
					}
					
					q.add(na); q.add(nb); q.add(nc);
					visit[na][nb][nc] = visit[a][b][c] + 1;
				}
			}
			
			if (ans == 0) {
				sb.append("Trapped!").append('\n');
			} else {
				sb.append("Escaped in ").append(ans).append(" minute(s).").append('\n');
			}
		}
		System.out.println(sb);
	}

}

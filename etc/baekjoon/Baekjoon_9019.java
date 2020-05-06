package etc.baekjoon;

import java.io.*;
import java.util.*;

public class Baekjoon_9019 {
	
	static int A, B;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for (int t=0; t<T; t++) {
			
			st = new StringTokenizer(br.readLine());
			A = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			
			BFS();
		}
		
		System.out.println(sb);
	}
	
	static class Move {
		int num;
		ArrayList<Character> al;
		
		public Move(int num) {
			this.num = num;
			this.al = new ArrayList<>();
		}
		
		public Move (int num, ArrayList<Character> al) {
			this.num = num;
			this.al = al;
		}
	}
	
	static char[] oper = {'D', 'S', 'L', 'R'};
	
	static void BFS() {
		Queue<Move> q = new LinkedList<>();
		int[] visit = new int[10000];
		
		q.add(new Move(A));
		visit[A] = 1;
		
		int num;
		while (!q.isEmpty()) {
			Move m = q.poll();
			num = m.num;
			
			if (num == B) {
				for (char ch : m.al) {
					sb.append(ch);
				}sb.append('\n');
				
				q.clear();
				return;
			}
			
			int nNum;
			ArrayList<Character> al;
			for (int i=0; i<4; i++) {
				nNum = changeNum(num, i);
				
				if (visit[nNum] == 1)
					continue;
				
				al = new ArrayList<>();
				for (char ch : m.al)
					al.add(ch);
				al.add(oper[i]);
				
				q.add(new Move(nNum, al));
				visit[nNum] = 1;
			}
		}
	}
	
	static int changeNum(int num, int method) {
		if (method == 0) {
			return (2*num) % 10000;
		} else if (method == 1) {
			return num != 0 ? (num-1) : 9999;
		} else if (method == 2) {
			return (num%1000)*10 + (num/1000);
		}  else {
			return (num%10)*1000 + (num/10); 
		}
	}

}

package week17;

import java.io.*;
import java.util.*;

public class Baekjoon_3954 {
	
	static final int LIMIT = 50000000;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		Stack<Integer> s;
		Map<Integer, Integer> jump;
		
		int T = Integer.parseInt(br.readLine());
		for (int t=0; t<T; t++) {
			
			s = new Stack<>();
			jump = new HashMap<>();
			
			st = new StringTokenizer(br.readLine());
			int m = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int i = Integer.parseInt(st.nextToken());
			
			int[] memory = new int[m];
			char[] code = br.readLine().toCharArray();
			char[] input = br.readLine().toCharArray();
			
			for (int j=0; j<c; j++) {
				if (code[j] == '[') {
					s.push(j);
				} else if (code[j] == ']') {
					int idx = s.pop();
					jump.put(j, idx);
					jump.put(idx, j);
				}
			}
			
			int mIdx = 0;
			int cIdx = 0;
			int iIdx = 0;
			
			boolean isLoop = false;
			int loopStart=0, loopEnd=0;
			
			int cnt = 0;
			while (cIdx < c) {
				cnt++;
				if (cnt > LIMIT) {
					isLoop = true;
					loopStart = jump.get(loopEnd);
					sb.append("Loops ").append(loopStart).append(' ').append(loopEnd).append('\n');
					break;
				}
				
				char now = code[cIdx];
				
				if (now == '-') {
					if (memory[mIdx] == 0) {
						memory[mIdx] = 255;
					} else {
						memory[mIdx]--;
					}
				} else if (now == '+') {
					if (memory[mIdx] == 255) {
						memory[mIdx] = 0;
					} else {
						memory[mIdx]++;
					}
				} else if (now == '<') {
					mIdx--;
					if (mIdx < 0)
						mIdx = m - 1;
				} else if (now == '>') {
					mIdx++;
					if (mIdx >= m)
						mIdx = 0;
				} else if (now == '[') {
					if (memory[mIdx] == 0) {
						cIdx = jump.get(cIdx);
						continue;
					}
				} else if (now == ']') {
					if (memory[mIdx] != 0) {
						if (loopEnd < cIdx)
							loopEnd = cIdx;
						
						cIdx = jump.get(cIdx);
						continue;
					}
				} else if (now == ','){
					if (iIdx < i) {
						memory[mIdx] = (int)input[iIdx];
						iIdx++;
					} else {
						memory[mIdx] = 255;
					}
				}
				
				cIdx++;
			}
			if (!isLoop)
				sb.append("Terminates").append('\n');
		}
		System.out.println(sb);
	}
}

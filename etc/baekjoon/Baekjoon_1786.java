package etc.baekjoon;

import java.io.*;
import java.util.*;

public class Baekjoon_1786 {
	
	static char[] n, m;
	static int[] p;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		n = br.readLine().toCharArray();
		m = br.readLine().toCharArray();
		
		// p : 문자가 일치하지 않을 때, 새로 비교하기 시작할 인덱스를 저장 
		p = new int[m.length];
		preprocessing();
		int ans = processing(sb);
		System.out.println(ans);
		System.out.println(sb);
	}
	
	static int processing(StringBuilder sb) {
		int ans = 0;
		
		int j = 0;
		for (int i=0; i<n.length; ) {
			
			while (j>0 && n[i]!=m[j])
				j = p[j-1];
			
			if (n[i] == m[j]) {
				i++;
				
				// 패턴 전체가 일치 
				if (j == m.length-1) {
					ans++;
					sb.append(i-m.length+1).append(' ');
					j = p[j];
				} else {
					j++;
				}
			} else {
				i++;
			}
		}
		
		return ans;
	}
	
	static void preprocessing() {
		// 전처리 
		int i=1, j=0;
		
		p[0] = 0;
		while (i < p.length) {
			
			// 문자가 일치하지 않으면
			// 다음 패턴 위치를 찾거나 j=0일 때까지 j를 재지정
			while (j>0 && m[i]!=m[j])
				j = p[j-1];
			
			// 문자가 같으면 일치하는 패턴 위치 저장
			if (m[i] == m[j]) {
				p[i] = j+1;
				i++;
				j++;
			} 
			// 문자가 다르면 일치하는 패턴이 없음을 의미 
			// j는 0인 상태 
			else {
				p[i] = 0;
				i++;
			}
		}
	}
}

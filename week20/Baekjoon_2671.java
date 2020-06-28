package week20;

import java.io.*;
import java.util.regex.*;

public class Baekjoon_2671 {
	
	static String ans;
	static char[] input;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		input = str.toCharArray();
		
		// type : 1 => 100..1..
		// type : 2 => 01..
		
		ans = "NOISE";
		DFS(0);
		
		System.out.println(ans);
	}
	
	// 정규 표현식 사용 
	static boolean match(String str) {
		return Pattern.matches("(100+1+|01)+", str);
	}
	
	// 정규 표현식 안 사용 
	static void DFS(int now) {
		if (ans.equals("SUBMARINE"))
			return;

		if (now >= input.length) {
			ans = "SUBMARINE";
			return;
		}
		
		if (input[now] == '1') {
			
			if (now+3>=input.length || input[now+1]=='1' || input[now+2]=='1')
				return;
			now += 3;
			
			while (now < input.length && input[now] == '0')
				now++;
			
			if (now == input.length)
				return;
			
			while (now < input.length && input[now] == '1')
				now++;
			
			if (input[now-2] == '1')
				DFS(now-1); // 100일 가능성 
			DFS(now); // 01 또는 끝났을 가능성 
		} else {
			if (now+1>=input.length || input[now+1]=='0')
				return;
			now += 2;
			
			DFS(now); 
		}
	}
}

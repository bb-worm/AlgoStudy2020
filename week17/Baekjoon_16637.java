package week17;

import java.io.*;

public class Baekjoon_16637 {
	
	static int ans;
	
	static int[] num; // 수식에서 숫자 저장
	static char[] oper; // 수식에서 연산자 저장

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		char[] input = br.readLine().toCharArray();
		
		num = new int[N/2+1];
		oper = new char[N/2];
		
		int n=0, o=0;
		for (int i=0; i<N; i++) {
			if (i%2 == 0) {
				num[n] = input[i] - '0';
				n++;
			} else {
				oper[o] = input[i];
				o++;
			}
		}
		
		ans = Integer.MIN_VALUE;
		DFS(0, num[0]);
		System.out.println(ans);
	}
	
	static void DFS(int idx, int result) {
		
		if (idx >= oper.length){
			ans = Math.max(ans, (int)result);
			return;
		}
		
		DFS(idx+1, cal(result, num[idx+1], oper[idx]));
		
		if (idx+1 < oper.length) {
			int next = cal(num[idx+1], num[idx+2], oper[idx+1]);
			DFS(idx+2, cal(result, next, oper[idx]));
		}
	}
	
	static int cal(int num1, int num2, char oper) {
		
		int result;
		
		if (oper == '+') {
			result = num1 + num2;
		} else if (oper == '-') {
			result = num1 - num2;
		} else if (oper == '*') {
			result = num1 * num2;
		} else { // /
			if (num2 == 0)
				result = 0;
			else 
				result = num1 / num2;
		}
		
		return result;
	}

}

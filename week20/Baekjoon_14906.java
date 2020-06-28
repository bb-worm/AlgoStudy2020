package week20;

import java.io.*;
import java.util.*;

public class Baekjoon_14906 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		sb.append("SLURPYS OUTPUT").append('\n');
		int N = Integer.parseInt(br.readLine());
		for (int i=0; i<N; i++) {
			String input = br.readLine();
			
			// 스림프와 스럼프 나뉘는 부분 찾기 
			int mid = input.length() - 1;
			while (mid>=0 && input.charAt(mid)!='C' && input.charAt(mid)!='H'){
				mid--;
			}
			
			if (mid>=0 && isSlimp(input.substring(0, mid+1)) && isSlump(input.substring(mid+1))) {
				sb.append("YES").append('\n');
			}
			else {
				sb.append("NO").append('\n');
			}
		}
		sb.append("END OF OUTPUT");
		System.out.println(sb);
	}
	
	static boolean isSlimp(String str) {
		int len = str.length();
		
		if (len < 2) // 길이 검증 
			return false;
		else if (len == 2) { // 길이가 2일 때 검증 
			if (str.equals("AH"))
				return true;
			else 
				return false; 
		} else {
			// 길이가 2보다 클 때 시작과 끝 문자 검증 
			if (str.charAt(0) != 'A' || str.charAt(len-1) != 'C')
				return false;  
			
			// 두번째 문자에 따라 스림프 또는 스럼프 검증 
			if (str.charAt(1) == 'B') {
				return isSlimp(str.substring(2, len-1));
			} else {
				return isSlump(str.substring(1, len-1));
			}
		}
	}
	
	static boolean isSlump(String str) {
		int len = str.length();
		
		// 길이 검증 
		if (len < 3)
			return false;
		else if (str.charAt(0)!='D' && str.charAt(0)!='E') // 시작 문자 검증 
			return false;
		else if (str.charAt(1) != 'F') // 두번째 문자 검증 
			return false;
		else if (str.charAt(len-1) != 'G') // 마지막 문자 검증 
			return false;
		
		// F 끝나는 부분 찾기 
		int idxF = 2;
		while (idxF < len && str.charAt(idxF) == 'F')
			idxF++;
		
		if (idxF == len)
			return false;
		else if (idxF == len-1) // 스럼프 끝부분 
			return true;
		
		return isSlump(str.substring(idxF));
	}
}

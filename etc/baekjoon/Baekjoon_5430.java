package etc.baekjoon;

import java.io.*;
import java.util.*;

public class Baekjoon_5430 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for (int t=0; t<T; t++) {
			
			char[] p = br.readLine().toCharArray();
			int n = Integer.parseInt(br.readLine());
			ArrayList<Integer> arr = new ArrayList<>();
			
			String input = br.readLine();
			input = input.substring(1, input.length()-1);
			String[] num = input.split(",");
			for (int i=0; i<n; i++) {
				arr.add(Integer.parseInt(num[i]));
			}
			
			int isError = 0;
			int order = 0;
			for (char ch : p) {
				if (ch == 'R') {
					order = (order+1) % 2;
				} else {
					if (arr.size() == 0) {
						isError = 1;
						sb.append("error").append('\n');
						break;
					}
					
					if (order == 0) {
						arr.remove(0);
					} else {
						arr.remove(arr.size() - 1);
					}
				}
			}
			
			if (isError == 0) {
				sb.append('[');
				if (order == 0) {
					for (int i=0; i<arr.size(); i++) {
						if (i != 0)
							sb.append(',');
						sb.append(arr.get(i));
					}
				} else {
					for (int i=arr.size()-1; i>=0; i--) {
						if (i != arr.size()-1)
							sb.append(",");
						sb.append(arr.get(i));
					}
				}
				sb.append("]\n");
			}
		}
		System.out.println(sb);
	}
}

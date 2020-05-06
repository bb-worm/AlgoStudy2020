package etc.swea;

import java.io.*;
import java.util.*;

public class swea_1244 {
	
	public static int ans;
	public static int max;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for (int t=1; t<=T; t++) {
			System.out.print("#" + t + " ");
			
			st = new StringTokenizer(br.readLine());
			
			ans = Integer.parseInt(st.nextToken());
			char[] str = Integer.toString(ans).toCharArray();
			int[] num = new int[str.length];
			
			for (int i=0; i<str.length; i++) {
				num[i] = str[i] - '0';
			}
			
			int limit = Integer.parseInt(st.nextToken());
			
//			max = makeMax(num, limit);
//			System.out.println(max);
//			
			if (limit >= num.length) {
				if ((limit-num.length)%2 == 1) {
					limit = num.length-1;
				} else {
					limit = num.length-2;
				}
			}
			
			if (limit > 0)
				DFS(0, limit, num);
			DFS(0, limit, num);
			
			System.out.println(ans);
		}
	}
	
	public static int makeMax(int[] num, int limit) {
		int[] tmp = new int[num.length];
		
		for (int i=0; i<num.length; i++) {
			tmp[i] = num[i];
		}
		
		Arrays.sort(tmp);
		
		String result = "";
		for (int i=tmp.length-1; i>=0; i--) {
			result += tmp[i];
		}
	
		return Integer.parseInt(result);
	}
	
	public static void DFS(int now, int limit, int[] num) {
		
		if (now >= limit) {
			String result = "";
			for (int i=0; i<num.length; i++) {
				result += num[i];
			}
			
			ans = Math.max(ans, Integer.parseInt(result));
			return;
		}
		
		for (int i=0; i<num.length-1; i++) {
			for (int j=i+1; j<num.length; j++) {
				
				int tmp = num[i];
				num[i] = num[j];
				num[j] = tmp;
				DFS(now+1, limit, num);
				num[j] = num[i];
				num[i] = tmp;
			}
		}
	}
}

package etc.baekjoon;

import java.io.*;

public class Baekjoon_3052 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] num = new int[42];
		
		for (int i=0; i<10; i++) {
			num[Integer.parseInt(br.readLine())%42]++;
		}
		
		int ans = 0;
		for (int i : num) {
			if (i > 0)
				ans++;
		}
		System.out.println(ans);
	}

}

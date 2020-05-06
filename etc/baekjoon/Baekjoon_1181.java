package etc.baekjoon;

import java.io.*;
import java.util.*;

public class Baekjoon_1181 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		String[] arr = new String[N];
		
		for (int i=0; i<N; i++) {
			arr[i] = br.readLine();
		}
		
		Arrays.sort(arr, new Comparator<String>() {
			public int compare(String s1, String s2) {
				if (s1.length() == s2.length()) {
					return s1.compareTo(s2);
				} else {
					return s1.length() - s2.length();
				}
			}
		});
		
		for (int i=0; i<N; i++) {
			bw.write(arr[i]);
			bw.newLine();
			
			while (i+1 < N && arr[i].equals(arr[i+1]))
				i++;
		}
		bw.flush();
		
	}

}

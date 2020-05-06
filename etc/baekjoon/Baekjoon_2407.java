package etc.baekjoon;

import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Baekjoon_2407 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		if (m > n-m)
			m = n-m;
		
		BigInteger parent = BigInteger.ONE;
		for (int i=0; i<m; i++) {
			parent = parent.multiply(new BigInteger(Integer.toString(n-i)));
		}
		
		BigInteger child = BigInteger.ONE;
		for (int i=1; i<=m; i++) {
			child = child.multiply(new BigInteger(Integer.toString(i)));
		}
		
		System.out.println(parent.divide(child));
	}

}

package etc.baekjoon;

import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Baekjoon_1676 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		BigInteger fact = new BigInteger("1");
		for (int i=2; i<=N; i++) {
			fact = fact.multiply(new BigInteger(Integer.toString(i)));
		}
		
		int ans = 0;
		while (fact.mod(BigInteger.TEN) == BigInteger.ZERO) {
			fact = fact.divide(BigInteger.TEN);
			ans++;
		}
		System.out.println(ans);
		
	}

}

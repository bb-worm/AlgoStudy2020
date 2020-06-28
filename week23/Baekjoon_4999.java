package week23;

import java.io.*;
import java.util.*;

public class Baekjoon_4999 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		String canSpeak = br.readLine();
		String required = br.readLine();
		
		if (canSpeak.length() >= required.length())
			System.out.println("go");
		else
			System.out.println("no");
	}

}

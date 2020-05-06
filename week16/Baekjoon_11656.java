package week16;

import java.io.*;
import java.util.*;

public class Baekjoon_11656 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String input = br.readLine();
		
		ArrayList<String> al = new ArrayList<>();
		for (int i=0; i<input.length(); i++)
			al.add(input.substring(i));
		
		al.sort(null);
		
		StringBuilder sb = new StringBuilder();
		for (int i=0; i<al.size(); i++)
			sb.append(al.get(i)).append('\n');
		System.out.println(sb);
		
		
	}

}

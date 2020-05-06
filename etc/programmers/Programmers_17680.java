package etc.programmers;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class Programmers_17680 {

	public static void main(String[] args) {
		Solution s = new Solution();
//		int cacheSize = 3;
//		String[] cities = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"};
		int cacheSize = 2;
		String[] cities = {"Jeju", "Pangyo", "NewYork", "newyork"};
//		int cacheSize = 0;
//		String[] cities = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA"};
		int ans = s.solution(cacheSize, cities);
		System.out.println(ans);
	}
	
	static class Solution {
		
		static class City implements Comparable<City>{
			String city;
			int usedTime;
			
			public City(String city, int usedTime) {
				this.city = city;
				this.usedTime = usedTime;
			}
			
			public int compareTo(City c) {
				return this.usedTime - c.usedTime;
			}
		}
		
		public int solution(int cacheSize, String[] cities) {
			
			int ans = 0;
			
			Set<String> hs = new HashSet<>();
			PriorityQueue<City> pq = new PriorityQueue<>();
			
			for (int i=0; i<cities.length; i++) {
				String now = cities[i].toLowerCase();
				
				if (hs.contains(now)) {
					ans++;
					
					for (City c : pq) {
						if (c.city.equals(now)) {
							c.usedTime = i;
							pq.remove(c);
							pq.add(c);
							break;
						}
					}
				} else {
					ans += 5;
					
					if (cacheSize > 0) {
						if (pq.size() == cacheSize) {
							hs.remove(pq.poll().city);
						}
						
						pq.add(new City(now, i));
						hs.add(now);
					}
				}
			}
			
			return ans;
		}
	}

}

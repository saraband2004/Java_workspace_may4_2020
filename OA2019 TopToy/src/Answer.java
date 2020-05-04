import java.io.*; 
import java.util.*; 
import java.lang.*;

class MyCom implements Comparator<String>{
	HashMap<String, Integer> count;
	public MyCom (HashMap<String, Integer> count) {
		this.count = count;
	}
	public int compare (String a, String b) {
		if (count.get(a.toLowerCase())!=count.get(b.toLowerCase())) {
			return count.get(a.toLowerCase())-count.get(b.toLowerCase());
		}
		return b.compareTo(a);
	}
}


class Solution{
	
	
	public List<String> topToy(int numToys, int topToys, String[] toys, int numQuotes, String[] quotes){
		LinkedList<String> result = new LinkedList<>();
		HashMap<String, Integer> count = new HashMap<>();
		HashMap<String, Integer> countDiff = new HashMap<>();
		for (String toy: toys) {
			count.put(toy.toLowerCase(), 0);
			countDiff.put(toy.toLowerCase(), 0);
		}
		for (String quote: quotes) {
			process(quote, count, countDiff);
		}
		
		System.out.println(count);
		System.out.println(countDiff);
		
		PriorityQueue<String> pq = new PriorityQueue<>(new MyCom(count));
		for (String toy: toys) {
			pq.offer(toy);
			if (pq.size() > topToys) pq.poll();
		}
		while(!pq.isEmpty()) {
			result.addFirst(pq.poll());
		}		
		return result;
	}
	
	public void process(String quote, HashMap<String, Integer> count, HashMap<String, Integer> countDiff) {
		String[] strs = quote.split("\\W+");
		HashSet<String> set = new HashSet<>();
		for (String str: strs) {
			if (count.containsKey(str.toLowerCase())) {
				count.put(str.toLowerCase(), count.get(str.toLowerCase())+1);
				if (!set.contains(str.toLowerCase())) countDiff.put(str.toLowerCase(), countDiff.get(str.toLowerCase())+1);
				set.add(str.toLowerCase());
			}
		}
	}
	
}
public class Answer {
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Solution s = new Solution();
		int numToys = 6;
		int topToys = 2;
		String[] toys = {"elmo", "elsa", "legos", "drone", "tablet", "warcraft"};
		int numQuotes = 6;
		String[] quotes = {
				"Elmo is the hottest of the season! Elmo will be on every kid's wishlist!",
				"The new Elmo dolls are super high quality",
				"Expect the Elsa dolls to be very popular this year, Elsa!",
				"Elsa and Elmo are the toys I'll be buying for my kids, Elsa is good",
				"For parents of older kids, look into buying them a drone",
				"Warcraft is slowly rising in popularity ahead of the holiday season"
		};
		Solution s = new Solution();
		System.out.println(s.topToy(numToys, topToys, toys, numQuotes, quotes));
		System.out.println("finallxy");
	}
}

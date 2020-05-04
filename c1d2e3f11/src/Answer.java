import java.io.*; 
import java.util.*; 
import java.lang.*;








import java.io.*; 
import java.util.*; 
import java.lang.*;

//1152. Analyze User Website Visit Pattern

class Node {
    String name;
    String website;
    int time;
    public Node (String name, String website, int time) {
        this.name = name;
        this.website = website;
        this.time = time;
        
    }
    public void print() {
    	System.out.println(time +" "+  website + " " + name);
    }
}

class Solution {
    public List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
        HashMap<String, List<String>> userMap = new HashMap<>();
        
        for (String user : username) {
        	if (!userMap.containsKey(user)) {
        		userMap.put(user, new ArrayList<>());	
        	}        	
        }
        
        Node [] nodes = new Node[username.length];
        
        for (int i = 0 ; i < username.length ; i ++ ) {
            nodes[i] = new Node (username[i], website[i], timestamp[i]);
        	//userMap.get(username[i]).add(website[i]);
        }
        
        Arrays.sort(nodes, (Node a, Node b) -> a.time - b.time);
        for (Node node: nodes){
            userMap.get(node.name).add(node.website);
            node.print();
        }
        
        
        HashMap<List<String>, HashSet<String>> map = new HashMap<>();
        
        for (String name: userMap.keySet()) {
        	System.out.println(userMap.get(name));
        	LinkedList<String> list3 = new LinkedList<>();
//        	for (String web: userMap.get(name)) {
//        		list3.add(web);
//        		if (list3.size() == 3) {
//        			if (!map.containsKey(list3)){
//        				map.put(new LinkedList<>(list3), new HashSet<>());
//        			}
//        			map.get(list3).add(name);
//        			list3.removeFirst();
//        		}        		
//        	}
        }
        
        int max = 0;
        
        PriorityQueue<List<String>> pq = new PriorityQueue<>(new MyCom());
        
        for (List<String> list3 : map.keySet()) {
        	if (map.get(list3).size() > max) {
        		pq.clear();
        		max = map.get(list3).size();
        		pq.offer(list3);
        	}
        	else if (map.get(list3).size() == max) {
        		pq.offer(list3);
        	}
        }
        System.out.println(pq);
        return pq.poll();
    }
}


class MyCom implements Comparator<List<String>> {
	public int compare(List<String> a , List<String >  b) {
		for (int i =0 ; i < 3; i ++) {
			if (a.get(i).compareTo(b.get(i))!=0) {
				return a.get(i).compareTo(b.get(i));
			}
		}
		return 0;
	}
}


//["zkiikgv","zkiikgv","zkiikgv","zkiikgv"]
	//	[436363475,710406388,386655081,797150921]
		//		["wnaaxbfhxp","mryxsjc","oz","wlarkzzqht"]


public class Answer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("hello");
		String [] username = {"zkiikgv","zkiikgv","zkiikgv","zkiikgv"};
		int[] timestamp = {436363475,710406388,386655081,797150921};
		String [] website = {"wnaaxbfhxp","mryxsjc","oz","wlarkzzqht"};
		
		
		
		System.out.println(new Solution().mostVisitedPattern(username, timestamp, website));
	}
}



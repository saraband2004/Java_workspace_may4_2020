import java.io.*; 
import java.util.*; 
import java.lang.*;
class MYCOMPARE implements Comparator<tweet>{
	public int compare(tweet a, tweet b) {
		if (a == null && b == null) {return 0;}
		if (a == null) {return 1;}
		if (b == null) {return -1;}
		
		if (a.TIME  > b.TIME) {return -1;}
		return -1;
	}
	
	
}
class tweet{
	public int TWEETID;
	public int TIME;
	public tweet NEXT;
	public tweet(int tweetid, int time) {
		TWEETID = tweetid;
		TIME = time;
		NEXT = null;
	}
}
class tweetuser{
	public int USERID;
	public HashSet<Integer> FOLLOWING;
	public tweet LATESTTWEET;
	public tweetuser(int userId) {
		USERID = userId;
		FOLLOWING = new HashSet<Integer>();
		FOLLOWING.add(userId);
		LATESTTWEET = null;
	}
}

class Twitter {
	HashMap<Integer, tweetuser> map;
	public int time;
    /** Initialize your data structure here. */
    public Twitter() {
        map = new HashMap<>();
        time = Integer.MIN_VALUE;
    }
    
    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
    	tweetuser newuser;
    	if (!map.containsKey(userId)) {
    		newuser = new tweetuser(userId);
    		map.put(userId, newuser);
    	}
    	else {
    		newuser = map.get(userId);
    	}
        tweet x = newuser.LATESTTWEET;
    	newuser.LATESTTWEET = new tweet(tweetId, time);
    	newuser.LATESTTWEET.NEXT = x;
    	time++;
     }
    
    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
    	if (!map.containsKey(userId)) {
    		return new ArrayList<Integer>();
    	}
    	tweetuser USER = map.get(userId);
    	
    	
   // 	System.out.println(USER.USERID);
    	Iterator ITE = USER.FOLLOWING.iterator();
    	
//    	//else {return new ArrayList<Integer>();}
    	PriorityQueue <tweet> pq = new PriorityQueue<>(10,new MYCOMPARE());
    	
    	while (ITE.hasNext()) {
    		tweetuser userr = map.get(ITE.next());
    		if (userr.LATESTTWEET!=null)pq.offer(userr.LATESTTWEET);
    		//System.out.println(userr.LATESTTWEET);
    	}
    	int size = 10;
    	
    	List<Integer> result =new ArrayList<>();
    	tweet temp;
    	while (size > 0 && !pq.isEmpty()) {
    		temp = pq.poll();
    		if (temp!=null) {
    			if (temp.NEXT!=null) {
    			pq.offer(temp.NEXT);
    			}
    			result.add(temp.TWEETID);
    			size--;
   // 			System.out.println("x");
    		}
    		
    	}
    	return result;
//    	return null;
    }
    
    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
    	tweetuser Fer;
    	if (!map.containsKey(followerId)) {
    		Fer = new tweetuser(followerId);
    		map.put(followerId, Fer);
    	}
    	else {
    		Fer = map.get(followerId);
    	}
    	
    	tweetuser Fee;
    	if (!map.containsKey(followeeId)) {
    		Fee = new tweetuser(followeeId);
    		map.put(followeeId, Fee);
    	}
    	else {
    		Fee = map.get(followeeId);
    	}
    	
    	Fer.FOLLOWING.add(Fee.USERID);
    	
    	
    }
    
    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
    	tweetuser s;
    	if (followerId ==  followeeId) {return;}
        if (map.containsKey(followerId)) {
        	s=map.get(followerId);
        	if (s.FOLLOWING.contains(followeeId)) {
        		
        		map.get(followerId).FOLLOWING.remove(followeeId);
        	}
        	
        	
        }
    	
    	
    }
}

public class Solution {

	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		["Twitter","postTweet","getNewsFeed","follow","getNewsFeed","unfollow","getNewsFeed"]
//				[[],[1,1],[1],[2,1],[2],[2,1],[2]]
		Twitter t= new Twitter();
		t.postTweet(1, 1);
		t.getNewsFeed(1);
		t.follow(2, 1);
		t.getNewsFeed(2);
		t.unfollow(2,1 );
		t.getNewsFeed(2);

		
		
		HashSet<String> pq =new HashSet<>();
		String s=null;
		pq.add(s);
		
	}   
 

}

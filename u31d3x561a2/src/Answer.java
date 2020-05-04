import java.io.*; 
import java.util.*; 
import java.lang.*;

class Pair{
	Integer start;
	Integer end;
	int N;
	public void print() {
		System.out.println(start + " :: " + end +" size: " +size());
	}
	public int seat() {
		if (start == null) return 0;
		if (end == null) return N-1;
		return (start + end) / 2;
	}
	public int size() {
		if (start == null && end == null) return N  ;
		if (start == null ) {
			return end;
		}
		if (end == null) {
			return N - 1 - start;
		}
		int mid = (start + end)/2;
		return mid - start;		
	} 
	
	public Pair(int N, Integer start, Integer end) {
		this.N = N;
		this.start = start;
		this.end   = end;
	}
	
	public List<Pair> split(){
		List<Pair> list = new ArrayList<>();
		if (start == null) {
			list.add( new Pair(N, 0, end) );
			return list;
		}
		
		if (end == null) {
			list.add( new Pair (N, start,  N-1));
			return list;
		}
		
		
		int mid = (start + end)/2;
		Pair a = new Pair(N, start, mid);
		Pair b = new Pair(N, mid, end);
		
		list.add(a) ;
		list.add(b) ;
		return list;
	}
}

class MyCom implements Comparator<Pair>{
	public int compare(Pair a, Pair b) {
		if (a.size()!= b.size()) {
			return  - a.size() + b.size();
		}
		if (a.start == null || b.start == null) {
			if (a.start == null && b.start == null) {
				return 0;
			}
			if (a.start == null) {
				return - 1;
			}
			if (b.start == null) {
				return 1;
			}
			return 0;
		}
		return a.start - b.start;
	}
}


class ExamRoom {
	TreeSet<Pair> tree = new TreeSet<>(new MyCom());
	HashMap<Integer , Pair> startMap = new HashMap<>();
	HashMap<Integer , Pair> endMap = new HashMap<>();
	int N ; 
    public ExamRoom(int N) {
        this.N = N;
        Pair  p = new Pair(N, null, null);
        tree.add(p);
        startMap.put(null, p);
        endMap.put(null, p);        
    }
    
    public int seat() {
        Pair pair = tree.pollFirst();
        int ans = pair.seat();
        startMap.remove(pair.start);
        endMap.remove(pair.end);
        for (Pair p: pair.split()) {
        	tree.add(p);
        	startMap.put(p.start, p);
        	endMap.put(p.end, p);        	
        }
        return ans;
    }
    
    public void leave(int p) {
    	if (p == 0) {
    		Pair a = startMap.get(0);
    		startMap.remove(0);
    		endMap.remove(a.end);
    		tree.remove(a);
    		
    		Pair c = new Pair(N, null, a.end);
    		startMap.put(c.start, c);
    		endMap.put(c.end, c);
    		tree.add(c);
    		return;
    	}
    	
    	if (p == N-1) {
    		Pair a = endMap.get(N-1);
    		endMap.remove(N-1);
    		startMap.remove(a.start);
    		tree.remove(a);
    		
    		Pair c = new Pair(N, a.start, null);
    		startMap.put(c.start, c);
    		endMap.put(c.end, c);
    		tree.add(c);
    		return;
    	}
    	  	
    	
    	
        Pair b = startMap.get(p);
        Pair a = endMap.get(p);
        startMap.remove(p);
        endMap.remove(p);
       
        if (a!=null) {
        	endMap.remove(a.end);
            startMap.remove(a.start);
        }
        if (b!=null) {
        	startMap.remove(b.start);
            endMap.remove(b.end);
        }
        
        tree.remove(a);
        tree.remove(b);
        
        Pair c = new Pair(N, a!=null? a.start: null, b!=null? b.end: null);
        startMap.put(c.start, c);
        endMap.put(c.end, c);
        tree.add(c);
    }
    public void print() {
    	System.out.println(tree);
    	System.out.println(startMap);
    	System.out.println(endMap);
    	System.out.println(" ");
    }
}

/**
 * Your ExamRoom object will be instantiated and called as such:
 * ExamRoom obj = new ExamRoom(N);
 * int param_1 = obj.seat();
 * obj.leave(p);
 */

public class Answer {
	public static void main(String[] args) {
 
		ExamRoom er = new ExamRoom(10);
		System.out.println(er.seat());
		System.out.println(er.seat());
		System.out.println(er.seat());

		System.out.println(er.seat());
		System.out.println(er.seat());
		System.out.println(er.seat());
		System.out.println(er.seat());
		System.out.println(er.seat());
		System.out.println(er.seat());
		
		System.out.println(er.seat());
		
		er.print();
		
		er.leave(9);
		er.print();
//		er.leave(8);
		System.out.println(er.seat());
//		System.out.println(er.seat());
//		
//		
//		er.leave(0);
//		er.leave(8);
//		
		//System.out.println(er.seat());
		//System.out.println(er.seat());
	 
	}
}

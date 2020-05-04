import java.io.*; 
import java.util.*; 
import java.lang.*;

class Heap<C>{
	ArrayList<C> list = new ArrayList<>();
	
	public boolean isEmpty() {
		return list.size() == 0;
	}
	
	
	public C poll() {
		if (list.size() == 0) return null;
		C c = list.get(0);
		list.set(0, list.get(list.size() - 1));
		list.remove(list.size() - 1);	
		int i = 0;
		while (2 * i + 1 < list.size()) {
			if (2 * i+ 2 < list.size()) {
				if (myCom.compare(list.get(i), list.get(2*i + 2)) > 0 && myCom.compare(list.get(i), list.get(2*i + 1)) > 0 ) {
					if (myCom.compare(list.get(2*i + 1), list.get(2*i + 2)) > 0) {
						swap(i, 2*i + 2);
						i = 2*i + 2;						
					}
					else {
						swap(i, 2*i + 1);
						i = 2*i + 1;
					}					
				}
				else if (myCom.compare(list.get(i), list.get(2*i+1)) > 0) {
					swap(i, 2*i+1);
					i = 2*i + 1;
				}
				else if (myCom.compare(list.get(i), list.get(2*i+2)) > 0) {
					swap(i, 2*i+2);
					i = 2*i + 2;
				}
				else break;
				continue;
			}
			
			if (myCom.compare(list.get(i), list.get(2*i+1)) > 0) {
				swap(i, 2*i+1);
				i = 2*i + 1;
			}
			else break;
		}				
		return c;
	}
	private void swap(int x, int y) {
		C temp = list.get(x);
		list.set(x, list.get(y));
		list.set(y, temp);
	} 
	
	
	Comparator<C> myCom;
	public Heap(Comparator<C> myCom) {
		this.myCom = myCom;
	}
	
	public C peek() {
		if (list.size()!=0) return list.get(0);
		return null;
	}
	public boolean offer(C c) {
		int i = list.size();
		list.add(c);
		while (i > 0) {
			if (myCom.compare(list.get((i-1)/2), list.get(i))>0) {
				swap((i-1)/2, i);
				i = (i-1)/2;
			}
			else break;
		}
		if (2*i+1 < list.size() && myCom.compare(list.get(i), list.get(2*i+1)) > 0) {
			swap(i, 2*i+1);
		}
		else if (2*i+2 < list.size() && myCom.compare(list.get(i), list.get(2*i+2)) > 0) {
			swap(i, 2*i+2);
		}		
		return true;
	}
}
class MyCom implements Comparator<Integer>{
	public int compare(Integer a, Integer b) {
		return a.compareTo(b);
	}
}


public class Answer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyCom myCom = new MyCom();
		Heap<Integer> heap = new Heap<>(myCom);
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		Random rng = new Random();
		int x = rng.nextInt(55);
		for (int i = 0; i< 1000000; i++) {
			x = rng.nextInt(100);
			pq.offer(x);
			heap.offer(x);
			x = rng.nextInt(100);
			pq.offer(x);
			heap.offer(x);
			
			pq.poll();
			heap.poll();
		}
		
		
		while(!heap.isEmpty()) {
			//System.out.println(heap.list);
			
			if (heap.poll() != pq.poll())System.out.println("error");
		}
		
		System.out.println(   );
		BitSet bt;
		
		
	}

}

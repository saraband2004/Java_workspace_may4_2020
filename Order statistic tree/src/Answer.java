import java.io.*; 
import java.util.*; 
import java.lang.*;
import java.io.*; 
import java.util.*; 
import java.lang.*;


class Solution{
	public Node root;
    public List<Integer> countSmaller(int[] nums) {
    	
    	LinkedList<Integer> result = new LinkedList<>();
        if (nums.length == 0) return result;
        
        HashSet<Integer> set = new HashSet<>();
		for (int num: nums) {
			set.add(num);
		}
		List<Integer> list = new ArrayList<>(set);
		Integer[] arr = list.toArray(new Integer[0]);
		Arrays.sort(arr);
		
		this.root = new Node (arr, 0, arr.length - 1);
		
		for (int i = nums.length - 1; i >= 0 ; i -- ) {
			result.addFirst(root.rank(nums[i] - 1));
			root.add(nums[i]);
		}
		return result;
	}
}

class Node {
	public int value;
	public int count = 0;
	public Node left;
	public Node right;
	private Integer[] arr;
	
	public void add(int val) {
		count ++ ;
		if (val == value) {
			return;
		}
		if (val < value) {
			left.add(val);
		}
		else {
			right.add(val);
		}
	}
	
	public int rank(int bound) { //less or equal to val
		int ans = 0;
		if (bound == value) {
			ans = count;
			if (right!=null) ans -= right.count;
			return ans;
		}
		if (bound < value) {
			return left == null ? 0 : left.rank(bound);
		}
		if (bound > value) {
			ans = count;
			if (right!=null) ans -= right.count;
			ans += right ==  null? 0: right.rank(bound);
			return ans;
		}
		return 0;
	}
	
	
	public Node (Integer[] arr, int start, int end) {
		this.arr = arr;
		if (start == end) {
			value = arr[start];
			return ;
		}
		
		int mid = (start + end) / 2;
		value = arr[mid];
		
		if (start <= mid - 1) left = new Node (arr, start, mid - 1);
		if (mid + 1 <= end) right = new Node (arr, mid + 1, end);		
	}
	
	public void print() {
		System.out.println(value);
		if (left!=null) left.print();
		if (right!=null) right.print();
	}
	public Integer select(int i) {
		if (i > count) {
			return null;
		}
		if (left!=null && i <= left.count) {
			return left.select(i);
		}
		int total = i;
		total -= left!=null? left.count: 0;
		if (total == 1) return value;
		total -= 1;
		return right.select(total);
	}
}

 


public class Answer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {0,1,2,3,4,5,6,7};
		Solution s = new Solution();
		
		System.out.println(s.countSmaller(nums));
		System.out.println(s.root.rank(2));
		System.out.println(s.root.rank(5));
		System.out.println(s.root.select(5));
		System.out.println(s.root.select(1));
		
 
	}

}

 
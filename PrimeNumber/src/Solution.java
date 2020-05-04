import java.io.*; 
import java.util.*; 
import java.lang.*;








public class Solution {

	public static void PNT(int x, List<Integer> primes) {
		
		int n=2;
		int count;
		while(n<x) {
			count=0;
			for (int p: primes) {
				if (n%p == 0) {
					count++;
					break;
				}
				if ((p*p)>n+1) {break;}
			}
			if (count == 0) {
				primes.add(n);
				//System.out.println(n);
			}
			n++;
		}
		
	}
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.print(true);
		List<Integer> primes=new ArrayList<>();
		PNT((int )Math.pow(2,10), primes);
		System.out.println("finished");
		int count=primes.size()-1;
		
//		for (int p: primes) {
//			count++;
//			if (count%100000==0){System.out.println((double) count / (((double)p) / Math.log((double)p)));}
//		}
		
		int p=primes.get(count);
		{System.out.println((double) count / (((double)p) / Math.log((double)p)));}
		System.out.println("count: "+count);
		
		
		
	}

}

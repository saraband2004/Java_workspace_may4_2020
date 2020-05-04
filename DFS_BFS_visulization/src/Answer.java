import java.io.*; 
import java.util.*; 
import java.lang.*;
class Solution{
	Scanner sc = new Scanner(System.in);
	
	
	
	public<D> void  print(D [][] matrix) {
		for (int i=0; i<matrix.length; i++) {
			System.out.println(Arrays.toString(matrix[i]));
		}
	} 
	public boolean inMatrix(int i, int j, int N) {
		if (i >= 0 && j >= 0 && i < N && j < N) return true;
		
		return false;
	}
	
	public void BFS() {
		int N = 13;
		Character[][] matrix = new Character[N][N];
		for (int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				matrix[i][j] = ' ';
			}
		}
		//set.add(0);
		print(matrix);
		HashSet<Integer> hset = new HashSet<>();
		Queue<Integer> q = new LinkedList<>();
		int i = 2;
		int j = 3;
		q.offer(i + j*N);
		hset.add(i + j*N);
		while (!q.isEmpty()) {
			int x = q.poll();
			i = x%N;
			j = x/N;
			matrix[i][j] = 'X';
			sc.nextLine();
			print(matrix);
			i ++ ;
			if (inMatrix(i, j, N) && !hset.contains(i + j*N)) {
				hset.add(i+j*N);
				q.offer(i+j*N);
			}
			i --; i --;
			if (inMatrix(i, j, N) && !hset.contains(i + j*N)) {
				hset.add(i+j*N);
				q.offer(i+j*N);
			}			
			i ++ ; j++;
			if (inMatrix(i, j, N) && !hset.contains(i + j*N)) {
				hset.add(i+j*N);
				q.offer(i+j*N);
			}
			j -- ; j -- ;
			if (inMatrix(i, j, N) && !hset.contains(i + j*N)) {
				hset.add(i+j*N);
				q.offer(i+j*N);
			}			
		}
		
		
	}
	
	public void DFS() {
		int N = 13;
		Character[][] matrix = new Character[N][N];
		for (int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				matrix[i][j] = ' ';
			}
		}
		//set.add(0);
		print(matrix);
		dfs(3,5, N, matrix);
	}
	HashSet<Integer> set = new HashSet<>();
	
	public void dfs(int i, int j, int N, Character[][] matrix ) {
		if (i >= 0 && j >= 0 && i < N && j < N) {
			if (!set.contains(i+j*N)) {
				set.add(i + j*N);
				matrix[i][j] = 'X';
				sc.nextLine();
				
				print(matrix);
				
				dfs(i + 1, j, N, matrix);
				dfs(i , j+ 1, N, matrix);
				dfs(i - 1, j, N, matrix);
				dfs(i , j- 1, N, matrix);
												
			}
		}
	}
}
 
public class Answer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		s.DFS() ;
		
		s.BFS()  ;
		
		
	}

}

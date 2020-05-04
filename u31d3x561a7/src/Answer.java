import java.io.*; 
import java.util.*; 
import java.lang.*;

class Solution{
    public static void gameOfLife(int[][] board) {
        for (int i = 0; i < board.length ; i ++ ) {
        	for (int j = 0; j < board[0].length ; j ++ ) {
        		if (board[i][j] == 1) {
        			if (neighbour(board, i, j) == 2 || neighbour(board, i, j) == 3) {
        				board[i][j] += 10;
        			}
        		}
        		else {
        			if (neighbour(board, i, j) == 3 ) {
        				board[i][j] += 10;
        			}
        		}
        	}        	
        }
        for (int i = 0; i < board.length ; i ++ ) {
        	for (int j = 0; j < board[0].length ; j ++ ) {
        		board[i][j] /= 10;
        	}        	
        }
        print(board);
    }
    public static void print(int[][] board) {
    	for (int[] b: board) {
    		System.out.println(Arrays.toString(b));
    	}
    }
    public static int neighbour(int[][] board, int x, int y) {
    	int count = 0;
    	for (int i = x - 1; i <= x + 1; i ++ ) {
    		for (int j = y - 1; j <= y + 1; j ++ ) {
    			count += isLive(board, i, j);
    		}
    	}
    	count -= isLive(board, x, y);
    	return count;
    }
    public static int isLive(int[][] board, int i, int j) {
    	if (i < 0 || j < 0 || i >= board.length || j >= board[0].length) {
    		return 0;
    	}
    	if (board[i][j]%10 == 1) {
    		return 1;
    	}
    	return 0;
    }
} 

public class Answer {
	public static void main(String[] args) {
		int[][] board = {
				  {0,0,0},
				  {0,0,0},
				  {1,1,1},
				  {0,0,0}
				};
		String s = "";
		Scanner sc = new Scanner(System.in);

		while (1 == 1) {
			s = sc.nextLine();
			Solution.gameOfLife(board);
		}
	}
}

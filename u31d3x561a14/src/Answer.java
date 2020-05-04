import java.io.*; 
import java.util.*; 
import java.lang.*;

import java.io.*;
import java.util.*;

/*
 * To execute Java, please define 'static void main' on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

class Solution {
  public void solveSudoku(char[][] board) {
    dfs(board, 0,0);    
  }
    
  public boolean dfs(char[][] board, int x, int y){
    if (y == 9){
      return true;
    }
    if (x == 9){
      return dfs(board, 0, y+1);      
    }
    if (board[x][y] != '.'){
      return dfs(board, x+1, y);
    }  
    for (char val = '1'; val <= '9' ; val ++) {
    	board[x][y] = val;
    	if (!isValid(board, x, y)) {
    		continue;
    	}
    	if (dfs(board, x + 1, y)) {
    		return true;
    	}   	
    }
    board[x][y] = '.';
    return false;
  }
        
        
  public boolean isValid(char[][] board, int x, int y) {
    int[] count = new int[10];
    
    for (int i = 0; i < 9; i ++ ){
      if (board[i][y]!='.'){
        count[board[i][y] - '0']++;
        if (count[board[i][y] - '0'] == 2){
          return false;
        }
      }
    }
    
    Arrays.fill(count, 0);
    
    for (int i = 0; i < 9; i ++ ){
      if (board[x][i]!='.'){
        count[board[x][i] - '0']++;
        if (count[board[x][i] - '0'] == 2){
          return false;
        }
      }
    }
    
    Arrays.fill(count, 0);
    x/=3;
    y/=3;
    
    for (int i = 0; i <3; i++){
      for (int j=0; j <3; j++){
        if (board[3*x + i][3*y + j]!= '.'){
          count[board[3*x + i][3*y + j] - '0'] ++ ;
          if (count[board[3*x + i][3*y + j] - '0'] == 2){
            return false;
          }        
        }
      }
    }
    return true;    
  }
  
  public void print(char[][] board) {
	  for (char[] line : board) {
		  System.out.println(Arrays.toString(line));
	  }
  }
}




 


public class Answer {
	public static void main(String[] args) {
		Solution s = new Solution();
		
		char[][]board = {{'5','3','.','.','7','.','.','.','.'},{'6','.','.','1','9','5','.','.','.'},{'.','9','8','.','.','.','.','6','.'},{'8','.','.','.','6','.','.','.','3'},{'4','.','.','8','.','3','.','.','1'},{'7','.','.','.','2','.','.','.','6'},{'.','6','.','.','.','.','2','8','.'},{'.','.','.','4','1','9','.','.','5'},{'.','.','.','.','8','.','.','7','9'}};
		
		for (int i = 0; i < 9 ; i ++ ) {
			for (int j = 0; j < 9 ; j ++ ) {
				board[i][j] = '.';
			}
			
		}
		
		
		s.print(board);
		s.solveSudoku(board);;
		s.print(board);

	}
}

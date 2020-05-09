import java.io.*; 
import java.util.*; 
import java.lang.*;



public class Answer {
	public static void main(String[] args) {
		Board board = new Board(4,4,4);
		
		System.out.println("tIc tAc tOe");

//		board.brd = new char[][] {
//				{'a','b','a'},
//				{'b','a','b'},
//				{'b','e','b'}
//		};
		
		board.print();
		 
		ComputerPlayer cpu1 = new ComputerPlayer('A','B',board);
		ComputerPlayer cpu2 = new ComputerPlayer('B','A',board);
		for (int i = 0 ; i <12; i ++ ) {
			cpu1.nextMove();
			cpu2.nextMove();
			board.print();
			
		}
		System.out.println(cpu1.memo.size());
	}
}

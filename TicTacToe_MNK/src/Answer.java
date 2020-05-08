import java.io.*; 
import java.util.*; 
import java.lang.*;



public class Answer {
	public static void main(String[] args) {
		Board board = new Board(4,4,3);
		board.print();
		System.out.println("tIc tAc tOe");
		board.put(0, 1, 'a');
		ComputerPlayer cpu = new ComputerPlayer('b','a',board);
		cpu.nextMove();
		board.print();
	}
}

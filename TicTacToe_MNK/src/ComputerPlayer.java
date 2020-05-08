import java.io.*; 
import java.util.*; 
import java.lang.*;
 

enum Game{
	WIN, LOSS, DRAW;	
}


public class ComputerPlayer {
	int M, N, K;
	char p;
	char q;
	Board board;
	public ComputerPlayer(char p, char q, Board board) {
		this.M = board.M;
		this.N = board.N;
		this.K = board.K;		
		this.p = p;
		this.q = q;
		this.board = board;
	}
	
	public void nextMove() {
		LinkedList<int[]> drawList = new LinkedList<>();
		
		for (int i = 0 ; i < M; i ++ ) {
			for (int j = 0 ; j < N; j ++ ) {
				if (board.isAvailable(i, j)) {
					Game res = dfs(i, j, p, q);
					if (res == Game.WIN) {
						board.put(i, j, p);
						return ;
					}
					else if (res == Game.LOSS) {
						drawList.addLast(new int[] {i, j});
					}
					else {
						drawList.addFirst(new int[] {i, j});
					}
				}
			}
		}
		board.put(drawList.getFirst()[0], drawList.getFirst()[1], p);	
	}	
	public Game dfs(int x, int y, char p, char q) {
		if (board.win(x, y, p)) {
			return Game.WIN;			
		}
		board.put(x, y, p);
		boolean win = true;
		for (int i = 0 ; i < M; i ++ ) {
			for (int j = 0 ; j < N; j ++ ) {
				if (board.isAvailable(i, j)) {

					Game res = dfs(i, j, q, p);
					if (res == Game.WIN) {
						board.put(x, y, 'e');
						return Game.LOSS;
					}
					else if (res == Game.DRAW) {
						win = false;
					}
				}				
			}
		}
		board.put(x, y, 'e');		
		if (!win) {
			return Game.DRAW;
		}
		return Game.WIN;
	}
}

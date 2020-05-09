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
	HashMap<String, Game> memo = new HashMap<>();
	public void nextMove() {
		LinkedList<int[]> drawList = new LinkedList<>();
		boolean full = true;
		for (int i = 0 ; i < M; i ++ ) {
			for (int j = 0 ; j < N; j ++ ) {

				if (board.isAvailable(i, j)) {
					full = false;
					if (board.win(i, j , p)) {
						System.out.println("CPU "+p+" wins");
						board.put(i, j, p);						
						return ;
					}
					
					Game res = dfs(i, j, p, q);
					if (res == Game.WIN) {
						System.out.println("CPU "+p+" will win");
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
		if (full) {
			System.out.println("Draw!");
			return;
		}
		board.put(drawList.getFirst()[0], drawList.getFirst()[1], p);	
	}	
	public Game dfs(int x, int y, char p, char q) {
		if (board.win(x, y, p)) {
			return Game.WIN;			
		}
		board.put(x, y, p);
		
		String str = board.serialize();
		if (memo.containsKey(str)) {
			board.put(x, y, 'e');
			return memo.get(str);
		}
				
		boolean win = true;
		boolean full = true;
		for (int i = 0 ; i < M; i ++ ) {
			for (int j = 0 ; j < N; j ++ ) {
				if (board.isAvailable(i, j)) {
					full = false;
					Game res = dfs(i, j, q, p);
					if (res == Game.WIN) {
						board.put(x, y, 'e');
						memo.put(str, Game.LOSS);
						return Game.LOSS;
					}
					else if (res == Game.DRAW) {
						win = false;
					}
				}				
			}
		}
		board.put(x, y, 'e');	
		
		if (full||!win) {
			//System.out.println("draw");
			memo.put(str, Game.DRAW);
			return Game.DRAW;
		}
		memo.put(str, Game.WIN);
		return Game.WIN;
	}
}

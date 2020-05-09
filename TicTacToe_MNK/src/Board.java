import java.util.Arrays;

class Board {
	int M;
	int N;
	int K;
	char[][] brd;
	public Board(int M, int N, int K) {
		this.M = M;
		this.N = N;
		this.K = K;
		brd = new char[M][N];
		for (int i = 0; i < M; i ++ ) {
			for (int j = 0; j < N; j ++ ) {
				brd[i][j] = 'e';
			}
		}
	}
	
	public void print() {
		for (int i = 0; i < M ; i ++ ) {
			System.out.println(Arrays.toString(brd[i]));
		}
		System.out.println("-------------------");
	}
	public boolean isAvailable(int x, int y) {
		if (brd[x][y] != 'e'){
			return false;
		}
		return true;
	}
	public boolean put(int x, int y, char p) {
 		brd[x][y] = p;
		return true;
	}
	
	int[][][] dirs = {{{1,0}, {-1,0}},
					  {{0,1}, {0,-1}},
					  {{1,1}, {-1,-1}},
					  {{-1,1}, {1,-1}}};
	
	public boolean win(int x, int y, char p){
		if (brd[x][y] != 'e'){
			return false;
		}
		int i, j;		
		int count = 0;
		for (int[][] dir: dirs) {
			count = 1;
			for (int[] di: dir) {
				i = x+di[0];
				j = y+di[1];
				while (i >= 0&& j >= 0 && i < M && j < N) {
					if (brd[i][j] == p) {
						count ++;						
					}
					else break;
					i += di[0];
					j += di[1];
				}
			}
			if (count >= K){
				//System.out.println(p + " wins!!!\n");
				return true;
			}
		}				
		return false;
	}
	public String serialize() {
		String res = "";
		for (char[] line: brd) {
			res = res + new String(line);			
		}
		return res;
	}
}
